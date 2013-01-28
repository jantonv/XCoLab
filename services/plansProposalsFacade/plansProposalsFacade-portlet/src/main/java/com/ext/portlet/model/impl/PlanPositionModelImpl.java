package com.ext.portlet.model.impl;

import com.ext.portlet.model.PlanPosition;
import com.ext.portlet.model.PlanPositionModel;
import com.ext.portlet.model.PlanPositionSoap;
import com.ext.portlet.service.persistence.PlanPositionPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the PlanPosition service. Represents a row in the &quot;xcolab_PlanPosition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.PlanPositionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PlanPositionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanPositionImpl
 * @see com.ext.portlet.model.PlanPosition
 * @see com.ext.portlet.model.PlanPositionModel
 * @generated
 */
@JSON(strict = true)
public class PlanPositionModelImpl extends BaseModelImpl<PlanPosition>
    implements PlanPositionModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a plan position model instance should use the {@link com.ext.portlet.model.PlanPosition} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_PlanPosition";
    public static final Object[][] TABLE_COLUMNS = {
            { "planId", Types.BIGINT },
            { "positionId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_PlanPosition (planId LONG not null,positionId LONG not null,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,primary key (planId, positionId))";
    public static final String TABLE_SQL_DROP = "drop table xcolab_PlanPosition";
    public static final String ORDER_BY_JPQL = " ORDER BY planPosition.id.planId ASC, planPosition.id.positionId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_PlanPosition.planId ASC, xcolab_PlanPosition.positionId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.PlanPosition"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.PlanPosition"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.PlanPosition"),
            true);
    public static long POSITIONID_COLUMN_BITMASK = 1L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.PlanPosition"));
    private static ClassLoader _classLoader = PlanPosition.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            PlanPosition.class
        };
    private long _planId;
    private long _positionId;
    private long _originalPositionId;
    private boolean _setOriginalPositionId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _columnBitmask;
    private PlanPosition _escapedModelProxy;

    public PlanPositionModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static PlanPosition toModel(PlanPositionSoap soapModel) {
        PlanPosition model = new PlanPositionImpl();

        model.setPlanId(soapModel.getPlanId());
        model.setPositionId(soapModel.getPositionId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<PlanPosition> toModels(PlanPositionSoap[] soapModels) {
        List<PlanPosition> models = new ArrayList<PlanPosition>(soapModels.length);

        for (PlanPositionSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public PlanPositionPK getPrimaryKey() {
        return new PlanPositionPK(_planId, _positionId);
    }

    public void setPrimaryKey(PlanPositionPK primaryKey) {
        setPlanId(primaryKey.planId);
        setPositionId(primaryKey.positionId);
    }

    public Serializable getPrimaryKeyObj() {
        return new PlanPositionPK(_planId, _positionId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((PlanPositionPK) primaryKeyObj);
    }

    public Class<?> getModelClass() {
        return PlanPosition.class;
    }

    public String getModelClassName() {
        return PlanPosition.class.getName();
    }

    @JSON
    public long getPlanId() {
        return _planId;
    }

    public void setPlanId(long planId) {
        _columnBitmask = -1L;

        _planId = planId;
    }

    @JSON
    public long getPositionId() {
        return _positionId;
    }

    public void setPositionId(long positionId) {
        _columnBitmask = -1L;

        if (!_setOriginalPositionId) {
            _setOriginalPositionId = true;

            _originalPositionId = _positionId;
        }

        _positionId = positionId;
    }

    public long getOriginalPositionId() {
        return _originalPositionId;
    }

    @JSON
    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @JSON
    public String getUserName() {
        if (_userName == null) {
            return StringPool.BLANK;
        } else {
            return _userName;
        }
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    @JSON
    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public PlanPosition toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (PlanPosition) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        PlanPositionImpl planPositionImpl = new PlanPositionImpl();

        planPositionImpl.setPlanId(getPlanId());
        planPositionImpl.setPositionId(getPositionId());
        planPositionImpl.setUserId(getUserId());
        planPositionImpl.setUserName(getUserName());
        planPositionImpl.setCreateDate(getCreateDate());
        planPositionImpl.setModifiedDate(getModifiedDate());

        planPositionImpl.resetOriginalValues();

        return planPositionImpl;
    }

    public int compareTo(PlanPosition planPosition) {
        int value = 0;

        if (getPlanId() < planPosition.getPlanId()) {
            value = -1;
        } else if (getPlanId() > planPosition.getPlanId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (getPositionId() < planPosition.getPositionId()) {
            value = -1;
        } else if (getPositionId() > planPosition.getPositionId()) {
            value = 1;
        } else {
            value = 0;
        }

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

        PlanPosition planPosition = null;

        try {
            planPosition = (PlanPosition) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        PlanPositionPK primaryKey = planPosition.getPrimaryKey();

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
        PlanPositionModelImpl planPositionModelImpl = this;

        planPositionModelImpl._originalPositionId = planPositionModelImpl._positionId;

        planPositionModelImpl._setOriginalPositionId = false;

        planPositionModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<PlanPosition> toCacheModel() {
        PlanPositionCacheModel planPositionCacheModel = new PlanPositionCacheModel();

        planPositionCacheModel.planId = getPlanId();

        planPositionCacheModel.positionId = getPositionId();

        planPositionCacheModel.userId = getUserId();

        planPositionCacheModel.userName = getUserName();

        String userName = planPositionCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            planPositionCacheModel.userName = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            planPositionCacheModel.createDate = createDate.getTime();
        } else {
            planPositionCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            planPositionCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            planPositionCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        return planPositionCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{planId=");
        sb.append(getPlanId());
        sb.append(", positionId=");
        sb.append(getPositionId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.PlanPosition");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>planId</column-name><column-value><![CDATA[");
        sb.append(getPlanId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>positionId</column-name><column-value><![CDATA[");
        sb.append(getPositionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
