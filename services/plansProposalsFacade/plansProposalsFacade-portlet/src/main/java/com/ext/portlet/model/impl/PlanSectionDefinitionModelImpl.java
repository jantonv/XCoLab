package com.ext.portlet.model.impl;

import com.ext.portlet.model.PlanSectionDefinition;
import com.ext.portlet.model.PlanSectionDefinitionModel;
import com.ext.portlet.model.PlanSectionDefinitionSoap;

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
 * The base model implementation for the PlanSectionDefinition service. Represents a row in the &quot;xcolab_PlanSectionDefinition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.PlanSectionDefinitionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PlanSectionDefinitionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanSectionDefinitionImpl
 * @see com.ext.portlet.model.PlanSectionDefinition
 * @see com.ext.portlet.model.PlanSectionDefinitionModel
 * @generated
 */
@JSON(strict = true)
public class PlanSectionDefinitionModelImpl extends BaseModelImpl<PlanSectionDefinition>
    implements PlanSectionDefinitionModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a plan section definition model instance should use the {@link com.ext.portlet.model.PlanSectionDefinition} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_PlanSectionDefinition";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "type_", Types.VARCHAR },
            { "adminTitle", Types.VARCHAR },
            { "title", Types.VARCHAR },
            { "defaultText", Types.CLOB },
            { "helpText", Types.CLOB },
            { "characterLimit", Types.INTEGER },
            { "focusAreaId", Types.BIGINT },
            { "tier", Types.BIGINT },
            { "allowedContestTypeIds", Types.VARCHAR },
            { "additionalIds", Types.VARCHAR },
            { "locked", Types.BOOLEAN },
            { "contestIntegrationRelevance", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_PlanSectionDefinition (id_ LONG not null primary key,type_ VARCHAR(75) null,adminTitle VARCHAR(1024) null,title VARCHAR(1024) null,defaultText TEXT null,helpText TEXT null,characterLimit INTEGER,focusAreaId LONG,tier LONG,allowedContestTypeIds VARCHAR(75) null,additionalIds VARCHAR(75) null,locked BOOLEAN,contestIntegrationRelevance BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_PlanSectionDefinition";
    public static final String ORDER_BY_JPQL = " ORDER BY planSectionDefinition.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_PlanSectionDefinition.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.PlanSectionDefinition"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.PlanSectionDefinition"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.PlanSectionDefinition"));
    private static ClassLoader _classLoader = PlanSectionDefinition.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            PlanSectionDefinition.class
        };
    private long _id;
    private String _type;
    private String _adminTitle;
    private String _title;
    private String _defaultText;
    private String _helpText;
    private int _characterLimit;
    private long _focusAreaId;
    private long _tier;
    private String _allowedContestTypeIds;
    private String _additionalIds;
    private boolean _locked;
    private boolean _contestIntegrationRelevance;
    private PlanSectionDefinition _escapedModel;

    public PlanSectionDefinitionModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static PlanSectionDefinition toModel(
        PlanSectionDefinitionSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        PlanSectionDefinition model = new PlanSectionDefinitionImpl();

        model.setId(soapModel.getId());
        model.setType(soapModel.getType());
        model.setAdminTitle(soapModel.getAdminTitle());
        model.setTitle(soapModel.getTitle());
        model.setDefaultText(soapModel.getDefaultText());
        model.setHelpText(soapModel.getHelpText());
        model.setCharacterLimit(soapModel.getCharacterLimit());
        model.setFocusAreaId(soapModel.getFocusAreaId());
        model.setTier(soapModel.getTier());
        model.setAllowedContestTypeIds(soapModel.getAllowedContestTypeIds());
        model.setAdditionalIds(soapModel.getAdditionalIds());
        model.setLocked(soapModel.getLocked());
        model.setContestIntegrationRelevance(soapModel.getContestIntegrationRelevance());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<PlanSectionDefinition> toModels(
        PlanSectionDefinitionSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<PlanSectionDefinition> models = new ArrayList<PlanSectionDefinition>(soapModels.length);

        for (PlanSectionDefinitionSoap soapModel : soapModels) {
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
        return PlanSectionDefinition.class;
    }

    @Override
    public String getModelClassName() {
        return PlanSectionDefinition.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("type", getType());
        attributes.put("adminTitle", getAdminTitle());
        attributes.put("title", getTitle());
        attributes.put("defaultText", getDefaultText());
        attributes.put("helpText", getHelpText());
        attributes.put("characterLimit", getCharacterLimit());
        attributes.put("focusAreaId", getFocusAreaId());
        attributes.put("tier", getTier());
        attributes.put("allowedContestTypeIds", getAllowedContestTypeIds());
        attributes.put("additionalIds", getAdditionalIds());
        attributes.put("locked", getLocked());
        attributes.put("contestIntegrationRelevance",
            getContestIntegrationRelevance());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String type = (String) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        String adminTitle = (String) attributes.get("adminTitle");

        if (adminTitle != null) {
            setAdminTitle(adminTitle);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String defaultText = (String) attributes.get("defaultText");

        if (defaultText != null) {
            setDefaultText(defaultText);
        }

        String helpText = (String) attributes.get("helpText");

        if (helpText != null) {
            setHelpText(helpText);
        }

        Integer characterLimit = (Integer) attributes.get("characterLimit");

        if (characterLimit != null) {
            setCharacterLimit(characterLimit);
        }

        Long focusAreaId = (Long) attributes.get("focusAreaId");

        if (focusAreaId != null) {
            setFocusAreaId(focusAreaId);
        }

        Long tier = (Long) attributes.get("tier");

        if (tier != null) {
            setTier(tier);
        }

        String allowedContestTypeIds = (String) attributes.get(
                "allowedContestTypeIds");

        if (allowedContestTypeIds != null) {
            setAllowedContestTypeIds(allowedContestTypeIds);
        }

        String additionalIds = (String) attributes.get("additionalIds");

        if (additionalIds != null) {
            setAdditionalIds(additionalIds);
        }

        Boolean locked = (Boolean) attributes.get("locked");

        if (locked != null) {
            setLocked(locked);
        }

        Boolean contestIntegrationRelevance = (Boolean) attributes.get(
                "contestIntegrationRelevance");

        if (contestIntegrationRelevance != null) {
            setContestIntegrationRelevance(contestIntegrationRelevance);
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
    public String getType() {
        if (_type == null) {
            return StringPool.BLANK;
        } else {
            return _type;
        }
    }

    @Override
    public void setType(String type) {
        _type = type;
    }

    @JSON
    @Override
    public String getAdminTitle() {
        if (_adminTitle == null) {
            return StringPool.BLANK;
        } else {
            return _adminTitle;
        }
    }

    @Override
    public void setAdminTitle(String adminTitle) {
        _adminTitle = adminTitle;
    }

    @JSON
    @Override
    public String getTitle() {
        if (_title == null) {
            return StringPool.BLANK;
        } else {
            return _title;
        }
    }

    @Override
    public void setTitle(String title) {
        _title = title;
    }

    @JSON
    @Override
    public String getDefaultText() {
        if (_defaultText == null) {
            return StringPool.BLANK;
        } else {
            return _defaultText;
        }
    }

    @Override
    public void setDefaultText(String defaultText) {
        _defaultText = defaultText;
    }

    @JSON
    @Override
    public String getHelpText() {
        if (_helpText == null) {
            return StringPool.BLANK;
        } else {
            return _helpText;
        }
    }

    @Override
    public void setHelpText(String helpText) {
        _helpText = helpText;
    }

    @JSON
    @Override
    public int getCharacterLimit() {
        return _characterLimit;
    }

    @Override
    public void setCharacterLimit(int characterLimit) {
        _characterLimit = characterLimit;
    }

    @JSON
    @Override
    public long getFocusAreaId() {
        return _focusAreaId;
    }

    @Override
    public void setFocusAreaId(long focusAreaId) {
        _focusAreaId = focusAreaId;
    }

    @JSON
    @Override
    public long getTier() {
        return _tier;
    }

    @Override
    public void setTier(long tier) {
        _tier = tier;
    }

    @JSON
    @Override
    public String getAllowedContestTypeIds() {
        if (_allowedContestTypeIds == null) {
            return StringPool.BLANK;
        } else {
            return _allowedContestTypeIds;
        }
    }

    @Override
    public void setAllowedContestTypeIds(String allowedContestTypeIds) {
        _allowedContestTypeIds = allowedContestTypeIds;
    }

    @JSON
    @Override
    public String getAdditionalIds() {
        if (_additionalIds == null) {
            return StringPool.BLANK;
        } else {
            return _additionalIds;
        }
    }

    @Override
    public void setAdditionalIds(String additionalIds) {
        _additionalIds = additionalIds;
    }

    @JSON
    @Override
    public boolean getLocked() {
        return _locked;
    }

    @Override
    public boolean isLocked() {
        return _locked;
    }

    @Override
    public void setLocked(boolean locked) {
        _locked = locked;
    }

    @JSON
    @Override
    public boolean getContestIntegrationRelevance() {
        return _contestIntegrationRelevance;
    }

    @Override
    public boolean isContestIntegrationRelevance() {
        return _contestIntegrationRelevance;
    }

    @Override
    public void setContestIntegrationRelevance(
        boolean contestIntegrationRelevance) {
        _contestIntegrationRelevance = contestIntegrationRelevance;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            PlanSectionDefinition.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public PlanSectionDefinition toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (PlanSectionDefinition) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        PlanSectionDefinitionImpl planSectionDefinitionImpl = new PlanSectionDefinitionImpl();

        planSectionDefinitionImpl.setId(getId());
        planSectionDefinitionImpl.setType(getType());
        planSectionDefinitionImpl.setAdminTitle(getAdminTitle());
        planSectionDefinitionImpl.setTitle(getTitle());
        planSectionDefinitionImpl.setDefaultText(getDefaultText());
        planSectionDefinitionImpl.setHelpText(getHelpText());
        planSectionDefinitionImpl.setCharacterLimit(getCharacterLimit());
        planSectionDefinitionImpl.setFocusAreaId(getFocusAreaId());
        planSectionDefinitionImpl.setTier(getTier());
        planSectionDefinitionImpl.setAllowedContestTypeIds(getAllowedContestTypeIds());
        planSectionDefinitionImpl.setAdditionalIds(getAdditionalIds());
        planSectionDefinitionImpl.setLocked(getLocked());
        planSectionDefinitionImpl.setContestIntegrationRelevance(getContestIntegrationRelevance());

        planSectionDefinitionImpl.resetOriginalValues();

        return planSectionDefinitionImpl;
    }

    @Override
    public int compareTo(PlanSectionDefinition planSectionDefinition) {
        long primaryKey = planSectionDefinition.getPrimaryKey();

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

        if (!(obj instanceof PlanSectionDefinition)) {
            return false;
        }

        PlanSectionDefinition planSectionDefinition = (PlanSectionDefinition) obj;

        long primaryKey = planSectionDefinition.getPrimaryKey();

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
    public CacheModel<PlanSectionDefinition> toCacheModel() {
        PlanSectionDefinitionCacheModel planSectionDefinitionCacheModel = new PlanSectionDefinitionCacheModel();

        planSectionDefinitionCacheModel.id = getId();

        planSectionDefinitionCacheModel.type = getType();

        String type = planSectionDefinitionCacheModel.type;

        if ((type != null) && (type.length() == 0)) {
            planSectionDefinitionCacheModel.type = null;
        }

        planSectionDefinitionCacheModel.adminTitle = getAdminTitle();

        String adminTitle = planSectionDefinitionCacheModel.adminTitle;

        if ((adminTitle != null) && (adminTitle.length() == 0)) {
            planSectionDefinitionCacheModel.adminTitle = null;
        }

        planSectionDefinitionCacheModel.title = getTitle();

        String title = planSectionDefinitionCacheModel.title;

        if ((title != null) && (title.length() == 0)) {
            planSectionDefinitionCacheModel.title = null;
        }

        planSectionDefinitionCacheModel.defaultText = getDefaultText();

        String defaultText = planSectionDefinitionCacheModel.defaultText;

        if ((defaultText != null) && (defaultText.length() == 0)) {
            planSectionDefinitionCacheModel.defaultText = null;
        }

        planSectionDefinitionCacheModel.helpText = getHelpText();

        String helpText = planSectionDefinitionCacheModel.helpText;

        if ((helpText != null) && (helpText.length() == 0)) {
            planSectionDefinitionCacheModel.helpText = null;
        }

        planSectionDefinitionCacheModel.characterLimit = getCharacterLimit();

        planSectionDefinitionCacheModel.focusAreaId = getFocusAreaId();

        planSectionDefinitionCacheModel.tier = getTier();

        planSectionDefinitionCacheModel.allowedContestTypeIds = getAllowedContestTypeIds();

        String allowedContestTypeIds = planSectionDefinitionCacheModel.allowedContestTypeIds;

        if ((allowedContestTypeIds != null) &&
                (allowedContestTypeIds.length() == 0)) {
            planSectionDefinitionCacheModel.allowedContestTypeIds = null;
        }

        planSectionDefinitionCacheModel.additionalIds = getAdditionalIds();

        String additionalIds = planSectionDefinitionCacheModel.additionalIds;

        if ((additionalIds != null) && (additionalIds.length() == 0)) {
            planSectionDefinitionCacheModel.additionalIds = null;
        }

        planSectionDefinitionCacheModel.locked = getLocked();

        planSectionDefinitionCacheModel.contestIntegrationRelevance = getContestIntegrationRelevance();

        return planSectionDefinitionCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", type=");
        sb.append(getType());
        sb.append(", adminTitle=");
        sb.append(getAdminTitle());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", defaultText=");
        sb.append(getDefaultText());
        sb.append(", helpText=");
        sb.append(getHelpText());
        sb.append(", characterLimit=");
        sb.append(getCharacterLimit());
        sb.append(", focusAreaId=");
        sb.append(getFocusAreaId());
        sb.append(", tier=");
        sb.append(getTier());
        sb.append(", allowedContestTypeIds=");
        sb.append(getAllowedContestTypeIds());
        sb.append(", additionalIds=");
        sb.append(getAdditionalIds());
        sb.append(", locked=");
        sb.append(getLocked());
        sb.append(", contestIntegrationRelevance=");
        sb.append(getContestIntegrationRelevance());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(43);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.PlanSectionDefinition");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>type</column-name><column-value><![CDATA[");
        sb.append(getType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>adminTitle</column-name><column-value><![CDATA[");
        sb.append(getAdminTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>defaultText</column-name><column-value><![CDATA[");
        sb.append(getDefaultText());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>helpText</column-name><column-value><![CDATA[");
        sb.append(getHelpText());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>characterLimit</column-name><column-value><![CDATA[");
        sb.append(getCharacterLimit());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>focusAreaId</column-name><column-value><![CDATA[");
        sb.append(getFocusAreaId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tier</column-name><column-value><![CDATA[");
        sb.append(getTier());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>allowedContestTypeIds</column-name><column-value><![CDATA[");
        sb.append(getAllowedContestTypeIds());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>additionalIds</column-name><column-value><![CDATA[");
        sb.append(getAdditionalIds());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>locked</column-name><column-value><![CDATA[");
        sb.append(getLocked());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contestIntegrationRelevance</column-name><column-value><![CDATA[");
        sb.append(getContestIntegrationRelevance());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
