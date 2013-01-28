package com.ext.portlet.model.impl;

import com.ext.portlet.model.ModelOutputItem;
import com.ext.portlet.service.ModelOutputItemLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ModelOutputItem service. Represents a row in the &quot;xcolab_ModelOutputItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ModelOutputItemImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModelOutputItemImpl
 * @see com.ext.portlet.model.ModelOutputItem
 * @generated
 */
public abstract class ModelOutputItemBaseImpl extends ModelOutputItemModelImpl
    implements ModelOutputItem {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a model output item model instance should use the {@link ModelOutputItem} interface instead.
     */
    public void persist() throws SystemException {
        if (this.isNew()) {
            ModelOutputItemLocalServiceUtil.addModelOutputItem(this);
        } else {
            ModelOutputItemLocalServiceUtil.updateModelOutputItem(this);
        }
    }
}
