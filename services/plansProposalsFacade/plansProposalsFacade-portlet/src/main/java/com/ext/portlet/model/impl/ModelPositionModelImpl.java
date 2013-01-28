package com.ext.portlet.model.impl;

import com.ext.portlet.model.ModelPosition;
import com.ext.portlet.model.ModelPositionModel;
import com.ext.portlet.model.ModelPositionSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
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
 * The base model implementation for the ModelPosition service. Represents a row in the &quot;xcolab_ModelPosition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ModelPositionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ModelPositionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModelPositionImpl
 * @see com.ext.portlet.model.ModelPosition
 * @see com.ext.portlet.model.ModelPositionModel
 * @generated
 */
@JSON(strict = true)
public class ModelPositionModelImpl extends BaseModelImpl<ModelPosition>
    implements ModelPositionModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a model position model instance should use the {@link com.ext.portlet.model.ModelPosition} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ModelPosition";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "positionId", Types.BIGINT },
            { "modelId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ModelPosition (id_ LONG not null primary key,positionId LONG,modelId LONG)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ModelPosition";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ModelPosition"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ModelPosition"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.ModelPosition"),
            true);
    public static long MODELID_COLUMN_BITMASK = 1L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ModelPosition"));
    private static ClassLoader _classLoader = ModelPosition.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            ModelPosition.class
        };
    private long _id;
    private long _positionId;
    private long _modelId;
    private long _originalModelId;
    private boolean _setOriginalModelId;
    private transient ExpandoBridge _expandoBridge;
    private long _columnBitmask;
    private ModelPosition _escapedModelProxy;

    public ModelPositionModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ModelPosition toModel(ModelPositionSoap soapModel) {
        ModelPosition model = new ModelPositionImpl();

        model.setId(soapModel.getId());
        model.setPositionId(soapModel.getPositionId());
        model.setModelId(soapModel.getModelId());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ModelPosition> toModels(ModelPositionSoap[] soapModels) {
        List<ModelPosition> models = new ArrayList<ModelPosition>(soapModels.length);

        for (ModelPositionSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return ModelPosition.class;
    }

    public String getModelClassName() {
        return ModelPosition.class.getName();
    }

    @JSON
    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    @JSON
    public long getPositionId() {
        return _positionId;
    }

    public void setPositionId(long positionId) {
        _positionId = positionId;
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

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ModelPosition toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (ModelPosition) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
                    ModelPosition.class.getName(), getPrimaryKey());
        }

        return _expandoBridge;
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        getExpandoBridge().setAttributes(serviceContext);
    }

    @Override
    public Object clone() {
        ModelPositionImpl modelPositionImpl = new ModelPositionImpl();

        modelPositionImpl.setId(getId());
        modelPositionImpl.setPositionId(getPositionId());
        modelPositionImpl.setModelId(getModelId());

        modelPositionImpl.resetOriginalValues();

        return modelPositionImpl;
    }

    public int compareTo(ModelPosition modelPosition) {
        long primaryKey = modelPosition.getPrimaryKey();

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

        ModelPosition modelPosition = null;

        try {
            modelPosition = (ModelPosition) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = modelPosition.getPrimaryKey();

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
        ModelPositionModelImpl modelPositionModelImpl = this;

        modelPositionModelImpl._originalModelId = modelPositionModelImpl._modelId;

        modelPositionModelImpl._setOriginalModelId = false;

        modelPositionModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ModelPosition> toCacheModel() {
        ModelPositionCacheModel modelPositionCacheModel = new ModelPositionCacheModel();

        modelPositionCacheModel.id = getId();

        modelPositionCacheModel.positionId = getPositionId();

        modelPositionCacheModel.modelId = getModelId();

        return modelPositionCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", positionId=");
        sb.append(getPositionId());
        sb.append(", modelId=");
        sb.append(getModelId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ModelPosition");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>positionId</column-name><column-value><![CDATA[");
        sb.append(getPositionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelId</column-name><column-value><![CDATA[");
        sb.append(getModelId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
