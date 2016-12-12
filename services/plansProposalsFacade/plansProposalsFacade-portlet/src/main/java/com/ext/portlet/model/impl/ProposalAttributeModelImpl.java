package com.ext.portlet.model.impl;

import com.ext.portlet.model.ProposalAttribute;
import com.ext.portlet.model.ProposalAttributeModel;
import com.ext.portlet.model.ProposalAttributeSoap;

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
 * The base model implementation for the ProposalAttribute service. Represents a row in the &quot;xcolab_ProposalAttribute&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ProposalAttributeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProposalAttributeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalAttributeImpl
 * @see com.ext.portlet.model.ProposalAttribute
 * @see com.ext.portlet.model.ProposalAttributeModel
 * @generated
 */
@JSON(strict = true)
public class ProposalAttributeModelImpl extends BaseModelImpl<ProposalAttribute>
    implements ProposalAttributeModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a proposal attribute model instance should use the {@link com.ext.portlet.model.ProposalAttribute} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ProposalAttribute";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "proposalId", Types.BIGINT },
            { "version", Types.INTEGER },
            { "versionWhenCreated", Types.INTEGER },
            { "name", Types.VARCHAR },
            { "additionalId", Types.BIGINT },
            { "numericValue", Types.BIGINT },
            { "stringValue", Types.VARCHAR },
            { "realValue", Types.DOUBLE }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ProposalAttribute (id_ LONG not null primary key,proposalId LONG,version INTEGER,versionWhenCreated INTEGER,name VARCHAR(75) null,additionalId LONG,numericValue LONG,stringValue VARCHAR(75) null,realValue DOUBLE)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ProposalAttribute";
    public static final String ORDER_BY_JPQL = " ORDER BY proposalAttribute.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_ProposalAttribute.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ProposalAttribute"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ProposalAttribute"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.ProposalAttribute"),
            true);
    public static long ADDITIONALID_COLUMN_BITMASK = 1L;
    public static long NAME_COLUMN_BITMASK = 2L;
    public static long PROPOSALID_COLUMN_BITMASK = 4L;
    public static long VERSION_COLUMN_BITMASK = 8L;
    public static long VERSIONWHENCREATED_COLUMN_BITMASK = 16L;
    public static long ID_COLUMN_BITMASK = 32L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ProposalAttribute"));
    private static ClassLoader _classLoader = ProposalAttribute.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ProposalAttribute.class
        };
    private long _id;
    private long _proposalId;
    private long _originalProposalId;
    private boolean _setOriginalProposalId;
    private int _version;
    private int _originalVersion;
    private boolean _setOriginalVersion;
    private int _versionWhenCreated;
    private int _originalVersionWhenCreated;
    private boolean _setOriginalVersionWhenCreated;
    private String _name;
    private String _originalName;
    private long _additionalId;
    private long _originalAdditionalId;
    private boolean _setOriginalAdditionalId;
    private long _numericValue;
    private String _stringValue;
    private double _realValue;
    private long _columnBitmask;
    private ProposalAttribute _escapedModel;

    public ProposalAttributeModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ProposalAttribute toModel(ProposalAttributeSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        ProposalAttribute model = new ProposalAttributeImpl();

        model.setId(soapModel.getId());
        model.setProposalId(soapModel.getProposalId());
        model.setVersion(soapModel.getVersion());
        model.setVersionWhenCreated(soapModel.getVersionWhenCreated());
        model.setName(soapModel.getName());
        model.setAdditionalId(soapModel.getAdditionalId());
        model.setNumericValue(soapModel.getNumericValue());
        model.setStringValue(soapModel.getStringValue());
        model.setRealValue(soapModel.getRealValue());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ProposalAttribute> toModels(
        ProposalAttributeSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<ProposalAttribute> models = new ArrayList<ProposalAttribute>(soapModels.length);

        for (ProposalAttributeSoap soapModel : soapModels) {
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
        return ProposalAttribute.class;
    }

    @Override
    public String getModelClassName() {
        return ProposalAttribute.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("proposalId", getProposalId());
        attributes.put("version", getVersion());
        attributes.put("versionWhenCreated", getVersionWhenCreated());
        attributes.put("name", getName());
        attributes.put("additionalId", getAdditionalId());
        attributes.put("numericValue", getNumericValue());
        attributes.put("stringValue", getStringValue());
        attributes.put("realValue", getRealValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Long proposalId = (Long) attributes.get("proposalId");

        if (proposalId != null) {
            setProposalId(proposalId);
        }

        Integer version = (Integer) attributes.get("version");

        if (version != null) {
            setVersion(version);
        }

        Integer versionWhenCreated = (Integer) attributes.get(
                "versionWhenCreated");

        if (versionWhenCreated != null) {
            setVersionWhenCreated(versionWhenCreated);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Long additionalId = (Long) attributes.get("additionalId");

        if (additionalId != null) {
            setAdditionalId(additionalId);
        }

        Long numericValue = (Long) attributes.get("numericValue");

        if (numericValue != null) {
            setNumericValue(numericValue);
        }

        String stringValue = (String) attributes.get("stringValue");

        if (stringValue != null) {
            setStringValue(stringValue);
        }

        Double realValue = (Double) attributes.get("realValue");

        if (realValue != null) {
            setRealValue(realValue);
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
    public long getProposalId() {
        return _proposalId;
    }

    @Override
    public void setProposalId(long proposalId) {
        _columnBitmask |= PROPOSALID_COLUMN_BITMASK;

        if (!_setOriginalProposalId) {
            _setOriginalProposalId = true;

            _originalProposalId = _proposalId;
        }

        _proposalId = proposalId;
    }

    public long getOriginalProposalId() {
        return _originalProposalId;
    }

    @JSON
    @Override
    public int getVersion() {
        return _version;
    }

    @Override
    public void setVersion(int version) {
        _columnBitmask |= VERSION_COLUMN_BITMASK;

        if (!_setOriginalVersion) {
            _setOriginalVersion = true;

            _originalVersion = _version;
        }

        _version = version;
    }

    public int getOriginalVersion() {
        return _originalVersion;
    }

    @JSON
    @Override
    public int getVersionWhenCreated() {
        return _versionWhenCreated;
    }

    @Override
    public void setVersionWhenCreated(int versionWhenCreated) {
        _columnBitmask |= VERSIONWHENCREATED_COLUMN_BITMASK;

        if (!_setOriginalVersionWhenCreated) {
            _setOriginalVersionWhenCreated = true;

            _originalVersionWhenCreated = _versionWhenCreated;
        }

        _versionWhenCreated = versionWhenCreated;
    }

    public int getOriginalVersionWhenCreated() {
        return _originalVersionWhenCreated;
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
        _columnBitmask |= NAME_COLUMN_BITMASK;

        if (_originalName == null) {
            _originalName = _name;
        }

        _name = name;
    }

    public String getOriginalName() {
        return GetterUtil.getString(_originalName);
    }

    @JSON
    @Override
    public long getAdditionalId() {
        return _additionalId;
    }

    @Override
    public void setAdditionalId(long additionalId) {
        _columnBitmask |= ADDITIONALID_COLUMN_BITMASK;

        if (!_setOriginalAdditionalId) {
            _setOriginalAdditionalId = true;

            _originalAdditionalId = _additionalId;
        }

        _additionalId = additionalId;
    }

    public long getOriginalAdditionalId() {
        return _originalAdditionalId;
    }

    @JSON
    @Override
    public long getNumericValue() {
        return _numericValue;
    }

    @Override
    public void setNumericValue(long numericValue) {
        _numericValue = numericValue;
    }

    @JSON
    @Override
    public String getStringValue() {
        if (_stringValue == null) {
            return StringPool.BLANK;
        } else {
            return _stringValue;
        }
    }

    @Override
    public void setStringValue(String stringValue) {
        _stringValue = stringValue;
    }

    @JSON
    @Override
    public double getRealValue() {
        return _realValue;
    }

    @Override
    public void setRealValue(double realValue) {
        _realValue = realValue;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            ProposalAttribute.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public ProposalAttribute toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ProposalAttribute) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ProposalAttributeImpl proposalAttributeImpl = new ProposalAttributeImpl();

        proposalAttributeImpl.setId(getId());
        proposalAttributeImpl.setProposalId(getProposalId());
        proposalAttributeImpl.setVersion(getVersion());
        proposalAttributeImpl.setVersionWhenCreated(getVersionWhenCreated());
        proposalAttributeImpl.setName(getName());
        proposalAttributeImpl.setAdditionalId(getAdditionalId());
        proposalAttributeImpl.setNumericValue(getNumericValue());
        proposalAttributeImpl.setStringValue(getStringValue());
        proposalAttributeImpl.setRealValue(getRealValue());

        proposalAttributeImpl.resetOriginalValues();

        return proposalAttributeImpl;
    }

    @Override
    public int compareTo(ProposalAttribute proposalAttribute) {
        long primaryKey = proposalAttribute.getPrimaryKey();

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

        if (!(obj instanceof ProposalAttribute)) {
            return false;
        }

        ProposalAttribute proposalAttribute = (ProposalAttribute) obj;

        long primaryKey = proposalAttribute.getPrimaryKey();

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
        ProposalAttributeModelImpl proposalAttributeModelImpl = this;

        proposalAttributeModelImpl._originalProposalId = proposalAttributeModelImpl._proposalId;

        proposalAttributeModelImpl._setOriginalProposalId = false;

        proposalAttributeModelImpl._originalVersion = proposalAttributeModelImpl._version;

        proposalAttributeModelImpl._setOriginalVersion = false;

        proposalAttributeModelImpl._originalVersionWhenCreated = proposalAttributeModelImpl._versionWhenCreated;

        proposalAttributeModelImpl._setOriginalVersionWhenCreated = false;

        proposalAttributeModelImpl._originalName = proposalAttributeModelImpl._name;

        proposalAttributeModelImpl._originalAdditionalId = proposalAttributeModelImpl._additionalId;

        proposalAttributeModelImpl._setOriginalAdditionalId = false;

        proposalAttributeModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ProposalAttribute> toCacheModel() {
        ProposalAttributeCacheModel proposalAttributeCacheModel = new ProposalAttributeCacheModel();

        proposalAttributeCacheModel.id = getId();

        proposalAttributeCacheModel.proposalId = getProposalId();

        proposalAttributeCacheModel.version = getVersion();

        proposalAttributeCacheModel.versionWhenCreated = getVersionWhenCreated();

        proposalAttributeCacheModel.name = getName();

        String name = proposalAttributeCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            proposalAttributeCacheModel.name = null;
        }

        proposalAttributeCacheModel.additionalId = getAdditionalId();

        proposalAttributeCacheModel.numericValue = getNumericValue();

        proposalAttributeCacheModel.stringValue = getStringValue();

        String stringValue = proposalAttributeCacheModel.stringValue;

        if ((stringValue != null) && (stringValue.length() == 0)) {
            proposalAttributeCacheModel.stringValue = null;
        }

        proposalAttributeCacheModel.realValue = getRealValue();

        return proposalAttributeCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", proposalId=");
        sb.append(getProposalId());
        sb.append(", version=");
        sb.append(getVersion());
        sb.append(", versionWhenCreated=");
        sb.append(getVersionWhenCreated());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", additionalId=");
        sb.append(getAdditionalId());
        sb.append(", numericValue=");
        sb.append(getNumericValue());
        sb.append(", stringValue=");
        sb.append(getStringValue());
        sb.append(", realValue=");
        sb.append(getRealValue());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ProposalAttribute");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>proposalId</column-name><column-value><![CDATA[");
        sb.append(getProposalId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>version</column-name><column-value><![CDATA[");
        sb.append(getVersion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>versionWhenCreated</column-name><column-value><![CDATA[");
        sb.append(getVersionWhenCreated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>additionalId</column-name><column-value><![CDATA[");
        sb.append(getAdditionalId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>numericValue</column-name><column-value><![CDATA[");
        sb.append(getNumericValue());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stringValue</column-name><column-value><![CDATA[");
        sb.append(getStringValue());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>realValue</column-name><column-value><![CDATA[");
        sb.append(getRealValue());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
