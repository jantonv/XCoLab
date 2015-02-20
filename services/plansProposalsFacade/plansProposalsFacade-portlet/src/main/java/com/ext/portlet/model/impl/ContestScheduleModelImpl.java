package com.ext.portlet.model.impl;

import com.ext.portlet.model.ContestSchedule;
import com.ext.portlet.model.ContestScheduleModel;
import com.ext.portlet.model.ContestScheduleSoap;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ContestSchedule service. Represents a row in the &quot;xcolab_ContestSchedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ContestScheduleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContestScheduleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestScheduleImpl
 * @see com.ext.portlet.model.ContestSchedule
 * @see com.ext.portlet.model.ContestScheduleModel
 * @generated
 */
@JSON(strict = true)
public class ContestScheduleModelImpl extends BaseModelImpl<ContestSchedule>
    implements ContestScheduleModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a contest schedule model instance should use the {@link com.ext.portlet.model.ContestSchedule} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ContestSchedule";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "name", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "status", Types.VARCHAR },
            { "baseScheduleId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ContestSchedule (id_ LONG not null primary key,name VARCHAR(75) null,description VARCHAR(75) null,status VARCHAR(75) null,baseScheduleId LONG)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ContestSchedule";
    public static final String ORDER_BY_JPQL = " ORDER BY contestSchedule.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_ContestSchedule.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ContestSchedule"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ContestSchedule"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ContestSchedule"));
    private static ClassLoader _classLoader = ContestSchedule.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ContestSchedule.class
        };
    private long _id;
    private String _name;
    private String _description;
    private String _status;
    private Long _baseScheduleId;
    private ContestSchedule _escapedModel;

    public ContestScheduleModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ContestSchedule toModel(ContestScheduleSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        ContestSchedule model = new ContestScheduleImpl();

        model.setId(soapModel.getId());
        model.setName(soapModel.getName());
        model.setDescription(soapModel.getDescription());
        model.setStatus(soapModel.getStatus());
        model.setBaseScheduleId(soapModel.getBaseScheduleId());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ContestSchedule> toModels(
        ContestScheduleSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<ContestSchedule> models = new ArrayList<ContestSchedule>(soapModels.length);

        for (ContestScheduleSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return ContestSchedule.class;
    }

    @Override
    public String getModelClassName() {
        return ContestSchedule.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("status", getStatus());
        attributes.put("baseScheduleId", getBaseScheduleId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Long baseScheduleId = (Long) attributes.get("baseScheduleId");

        if (baseScheduleId != null) {
            setBaseScheduleId(baseScheduleId);
        }
    }

    @JSON
    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;
    }

    @JSON
    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @JSON
    @Override
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    @Override
    public void setDescription(String description) {
        _description = description;
    }

    @JSON
    @Override
    public String getStatus() {
        if (_status == null) {
            return StringPool.BLANK;
        } else {
            return _status;
        }
    }

    @Override
    public void setStatus(String status) {
        _status = status;
    }

    @JSON
    @Override
    public Long getBaseScheduleId() {
        return _baseScheduleId;
    }

    @Override
    public void setBaseScheduleId(Long baseScheduleId) {
        _baseScheduleId = baseScheduleId;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            ContestSchedule.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public ContestSchedule toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ContestSchedule) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ContestScheduleImpl contestScheduleImpl = new ContestScheduleImpl();

        contestScheduleImpl.setId(getId());
        contestScheduleImpl.setName(getName());
        contestScheduleImpl.setDescription(getDescription());
        contestScheduleImpl.setStatus(getStatus());
        contestScheduleImpl.setBaseScheduleId(getBaseScheduleId());

        contestScheduleImpl.resetOriginalValues();

        return contestScheduleImpl;
    }

    @Override
    public int compareTo(ContestSchedule contestSchedule) {
        long primaryKey = contestSchedule.getPrimaryKey();

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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContestSchedule)) {
            return false;
        }

        ContestSchedule contestSchedule = (ContestSchedule) obj;

        long primaryKey = contestSchedule.getPrimaryKey();

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
    }

    @Override
    public CacheModel<ContestSchedule> toCacheModel() {
        ContestScheduleCacheModel contestScheduleCacheModel = new ContestScheduleCacheModel();

        contestScheduleCacheModel.id = getId();

        contestScheduleCacheModel.name = getName();

        String name = contestScheduleCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            contestScheduleCacheModel.name = null;
        }

        contestScheduleCacheModel.description = getDescription();

        String description = contestScheduleCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            contestScheduleCacheModel.description = null;
        }

        contestScheduleCacheModel.status = getStatus();

        String status = contestScheduleCacheModel.status;

        if ((status != null) && (status.length() == 0)) {
            contestScheduleCacheModel.status = null;
        }

        contestScheduleCacheModel.baseScheduleId = getBaseScheduleId();

        return contestScheduleCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", baseScheduleId=");
        sb.append(getBaseScheduleId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ContestSchedule");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>baseScheduleId</column-name><column-value><![CDATA[");
        sb.append(getBaseScheduleId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
