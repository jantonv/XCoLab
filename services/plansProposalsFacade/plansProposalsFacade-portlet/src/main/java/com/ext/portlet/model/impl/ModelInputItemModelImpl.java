package com.ext.portlet.model.impl;

import com.ext.portlet.model.ModelInputItem;
import com.ext.portlet.model.ModelInputItemModel;
import com.ext.portlet.model.ModelInputItemSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * The base model implementation for the ModelInputItem service. Represents a row in the &quot;xcolab_ModelInputItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ModelInputItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ModelInputItemImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModelInputItemImpl
 * @see com.ext.portlet.model.ModelInputItem
 * @see com.ext.portlet.model.ModelInputItemModel
 * @generated
 */
@JSON(strict = true)
public class ModelInputItemModelImpl extends BaseModelImpl<ModelInputItem>
    implements ModelInputItemModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a model input item model instance should use the {@link com.ext.portlet.model.ModelInputItem} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ModelInputItem";
    public static final Object[][] TABLE_COLUMNS = {
            { "modelInputItemPK", Types.BIGINT },
            { "modelId", Types.BIGINT },
            { "modelInputItemID", Types.BIGINT },
            { "modelGroupId", Types.BIGINT },
            { "displayItemOrder", Types.INTEGER },
            { "type_", Types.VARCHAR },
            { "properties", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ModelInputItem (modelInputItemPK LONG not null primary key,modelId LONG,modelInputItemID LONG,modelGroupId LONG,displayItemOrder INTEGER,type_ VARCHAR(256) null,properties VARCHAR(2048) null)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ModelInputItem";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ModelInputItem"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ModelInputItem"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.ModelInputItem"),
            true);
    public static long MODELGROUPID_COLUMN_BITMASK = 1L;
    public static long MODELID_COLUMN_BITMASK = 2L;
    public static long MODELINPUTITEMID_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ModelInputItem"));
    private static ClassLoader _classLoader = ModelInputItem.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            ModelInputItem.class
        };
    private long _modelInputItemPK;
    private long _modelId;
    private long _originalModelId;
    private boolean _setOriginalModelId;
    private long _modelInputItemID;
    private long _originalModelInputItemID;
    private boolean _setOriginalModelInputItemID;
    private long _modelGroupId;
    private long _originalModelGroupId;
    private boolean _setOriginalModelGroupId;
    private int _displayItemOrder;
    private String _type;
    private String _properties;
    private transient ExpandoBridge _expandoBridge;
    private long _columnBitmask;
    private ModelInputItem _escapedModelProxy;

    public ModelInputItemModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ModelInputItem toModel(ModelInputItemSoap soapModel) {
        ModelInputItem model = new ModelInputItemImpl();

        model.setModelInputItemPK(soapModel.getModelInputItemPK());
        model.setModelId(soapModel.getModelId());
        model.setModelInputItemID(soapModel.getModelInputItemID());
        model.setModelGroupId(soapModel.getModelGroupId());
        model.setDisplayItemOrder(soapModel.getDisplayItemOrder());
        model.setType(soapModel.getType());
        model.setProperties(soapModel.getProperties());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ModelInputItem> toModels(ModelInputItemSoap[] soapModels) {
        List<ModelInputItem> models = new ArrayList<ModelInputItem>(soapModels.length);

        for (ModelInputItemSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _modelInputItemPK;
    }

    public void setPrimaryKey(long primaryKey) {
        setModelInputItemPK(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_modelInputItemPK);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return ModelInputItem.class;
    }

    public String getModelClassName() {
        return ModelInputItem.class.getName();
    }

    @JSON
    public long getModelInputItemPK() {
        return _modelInputItemPK;
    }

    public void setModelInputItemPK(long modelInputItemPK) {
        _modelInputItemPK = modelInputItemPK;
    }

    @JSON
    public long getModelId() {
        return _modelId;
    }

    public void setModelId(long modelId) {
        _columnBitmask |= MODELID_COLUMN_BITMASK;

        if (!_setOriginalModelId) {
            _setOriginalModelId = true;

            _originalModelId = _modelId;
        }

        _modelId = modelId;
    }

    public long getOriginalModelId() {
        return _originalModelId;
    }

    @JSON
    public long getModelInputItemID() {
        return _modelInputItemID;
    }

    public void setModelInputItemID(long modelInputItemID) {
        _columnBitmask |= MODELINPUTITEMID_COLUMN_BITMASK;

        if (!_setOriginalModelInputItemID) {
            _setOriginalModelInputItemID = true;

            _originalModelInputItemID = _modelInputItemID;
        }

        _modelInputItemID = modelInputItemID;
    }

    public long getOriginalModelInputItemID() {
        return _originalModelInputItemID;
    }

    @JSON
    public long getModelGroupId() {
        return _modelGroupId;
    }

    public void setModelGroupId(long modelGroupId) {
        _columnBitmask |= MODELGROUPID_COLUMN_BITMASK;

        if (!_setOriginalModelGroupId) {
            _setOriginalModelGroupId = true;

            _originalModelGroupId = _modelGroupId;
        }

        _modelGroupId = modelGroupId;
    }

    public long getOriginalModelGroupId() {
        return _originalModelGroupId;
    }

    @JSON
    public int getDisplayItemOrder() {
        return _displayItemOrder;
    }

    public void setDisplayItemOrder(int displayItemOrder) {
        _displayItemOrder = displayItemOrder;
    }

    @JSON
    public String getType() {
        if (_type == null) {
            return StringPool.BLANK;
        } else {
            return _type;
        }
    }

    public void setType(String type) {
        _type = type;
    }

    @JSON
    public String getProperties() {
        if (_properties == null) {
            return StringPool.BLANK;
        } else {
            return _properties;
        }
    }

    public void setProperties(String properties) {
        _properties = properties;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ModelInputItem toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (ModelInputItem) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
                    ModelInputItem.class.getName(), getPrimaryKey());
        }

        return _expandoBridge;
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        getExpandoBridge().setAttributes(serviceContext);
    }

    @Override
    public Object clone() {
        ModelInputItemImpl modelInputItemImpl = new ModelInputItemImpl();

        modelInputItemImpl.setModelInputItemPK(getModelInputItemPK());
        modelInputItemImpl.setModelId(getModelId());
        modelInputItemImpl.setModelInputItemID(getModelInputItemID());
        modelInputItemImpl.setModelGroupId(getModelGroupId());
        modelInputItemImpl.setDisplayItemOrder(getDisplayItemOrder());
        modelInputItemImpl.setType(getType());
        modelInputItemImpl.setProperties(getProperties());

        modelInputItemImpl.resetOriginalValues();

        return modelInputItemImpl;
    }

    public int compareTo(ModelInputItem modelInputItem) {
        long primaryKey = modelInputItem.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ModelInputItem modelInputItem = null;

        try {
            modelInputItem = (ModelInputItem) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = modelInputItem.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        ModelInputItemModelImpl modelInputItemModelImpl = this;

        modelInputItemModelImpl._originalModelId = modelInputItemModelImpl._modelId;

        modelInputItemModelImpl._setOriginalModelId = false;

        modelInputItemModelImpl._originalModelInputItemID = modelInputItemModelImpl._modelInputItemID;

        modelInputItemModelImpl._setOriginalModelInputItemID = false;

        modelInputItemModelImpl._originalModelGroupId = modelInputItemModelImpl._modelGroupId;

        modelInputItemModelImpl._setOriginalModelGroupId = false;

        modelInputItemModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ModelInputItem> toCacheModel() {
        ModelInputItemCacheModel modelInputItemCacheModel = new ModelInputItemCacheModel();

        modelInputItemCacheModel.modelInputItemPK = getModelInputItemPK();

        modelInputItemCacheModel.modelId = getModelId();

        modelInputItemCacheModel.modelInputItemID = getModelInputItemID();

        modelInputItemCacheModel.modelGroupId = getModelGroupId();

        modelInputItemCacheModel.displayItemOrder = getDisplayItemOrder();

        modelInputItemCacheModel.type = getType();

        String type = modelInputItemCacheModel.type;

        if ((type != null) && (type.length() == 0)) {
            modelInputItemCacheModel.type = null;
        }

        modelInputItemCacheModel.properties = getProperties();

        String properties = modelInputItemCacheModel.properties;

        if ((properties != null) && (properties.length() == 0)) {
            modelInputItemCacheModel.properties = null;
        }

        return modelInputItemCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{modelInputItemPK=");
        sb.append(getModelInputItemPK());
        sb.append(", modelId=");
        sb.append(getModelId());
        sb.append(", modelInputItemID=");
        sb.append(getModelInputItemID());
        sb.append(", modelGroupId=");
        sb.append(getModelGroupId());
        sb.append(", displayItemOrder=");
        sb.append(getDisplayItemOrder());
        sb.append(", type=");
        sb.append(getType());
        sb.append(", properties=");
        sb.append(getProperties());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ModelInputItem");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>modelInputItemPK</column-name><column-value><![CDATA[");
        sb.append(getModelInputItemPK());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelId</column-name><column-value><![CDATA[");
        sb.append(getModelId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelInputItemID</column-name><column-value><![CDATA[");
        sb.append(getModelInputItemID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelGroupId</column-name><column-value><![CDATA[");
        sb.append(getModelGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>displayItemOrder</column-name><column-value><![CDATA[");
        sb.append(getDisplayItemOrder());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>type</column-name><column-value><![CDATA[");
        sb.append(getType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>properties</column-name><column-value><![CDATA[");
        sb.append(getProperties());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
