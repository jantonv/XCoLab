package com.ext.portlet.model.impl;

import com.ext.portlet.model.ProposalAttribute;
import com.ext.portlet.model.ProposalAttributeModel;
import com.ext.portlet.model.ProposalAttributeSoap;
import com.ext.portlet.service.persistence.ProposalAttributePK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

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
            { "proposalId", Types.BIGINT },
            { "version", Types.INTEGER },
            { "name", Types.VARCHAR },
            { "additionalId", Types.BIGINT },
            { "numericValue", Types.BIGINT },
            { "stringValue", Types.CLOB },
            { "realValue", Types.DOUBLE }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ProposalAttribute (proposalId LONG not null,version INTEGER not null,name VARCHAR(75) not null,additionalId LONG not null,numericValue LONG,stringValue TEXT null,realValue DOUBLE,primary key (proposalId, version, name, additionalId))";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ProposalAttribute";
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
    public static long PROPOSALID_COLUMN_BITMASK = 1L;
    public static long VERSION_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ProposalAttribute"));
    private static ClassLoader _classLoader = ProposalAttribute.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            ProposalAttribute.class
        };
    private long _proposalId;
    private long _originalProposalId;
    private boolean _setOriginalProposalId;
    private int _version;
    private int _originalVersion;
    private boolean _setOriginalVersion;
    private String _name;
    private long _additionalId;
    private long _numericValue;
    private String _stringValue;
    private double _realValue;
    private long _columnBitmask;
    private ProposalAttribute _escapedModelProxy;

    public ProposalAttributeModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ProposalAttribute toModel(ProposalAttributeSoap soapModel) {
        ProposalAttribute model = new ProposalAttributeImpl();

        model.setProposalId(soapModel.getProposalId());
        model.setVersion(soapModel.getVersion());
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
        List<ProposalAttribute> models = new ArrayList<ProposalAttribute>(soapModels.length);

        for (ProposalAttributeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public ProposalAttributePK getPrimaryKey() {
        return new ProposalAttributePK(_proposalId, _version, _name,
            _additionalId);
    }

    public void setPrimaryKey(ProposalAttributePK primaryKey) {
        setProposalId(primaryKey.proposalId);
        setVersion(primaryKey.version);
        setName(primaryKey.name);
        setAdditionalId(primaryKey.additionalId);
    }

    public Serializable getPrimaryKeyObj() {
        return new ProposalAttributePK(_proposalId, _version, _name,
            _additionalId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((ProposalAttributePK) primaryKeyObj);
    }

    public Class<?> getModelClass() {
        return ProposalAttribute.class;
    }

    public String getModelClassName() {
        return ProposalAttribute.class.getName();
    }

    @JSON
    public long getProposalId() {
        return _proposalId;
    }

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
    public int getVersion() {
        return _version;
    }

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
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    public void setName(String name) {
        _name = name;
    }

    @JSON
    public long getAdditionalId() {
        return _additionalId;
    }

    public void setAdditionalId(long additionalId) {
        _additionalId = additionalId;
    }

    @JSON
    public long getNumericValue() {
        return _numericValue;
    }

    public void setNumericValue(long numericValue) {
        _numericValue = numericValue;
    }

    @JSON
    public String getStringValue() {
        if (_stringValue == null) {
            return StringPool.BLANK;
        } else {
            return _stringValue;
        }
    }

    public void setStringValue(String stringValue) {
        _stringValue = stringValue;
    }

    @JSON
    public double getRealValue() {
        return _realValue;
    }

    public void setRealValue(double realValue) {
        _realValue = realValue;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ProposalAttribute toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (ProposalAttribute) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        ProposalAttributeImpl proposalAttributeImpl = new ProposalAttributeImpl();

        proposalAttributeImpl.setProposalId(getProposalId());
        proposalAttributeImpl.setVersion(getVersion());
        proposalAttributeImpl.setName(getName());
        proposalAttributeImpl.setAdditionalId(getAdditionalId());
        proposalAttributeImpl.setNumericValue(getNumericValue());
        proposalAttributeImpl.setStringValue(getStringValue());
        proposalAttributeImpl.setRealValue(getRealValue());

        proposalAttributeImpl.resetOriginalValues();

        return proposalAttributeImpl;
    }

    public int compareTo(ProposalAttribute proposalAttribute) {
        ProposalAttributePK primaryKey = proposalAttribute.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ProposalAttribute proposalAttribute = null;

        try {
            proposalAttribute = (ProposalAttribute) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        ProposalAttributePK primaryKey = proposalAttribute.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public void resetOriginalValues() {
        ProposalAttributeModelImpl proposalAttributeModelImpl = this;

        proposalAttributeModelImpl._originalProposalId = proposalAttributeModelImpl._proposalId;

        proposalAttributeModelImpl._setOriginalProposalId = false;

        proposalAttributeModelImpl._originalVersion = proposalAttributeModelImpl._version;

        proposalAttributeModelImpl._setOriginalVersion = false;

        proposalAttributeModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ProposalAttribute> toCacheModel() {
        ProposalAttributeCacheModel proposalAttributeCacheModel = new ProposalAttributeCacheModel();

        proposalAttributeCacheModel.proposalId = getProposalId();

        proposalAttributeCacheModel.version = getVersion();

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
        StringBundler sb = new StringBundler(15);

        sb.append("{proposalId=");
        sb.append(getProposalId());
        sb.append(", version=");
        sb.append(getVersion());
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

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ProposalAttribute");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>proposalId</column-name><column-value><![CDATA[");
        sb.append(getProposalId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>version</column-name><column-value><![CDATA[");
        sb.append(getVersion());
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
