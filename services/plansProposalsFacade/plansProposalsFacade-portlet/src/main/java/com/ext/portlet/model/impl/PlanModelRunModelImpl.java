package com.ext.portlet.model.impl;

import com.ext.portlet.model.PlanModelRun;
import com.ext.portlet.model.PlanModelRunModel;
import com.ext.portlet.model.PlanModelRunSoap;

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
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the PlanModelRun service. Represents a row in the &quot;xcolab_PlanModelRun&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.PlanModelRunModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PlanModelRunImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanModelRunImpl
 * @see com.ext.portlet.model.PlanModelRun
 * @see com.ext.portlet.model.PlanModelRunModel
 * @generated
 */
@JSON(strict = true)
public class PlanModelRunModelImpl extends BaseModelImpl<PlanModelRun>
    implements PlanModelRunModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a plan model run model instance should use the {@link com.ext.portlet.model.PlanModelRun} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_PlanModelRun";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "planId", Types.BIGINT },
            { "scenarioId", Types.BIGINT },
            { "planVersion", Types.BIGINT },
            { "version", Types.BIGINT },
            { "created", Types.TIMESTAMP },
            { "updateAuthorId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_PlanModelRun (id_ LONG not null primary key,planId LONG,scenarioId LONG,planVersion LONG,version LONG,created DATE null,updateAuthorId LONG)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_PlanModelRun";
    public static final String ORDER_BY_JPQL = " ORDER BY planModelRun.id DESC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_PlanModelRun.id_ DESC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.PlanModelRun"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.PlanModelRun"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.PlanModelRun"),
            true);
    public static long PLANID_COLUMN_BITMASK = 1L;
    public static long PLANVERSION_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.PlanModelRun"));
    private static ClassLoader _classLoader = PlanModelRun.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            PlanModelRun.class
        };
    private long _id;
    private long _planId;
    private long _originalPlanId;
    private boolean _setOriginalPlanId;
    private long _scenarioId;
    private long _planVersion;
    private long _originalPlanVersion;
    private boolean _setOriginalPlanVersion;
    private long _version;
    private Date _created;
    private long _updateAuthorId;
    private transient ExpandoBridge _expandoBridge;
    private long _columnBitmask;
    private PlanModelRun _escapedModelProxy;

    public PlanModelRunModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static PlanModelRun toModel(PlanModelRunSoap soapModel) {
        PlanModelRun model = new PlanModelRunImpl();

        model.setId(soapModel.getId());
        model.setPlanId(soapModel.getPlanId());
        model.setScenarioId(soapModel.getScenarioId());
        model.setPlanVersion(soapModel.getPlanVersion());
        model.setVersion(soapModel.getVersion());
        model.setCreated(soapModel.getCreated());
        model.setUpdateAuthorId(soapModel.getUpdateAuthorId());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<PlanModelRun> toModels(PlanModelRunSoap[] soapModels) {
        List<PlanModelRun> models = new ArrayList<PlanModelRun>(soapModels.length);

        for (PlanModelRunSoap soapModel : soapModels) {
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
        return PlanModelRun.class;
    }

    public String getModelClassName() {
        return PlanModelRun.class.getName();
    }

    @JSON
    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _columnBitmask = -1L;

        _id = id;
    }

    @JSON
    public long getPlanId() {
        return _planId;
    }

    public void setPlanId(long planId) {
        _columnBitmask |= PLANID_COLUMN_BITMASK;

        if (!_setOriginalPlanId) {
            _setOriginalPlanId = true;

            _originalPlanId = _planId;
        }

        _planId = planId;
    }

    public long getOriginalPlanId() {
        return _originalPlanId;
    }

    @JSON
    public long getScenarioId() {
        return _scenarioId;
    }

    public void setScenarioId(long scenarioId) {
        _scenarioId = scenarioId;
    }

    @JSON
    public long getPlanVersion() {
        return _planVersion;
    }

    public void setPlanVersion(long planVersion) {
        _columnBitmask |= PLANVERSION_COLUMN_BITMASK;

        if (!_setOriginalPlanVersion) {
            _setOriginalPlanVersion = true;

            _originalPlanVersion = _planVersion;
        }

        _planVersion = planVersion;
    }

    public long getOriginalPlanVersion() {
        return _originalPlanVersion;
    }

    @JSON
    public long getVersion() {
        return _version;
    }

    public void setVersion(long version) {
        _version = version;
    }

    @JSON
    public Date getCreated() {
        return _created;
    }

    public void setCreated(Date created) {
        _created = created;
    }

    @JSON
    public long getUpdateAuthorId() {
        return _updateAuthorId;
    }

    public void setUpdateAuthorId(long updateAuthorId) {
        _updateAuthorId = updateAuthorId;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public PlanModelRun toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (PlanModelRun) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
                    PlanModelRun.class.getName(), getPrimaryKey());
        }

        return _expandoBridge;
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        getExpandoBridge().setAttributes(serviceContext);
    }

    @Override
    public Object clone() {
        PlanModelRunImpl planModelRunImpl = new PlanModelRunImpl();

        planModelRunImpl.setId(getId());
        planModelRunImpl.setPlanId(getPlanId());
        planModelRunImpl.setScenarioId(getScenarioId());
        planModelRunImpl.setPlanVersion(getPlanVersion());
        planModelRunImpl.setVersion(getVersion());
        planModelRunImpl.setCreated(getCreated());
        planModelRunImpl.setUpdateAuthorId(getUpdateAuthorId());

        planModelRunImpl.resetOriginalValues();

        return planModelRunImpl;
    }

    public int compareTo(PlanModelRun planModelRun) {
        int value = 0;

        if (getId() < planModelRun.getId()) {
            value = -1;
        } else if (getId() > planModelRun.getId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PlanModelRun planModelRun = null;

        try {
            planModelRun = (PlanModelRun) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = planModelRun.getPrimaryKey();

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
        PlanModelRunModelImpl planModelRunModelImpl = this;

        planModelRunModelImpl._originalPlanId = planModelRunModelImpl._planId;

        planModelRunModelImpl._setOriginalPlanId = false;

        planModelRunModelImpl._originalPlanVersion = planModelRunModelImpl._planVersion;

        planModelRunModelImpl._setOriginalPlanVersion = false;

        planModelRunModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<PlanModelRun> toCacheModel() {
        PlanModelRunCacheModel planModelRunCacheModel = new PlanModelRunCacheModel();

        planModelRunCacheModel.id = getId();

        planModelRunCacheModel.planId = getPlanId();

        planModelRunCacheModel.scenarioId = getScenarioId();

        planModelRunCacheModel.planVersion = getPlanVersion();

        planModelRunCacheModel.version = getVersion();

        Date created = getCreated();

        if (created != null) {
            planModelRunCacheModel.created = created.getTime();
        } else {
            planModelRunCacheModel.created = Long.MIN_VALUE;
        }

        planModelRunCacheModel.updateAuthorId = getUpdateAuthorId();

        return planModelRunCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", planId=");
        sb.append(getPlanId());
        sb.append(", scenarioId=");
        sb.append(getScenarioId());
        sb.append(", planVersion=");
        sb.append(getPlanVersion());
        sb.append(", version=");
        sb.append(getVersion());
        sb.append(", created=");
        sb.append(getCreated());
        sb.append(", updateAuthorId=");
        sb.append(getUpdateAuthorId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.PlanModelRun");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>planId</column-name><column-value><![CDATA[");
        sb.append(getPlanId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>scenarioId</column-name><column-value><![CDATA[");
        sb.append(getScenarioId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>planVersion</column-name><column-value><![CDATA[");
        sb.append(getPlanVersion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>version</column-name><column-value><![CDATA[");
        sb.append(getVersion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>created</column-name><column-value><![CDATA[");
        sb.append(getCreated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>updateAuthorId</column-name><column-value><![CDATA[");
        sb.append(getUpdateAuthorId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
