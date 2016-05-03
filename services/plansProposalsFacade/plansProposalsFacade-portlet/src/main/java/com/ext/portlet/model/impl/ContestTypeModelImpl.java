package com.ext.portlet.model.impl;

import com.ext.portlet.model.ContestType;
import com.ext.portlet.model.ContestTypeModel;
import com.ext.portlet.model.ContestTypeSoap;

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
 * The base model implementation for the ContestType service. Represents a row in the &quot;xcolab_ContestType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ContestTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContestTypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestTypeImpl
 * @see com.ext.portlet.model.ContestType
 * @see com.ext.portlet.model.ContestTypeModel
 * @generated
 */
@JSON(strict = true)
public class ContestTypeModelImpl extends BaseModelImpl<ContestType>
    implements ContestTypeModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a contest type model instance should use the {@link com.ext.portlet.model.ContestType} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ContestType";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "contestName", Types.VARCHAR },
            { "contestNamePlural", Types.VARCHAR },
            { "proposalName", Types.VARCHAR },
            { "proposalNamePlural", Types.VARCHAR },
            { "portletName", Types.VARCHAR },
            { "portletUrl", Types.VARCHAR },
            { "friendlyUrlStringContests", Types.VARCHAR },
            { "friendlyUrlStringProposal", Types.VARCHAR },
            { "menuItemName", Types.VARCHAR },
            { "hasDiscussion", Types.BOOLEAN },
            { "suggestionContestId", Types.BIGINT },
            { "rulesPageName", Types.VARCHAR },
            { "rulesPageUrl", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ContestType (id_ LONG not null primary key,contestName VARCHAR(75) null,contestNamePlural VARCHAR(75) null,proposalName VARCHAR(75) null,proposalNamePlural VARCHAR(75) null,portletName VARCHAR(75) null,portletUrl VARCHAR(75) null,friendlyUrlStringContests VARCHAR(75) null,friendlyUrlStringProposal VARCHAR(75) null,menuItemName VARCHAR(75) null,hasDiscussion BOOLEAN,suggestionContestId LONG,rulesPageName VARCHAR(75) null,rulesPageUrl VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ContestType";
    public static final String ORDER_BY_JPQL = " ORDER BY contestType.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_ContestType.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ContestType"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ContestType"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ContestType"));
    private static ClassLoader _classLoader = ContestType.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ContestType.class
        };
    private long _id;
    private String _contestName;
    private String _contestNamePlural;
    private String _proposalName;
    private String _proposalNamePlural;
    private String _portletName;
    private String _portletUrl;
    private String _friendlyUrlStringContests;
    private String _friendlyUrlStringProposal;
    private String _menuItemName;
    private boolean _hasDiscussion;
    private long _suggestionContestId;
    private String _rulesPageName;
    private String _rulesPageUrl;
    private ContestType _escapedModel;

    public ContestTypeModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ContestType toModel(ContestTypeSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        ContestType model = new ContestTypeImpl();

        model.setId(soapModel.getId());
        model.setContestName(soapModel.getContestName());
        model.setContestNamePlural(soapModel.getContestNamePlural());
        model.setProposalName(soapModel.getProposalName());
        model.setProposalNamePlural(soapModel.getProposalNamePlural());
        model.setPortletName(soapModel.getPortletName());
        model.setPortletUrl(soapModel.getPortletUrl());
        model.setFriendlyUrlStringContests(soapModel.getFriendlyUrlStringContests());
        model.setFriendlyUrlStringProposal(soapModel.getFriendlyUrlStringProposal());
        model.setMenuItemName(soapModel.getMenuItemName());
        model.setHasDiscussion(soapModel.getHasDiscussion());
        model.setSuggestionContestId(soapModel.getSuggestionContestId());
        model.setRulesPageName(soapModel.getRulesPageName());
        model.setRulesPageUrl(soapModel.getRulesPageUrl());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ContestType> toModels(ContestTypeSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<ContestType> models = new ArrayList<ContestType>(soapModels.length);

        for (ContestTypeSoap soapModel : soapModels) {
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
        return ContestType.class;
    }

    @Override
    public String getModelClassName() {
        return ContestType.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("contestName", getContestName());
        attributes.put("contestNamePlural", getContestNamePlural());
        attributes.put("proposalName", getProposalName());
        attributes.put("proposalNamePlural", getProposalNamePlural());
        attributes.put("portletName", getPortletName());
        attributes.put("portletUrl", getPortletUrl());
        attributes.put("friendlyUrlStringContests",
            getFriendlyUrlStringContests());
        attributes.put("friendlyUrlStringProposal",
            getFriendlyUrlStringProposal());
        attributes.put("menuItemName", getMenuItemName());
        attributes.put("hasDiscussion", getHasDiscussion());
        attributes.put("suggestionContestId", getSuggestionContestId());
        attributes.put("rulesPageName", getRulesPageName());
        attributes.put("rulesPageUrl", getRulesPageUrl());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String contestName = (String) attributes.get("contestName");

        if (contestName != null) {
            setContestName(contestName);
        }

        String contestNamePlural = (String) attributes.get("contestNamePlural");

        if (contestNamePlural != null) {
            setContestNamePlural(contestNamePlural);
        }

        String proposalName = (String) attributes.get("proposalName");

        if (proposalName != null) {
            setProposalName(proposalName);
        }

        String proposalNamePlural = (String) attributes.get(
                "proposalNamePlural");

        if (proposalNamePlural != null) {
            setProposalNamePlural(proposalNamePlural);
        }

        String portletName = (String) attributes.get("portletName");

        if (portletName != null) {
            setPortletName(portletName);
        }

        String portletUrl = (String) attributes.get("portletUrl");

        if (portletUrl != null) {
            setPortletUrl(portletUrl);
        }

        String friendlyUrlStringContests = (String) attributes.get(
                "friendlyUrlStringContests");

        if (friendlyUrlStringContests != null) {
            setFriendlyUrlStringContests(friendlyUrlStringContests);
        }

        String friendlyUrlStringProposal = (String) attributes.get(
                "friendlyUrlStringProposal");

        if (friendlyUrlStringProposal != null) {
            setFriendlyUrlStringProposal(friendlyUrlStringProposal);
        }

        String menuItemName = (String) attributes.get("menuItemName");

        if (menuItemName != null) {
            setMenuItemName(menuItemName);
        }

        Boolean hasDiscussion = (Boolean) attributes.get("hasDiscussion");

        if (hasDiscussion != null) {
            setHasDiscussion(hasDiscussion);
        }

        Long suggestionContestId = (Long) attributes.get("suggestionContestId");

        if (suggestionContestId != null) {
            setSuggestionContestId(suggestionContestId);
        }

        String rulesPageName = (String) attributes.get("rulesPageName");

        if (rulesPageName != null) {
            setRulesPageName(rulesPageName);
        }

        String rulesPageUrl = (String) attributes.get("rulesPageUrl");

        if (rulesPageUrl != null) {
            setRulesPageUrl(rulesPageUrl);
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
    public String getContestName() {
        if (_contestName == null) {
            return StringPool.BLANK;
        } else {
            return _contestName;
        }
    }

    @Override
    public void setContestName(String contestName) {
        _contestName = contestName;
    }

    @JSON
    @Override
    public String getContestNamePlural() {
        if (_contestNamePlural == null) {
            return StringPool.BLANK;
        } else {
            return _contestNamePlural;
        }
    }

    @Override
    public void setContestNamePlural(String contestNamePlural) {
        _contestNamePlural = contestNamePlural;
    }

    @JSON
    @Override
    public String getProposalName() {
        if (_proposalName == null) {
            return StringPool.BLANK;
        } else {
            return _proposalName;
        }
    }

    @Override
    public void setProposalName(String proposalName) {
        _proposalName = proposalName;
    }

    @JSON
    @Override
    public String getProposalNamePlural() {
        if (_proposalNamePlural == null) {
            return StringPool.BLANK;
        } else {
            return _proposalNamePlural;
        }
    }

    @Override
    public void setProposalNamePlural(String proposalNamePlural) {
        _proposalNamePlural = proposalNamePlural;
    }

    @JSON
    @Override
    public String getPortletName() {
        if (_portletName == null) {
            return StringPool.BLANK;
        } else {
            return _portletName;
        }
    }

    @Override
    public void setPortletName(String portletName) {
        _portletName = portletName;
    }

    @JSON
    @Override
    public String getPortletUrl() {
        if (_portletUrl == null) {
            return StringPool.BLANK;
        } else {
            return _portletUrl;
        }
    }

    @Override
    public void setPortletUrl(String portletUrl) {
        _portletUrl = portletUrl;
    }

    @JSON
    @Override
    public String getFriendlyUrlStringContests() {
        if (_friendlyUrlStringContests == null) {
            return StringPool.BLANK;
        } else {
            return _friendlyUrlStringContests;
        }
    }

    @Override
    public void setFriendlyUrlStringContests(String friendlyUrlStringContests) {
        _friendlyUrlStringContests = friendlyUrlStringContests;
    }

    @JSON
    @Override
    public String getFriendlyUrlStringProposal() {
        if (_friendlyUrlStringProposal == null) {
            return StringPool.BLANK;
        } else {
            return _friendlyUrlStringProposal;
        }
    }

    @Override
    public void setFriendlyUrlStringProposal(String friendlyUrlStringProposal) {
        _friendlyUrlStringProposal = friendlyUrlStringProposal;
    }

    @JSON
    @Override
    public String getMenuItemName() {
        if (_menuItemName == null) {
            return StringPool.BLANK;
        } else {
            return _menuItemName;
        }
    }

    @Override
    public void setMenuItemName(String menuItemName) {
        _menuItemName = menuItemName;
    }

    @JSON
    @Override
    public boolean getHasDiscussion() {
        return _hasDiscussion;
    }

    @Override
    public boolean isHasDiscussion() {
        return _hasDiscussion;
    }

    @Override
    public void setHasDiscussion(boolean hasDiscussion) {
        _hasDiscussion = hasDiscussion;
    }

    @JSON
    @Override
    public long getSuggestionContestId() {
        return _suggestionContestId;
    }

    @Override
    public void setSuggestionContestId(long suggestionContestId) {
        _suggestionContestId = suggestionContestId;
    }

    @JSON
    @Override
    public String getRulesPageName() {
        if (_rulesPageName == null) {
            return StringPool.BLANK;
        } else {
            return _rulesPageName;
        }
    }

    @Override
    public void setRulesPageName(String rulesPageName) {
        _rulesPageName = rulesPageName;
    }

    @JSON
    @Override
    public String getRulesPageUrl() {
        if (_rulesPageUrl == null) {
            return StringPool.BLANK;
        } else {
            return _rulesPageUrl;
        }
    }

    @Override
    public void setRulesPageUrl(String rulesPageUrl) {
        _rulesPageUrl = rulesPageUrl;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            ContestType.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public ContestType toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ContestType) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ContestTypeImpl contestTypeImpl = new ContestTypeImpl();

        contestTypeImpl.setId(getId());
        contestTypeImpl.setContestName(getContestName());
        contestTypeImpl.setContestNamePlural(getContestNamePlural());
        contestTypeImpl.setProposalName(getProposalName());
        contestTypeImpl.setProposalNamePlural(getProposalNamePlural());
        contestTypeImpl.setPortletName(getPortletName());
        contestTypeImpl.setPortletUrl(getPortletUrl());
        contestTypeImpl.setFriendlyUrlStringContests(getFriendlyUrlStringContests());
        contestTypeImpl.setFriendlyUrlStringProposal(getFriendlyUrlStringProposal());
        contestTypeImpl.setMenuItemName(getMenuItemName());
        contestTypeImpl.setHasDiscussion(getHasDiscussion());
        contestTypeImpl.setSuggestionContestId(getSuggestionContestId());
        contestTypeImpl.setRulesPageName(getRulesPageName());
        contestTypeImpl.setRulesPageUrl(getRulesPageUrl());

        contestTypeImpl.resetOriginalValues();

        return contestTypeImpl;
    }

    @Override
    public int compareTo(ContestType contestType) {
        long primaryKey = contestType.getPrimaryKey();

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

        if (!(obj instanceof ContestType)) {
            return false;
        }

        ContestType contestType = (ContestType) obj;

        long primaryKey = contestType.getPrimaryKey();

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
    public CacheModel<ContestType> toCacheModel() {
        ContestTypeCacheModel contestTypeCacheModel = new ContestTypeCacheModel();

        contestTypeCacheModel.id = getId();

        contestTypeCacheModel.contestName = getContestName();

        String contestName = contestTypeCacheModel.contestName;

        if ((contestName != null) && (contestName.length() == 0)) {
            contestTypeCacheModel.contestName = null;
        }

        contestTypeCacheModel.contestNamePlural = getContestNamePlural();

        String contestNamePlural = contestTypeCacheModel.contestNamePlural;

        if ((contestNamePlural != null) && (contestNamePlural.length() == 0)) {
            contestTypeCacheModel.contestNamePlural = null;
        }

        contestTypeCacheModel.proposalName = getProposalName();

        String proposalName = contestTypeCacheModel.proposalName;

        if ((proposalName != null) && (proposalName.length() == 0)) {
            contestTypeCacheModel.proposalName = null;
        }

        contestTypeCacheModel.proposalNamePlural = getProposalNamePlural();

        String proposalNamePlural = contestTypeCacheModel.proposalNamePlural;

        if ((proposalNamePlural != null) && (proposalNamePlural.length() == 0)) {
            contestTypeCacheModel.proposalNamePlural = null;
        }

        contestTypeCacheModel.portletName = getPortletName();

        String portletName = contestTypeCacheModel.portletName;

        if ((portletName != null) && (portletName.length() == 0)) {
            contestTypeCacheModel.portletName = null;
        }

        contestTypeCacheModel.portletUrl = getPortletUrl();

        String portletUrl = contestTypeCacheModel.portletUrl;

        if ((portletUrl != null) && (portletUrl.length() == 0)) {
            contestTypeCacheModel.portletUrl = null;
        }

        contestTypeCacheModel.friendlyUrlStringContests = getFriendlyUrlStringContests();

        String friendlyUrlStringContests = contestTypeCacheModel.friendlyUrlStringContests;

        if ((friendlyUrlStringContests != null) &&
                (friendlyUrlStringContests.length() == 0)) {
            contestTypeCacheModel.friendlyUrlStringContests = null;
        }

        contestTypeCacheModel.friendlyUrlStringProposal = getFriendlyUrlStringProposal();

        String friendlyUrlStringProposal = contestTypeCacheModel.friendlyUrlStringProposal;

        if ((friendlyUrlStringProposal != null) &&
                (friendlyUrlStringProposal.length() == 0)) {
            contestTypeCacheModel.friendlyUrlStringProposal = null;
        }

        contestTypeCacheModel.menuItemName = getMenuItemName();

        String menuItemName = contestTypeCacheModel.menuItemName;

        if ((menuItemName != null) && (menuItemName.length() == 0)) {
            contestTypeCacheModel.menuItemName = null;
        }

        contestTypeCacheModel.hasDiscussion = getHasDiscussion();

        contestTypeCacheModel.suggestionContestId = getSuggestionContestId();

        contestTypeCacheModel.rulesPageName = getRulesPageName();

        String rulesPageName = contestTypeCacheModel.rulesPageName;

        if ((rulesPageName != null) && (rulesPageName.length() == 0)) {
            contestTypeCacheModel.rulesPageName = null;
        }

        contestTypeCacheModel.rulesPageUrl = getRulesPageUrl();

        String rulesPageUrl = contestTypeCacheModel.rulesPageUrl;

        if ((rulesPageUrl != null) && (rulesPageUrl.length() == 0)) {
            contestTypeCacheModel.rulesPageUrl = null;
        }

        return contestTypeCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", contestName=");
        sb.append(getContestName());
        sb.append(", contestNamePlural=");
        sb.append(getContestNamePlural());
        sb.append(", proposalName=");
        sb.append(getProposalName());
        sb.append(", proposalNamePlural=");
        sb.append(getProposalNamePlural());
        sb.append(", portletName=");
        sb.append(getPortletName());
        sb.append(", portletUrl=");
        sb.append(getPortletUrl());
        sb.append(", friendlyUrlStringContests=");
        sb.append(getFriendlyUrlStringContests());
        sb.append(", friendlyUrlStringProposal=");
        sb.append(getFriendlyUrlStringProposal());
        sb.append(", menuItemName=");
        sb.append(getMenuItemName());
        sb.append(", hasDiscussion=");
        sb.append(getHasDiscussion());
        sb.append(", suggestionContestId=");
        sb.append(getSuggestionContestId());
        sb.append(", rulesPageName=");
        sb.append(getRulesPageName());
        sb.append(", rulesPageUrl=");
        sb.append(getRulesPageUrl());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ContestType");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contestName</column-name><column-value><![CDATA[");
        sb.append(getContestName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contestNamePlural</column-name><column-value><![CDATA[");
        sb.append(getContestNamePlural());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>proposalName</column-name><column-value><![CDATA[");
        sb.append(getProposalName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>proposalNamePlural</column-name><column-value><![CDATA[");
        sb.append(getProposalNamePlural());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>portletName</column-name><column-value><![CDATA[");
        sb.append(getPortletName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>portletUrl</column-name><column-value><![CDATA[");
        sb.append(getPortletUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>friendlyUrlStringContests</column-name><column-value><![CDATA[");
        sb.append(getFriendlyUrlStringContests());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>friendlyUrlStringProposal</column-name><column-value><![CDATA[");
        sb.append(getFriendlyUrlStringProposal());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>menuItemName</column-name><column-value><![CDATA[");
        sb.append(getMenuItemName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hasDiscussion</column-name><column-value><![CDATA[");
        sb.append(getHasDiscussion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>suggestionContestId</column-name><column-value><![CDATA[");
        sb.append(getSuggestionContestId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>rulesPageName</column-name><column-value><![CDATA[");
        sb.append(getRulesPageName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>rulesPageUrl</column-name><column-value><![CDATA[");
        sb.append(getRulesPageUrl());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
