package org.xcolab.portlets.modelsadmin.web;

import edu.mit.cci.roma.client.Simulation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.xcolab.client.modeling.ModelingClientUtil;
import org.xcolab.client.modeling.roma.RomaClientUtil;
import org.xcolab.client.modeling.models.ui.IllegalUIConfigurationException;
import org.xcolab.client.modeling.models.ui.ModelDisplay;
import org.xcolab.client.modeling.models.ui.ModelInputDisplayItem;
import org.xcolab.client.modeling.models.ui.ModelInputIndividualDisplayItem;
import org.xcolab.client.modeling.models.ui.ModelInputWidgetType;
import org.xcolab.client.modeling.models.ui.ModelOutputDisplayItem;
import org.xcolab.client.modeling.models.ui.ModelOutputSeriesDisplayItem;
import org.xcolab.client.modeling.models.ui.ModelOutputSeriesType;
import org.xcolab.client.modeling.models.ui.ModelUIFactory;
import org.xcolab.client.modeling.pojo.ModelInputGroup;
import org.xcolab.client.modeling.pojo.ModelInputItem;
import org.xcolab.client.modeling.pojo.ModelOutputChartOrder;
import org.xcolab.portlets.modelsadmin.web.form.UpdateModelDisplayFromJSONBean;

import java.io.IOException;
import java.util.Collection;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@RequestMapping("view")
@Controller
public class UpdateModelDisplayFromJSONAction {

    @RequestMapping(params = {"action=updateModelDisplayFromJson", "modelId",
            "tab=modelDisplayByJSON"})
    public void update(ActionRequest request, ActionResponse response,
            UpdateModelDisplayFromJSONBean bean, @RequestParam Long modelId)
            throws IllegalUIConfigurationException, IOException, ParseException {

        Simulation simulation = RomaClientUtil.client().getSimulation(modelId);
        ModelDisplay modelDisplay = ModelUIFactory.getInstance().getDisplay(simulation);

        try {
            JSONObject conf = (JSONObject) new JSONParser().parse(bean.getJson());

            for (ModelInputGroup group : ModelingClientUtil.getInputGroups(simulation)) {
                ModelingClientUtil.deleteModelInputGroup(group.getModelInputGroupPK());
            }
            for (ModelInputItem item : ModelingClientUtil.getItemsForModel(simulation)) {
                item.setModelGroupId(0L);
                ModelingClientUtil.updateModelInputItem(item);
            }

            for (ModelOutputDisplayItem modi : modelDisplay.getOutputs()) {
                ModelOutputChartOrder
                        moco = ModelingClientUtil.getModelOutputChartOrder(simulation, modi.getName());
                ModelingClientUtil.deleteModelOutputChartOrder(moco);
            }

            // iterate over inputs and create appropriate groups/inputs config

            configureInputArray(modelId, modelDisplay, (JSONArray) conf.get("inputs"), 0, 0);

            configureOutputArray(modelDisplay, (JSONArray) conf.get("outputs"), 0);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    private int configureInputArray(long modelId, ModelDisplay modelDisplay, JSONArray inputArray,
            int order, long parentGroup) {
        for (int i = 0; i < inputArray.size(); i++) {
            configureInput(modelId, modelDisplay, (JSONObject) inputArray.get(i), order + i,
                    parentGroup);
        }
        return inputArray.size() + order;

    }

    private int configureInput(long modelId, ModelDisplay modelDisplay, JSONObject inputConf,
            int order, long parentGroup) {
        String type = (String) inputConf.get("type");
        int count = 1;
        if (type.equals("TAB") || type.equals("HORIZONTAL")) {
            ModelInputGroup group = new ModelInputGroup();
            group.setGroupType(type);
            group.setModelId(modelId);
            if (inputConf.containsKey("name")) {
                group.setName((String) inputConf.get("name"));
            }
            if (inputConf.containsKey("description")) {
                group.setDescription((String) inputConf.get("description"));
            }

            if (inputConf.containsKey("metaDataName")) {
                for (ModelInputDisplayItem metaDataItem : modelDisplay.getAllIndividualInputs()) {
                    if (metaDataItem.getName().equals(inputConf.get("metaDataName"))) {
                        group.setName(metaDataItem.getName());
                        group.setDescription(metaDataItem.getDescription());
                        group.setNameAndDescriptionMetaDataId(metaDataItem.getMetaData().getId());
                    }
                }
            }
            group.setDisplayItemOrder(order);
            group.setParentGroupPK(parentGroup);
            group = ModelingClientUtil.createModelInputGroup(group);

            if (inputConf.containsKey("children")) {
                JSONArray children = (JSONArray) inputConf.get("children");
                count += configureInputArray(modelId, modelDisplay, children, order + count + 1,
                        group.getModelInputGroupPK());
            }
        } else {
            String name = (String) inputConf.get("name");
            String description = (String) inputConf.get("description");
            boolean found = false;
            for (ModelInputDisplayItem displayItem : modelDisplay.getAllIndividualInputs()) {
                if (displayItem.getName().equals(name) && (description == null || description
                        .equals(displayItem.getDescription()))) {
                    found = true;
                    displayItem.setType(
                            ModelInputWidgetType.valueOf((String) inputConf.get("widget")));
                    displayItem.setOrder(order);
                    if (displayItem instanceof ModelInputIndividualDisplayItem) {
                        ((ModelInputIndividualDisplayItem) displayItem).setGroupId(parentGroup);
                        ;
                    }
                }
            }
            if (!found) {
                //TODO: logging
            }
        }
        return count;

    }


    private void configureOutputArray(ModelDisplay modelDisplay, JSONArray jsonArray,
            int order) {
        for (Object aJsonArray : jsonArray) {
            JSONObject outputObj = (JSONObject) aJsonArray;

            String name = (String) outputObj.get("name");
            Collection<ModelOutputDisplayItem> allOutputs =
                    ModelsAdminController.getAllOutputsFromDisplay(modelDisplay);

            for (ModelOutputDisplayItem item : allOutputs) {

                if (item.getName().equals(name)) {
                    item.setOrder(order++);


                    if (item instanceof ModelOutputSeriesDisplayItem) {
                        ModelOutputSeriesDisplayItem seriesItem =
                                (ModelOutputSeriesDisplayItem) item;
                        String chartType = (String) outputObj.get("chartType");
                        if (chartType != null) {
                            seriesItem.setSeriesType(ModelOutputSeriesType.valueOf(chartType));
                        }
                        String associatedMetaDataName = (String) outputObj.get("associatedOutput");
                        if (associatedMetaDataName != null) {
                            for (ModelOutputDisplayItem associatedItem : allOutputs) {
                                if (associatedItem instanceof ModelOutputSeriesDisplayItem
                                        && associatedItem.getName()
                                        .equals(associatedMetaDataName)) {
                                    seriesItem.setAssociatedMetaData(
                                            ((ModelOutputSeriesDisplayItem) associatedItem)
                                                    .getMetaData());
                                }
                            }
                        }

                    }
                }
            }

        }
    }

}
