package com.ext.portlet.model.impl;

import com.ext.portlet.model.ContestPhaseColumn;
import com.ext.portlet.model.ContestPhaseColumnModel;
import com.ext.portlet.model.ContestPhaseColumnSoap;

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
 * The base model implementation for the ContestPhaseColumn service. Represents a row in the &quot;xcolab_ContestPhaseColumn&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ContestPhaseColumnModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContestPhaseColumnImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestPhaseColumnImpl
 * @see com.ext.portlet.model.ContestPhaseColumn
 * @see com.ext.portlet.model.ContestPhaseColumnModel
 * @generated
 */
@JSON(strict = true)
public class ContestPhaseColumnModelImpl extends BaseModelImpl<ContestPhaseColumn>
    implements ContestPhaseColumnModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a contest phase column model instance should use the {@link com.ext.portlet.model.ContestPhaseColumn} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ContestPhaseColumn";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "ContestPhasePK", Types.BIGINT },
            { "columnName", Types.VARCHAR },
            { "columnWeight", Types.INTEGER },
            { "defaultSort", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ContestPhaseColumn (id_ LONG not null primary key,ContestPhasePK LONG,columnName VARCHAR(75) null,columnWeight INTEGER,defaultSort BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ContestPhaseColumn";
    public static final String ORDER_BY_JPQL = " ORDER BY contestPhaseColumn.columnWeight ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_ContestPhaseColumn.columnWeight ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ContestPhaseColumn"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ContestPhaseColumn"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.ContestPhaseColumn"),
            true);
    public static long CONTESTPHASEPK_COLUMN_BITMASK = 1L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ContestPhaseColumn"));
    private static ClassLoader _classLoader = ContestPhaseColumn.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            ContestPhaseColumn.class
        };
    private long _id;
    private long _ContestPhasePK;
    private long _originalContestPhasePK;
    private boolean _setOriginalContestPhasePK;
    private String _columnName;
    private int _columnWeight;
    private boolean _defaultSort;
    private transient ExpandoBridge _expandoBridge;
    private long _columnBitmask;
    private ContestPhaseColumn _escapedModelProxy;

    public ContestPhaseColumnModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ContestPhaseColumn toModel(ContestPhaseColumnSoap soapModel) {
        ContestPhaseColumn model = new ContestPhaseColumnImpl();

        model.setId(soapModel.getId());
        model.setContestPhasePK(soapModel.getContestPhasePK());
        model.setColumnName(soapModel.getColumnName());
        model.setColumnWeight(soapModel.getColumnWeight());
        model.setDefaultSort(soapModel.getDefaultSort());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ContestPhaseColumn> toModels(
        ContestPhaseColumnSoap[] soapModels) {
        List<ContestPhaseColumn> models = new ArrayList<ContestPhaseColumn>(soapModels.length);

        for (ContestPhaseColumnSoap soapModel : soapModels) {
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
        return ContestPhaseColumn.class;
    }

    public String getModelClassName() {
        return ContestPhaseColumn.class.getName();
    }

    @JSON
    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    @JSON
    public long getContestPhasePK() {
        return _ContestPhasePK;
    }

    public void setContestPhasePK(long ContestPhasePK) {
        _columnBitmask |= CONTESTPHASEPK_COLUMN_BITMASK;

        if (!_setOriginalContestPhasePK) {
            _setOriginalContestPhasePK = true;

            _originalContestPhasePK = _ContestPhasePK;
        }

        _ContestPhasePK = ContestPhasePK;
    }

    public long getOriginalContestPhasePK() {
        return _originalContestPhasePK;
    }

    @JSON
    public String getColumnName() {
        if (_columnName == null) {
            return StringPool.BLANK;
        } else {
            return _columnName;
        }
    }

    public void setColumnName(String columnName) {
        _columnName = columnName;
    }

    @JSON
    public int getColumnWeight() {
        return _columnWeight;
    }

    public void setColumnWeight(int columnWeight) {
        _columnBitmask = -1L;

        _columnWeight = columnWeight;
    }

    @JSON
    public boolean getDefaultSort() {
        return _defaultSort;
    }

    public boolean isDefaultSort() {
        return _defaultSort;
    }

    public void setDefaultSort(boolean defaultSort) {
        _defaultSort = defaultSort;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ContestPhaseColumn toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (ContestPhaseColumn) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
                    ContestPhaseColumn.class.getName(), getPrimaryKey());
        }

        return _expandoBridge;
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        getExpandoBridge().setAttributes(serviceContext);
    }

    @Override
    public Object clone() {
        ContestPhaseColumnImpl contestPhaseColumnImpl = new ContestPhaseColumnImpl();

        contestPhaseColumnImpl.setId(getId());
        contestPhaseColumnImpl.setContestPhasePK(getContestPhasePK());
        contestPhaseColumnImpl.setColumnName(getColumnName());
        contestPhaseColumnImpl.setColumnWeight(getColumnWeight());
        contestPhaseColumnImpl.setDefaultSort(getDefaultSort());

        contestPhaseColumnImpl.resetOriginalValues();

        return contestPhaseColumnImpl;
    }

    public int compareTo(ContestPhaseColumn contestPhaseColumn) {
        int value = 0;

        if (getColumnWeight() < contestPhaseColumn.getColumnWeight()) {
            value = -1;
        } else if (getColumnWeight() > contestPhaseColumn.getColumnWeight()) {
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

        ContestPhaseColumn contestPhaseColumn = null;

        try {
            contestPhaseColumn = (ContestPhaseColumn) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = contestPhaseColumn.getPrimaryKey();

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
        ContestPhaseColumnModelImpl contestPhaseColumnModelImpl = this;

        contestPhaseColumnModelImpl._originalContestPhasePK = contestPhaseColumnModelImpl._ContestPhasePK;

        contestPhaseColumnModelImpl._setOriginalContestPhasePK = false;

        contestPhaseColumnModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ContestPhaseColumn> toCacheModel() {
        ContestPhaseColumnCacheModel contestPhaseColumnCacheModel = new ContestPhaseColumnCacheModel();

        contestPhaseColumnCacheModel.id = getId();

        contestPhaseColumnCacheModel.ContestPhasePK = getContestPhasePK();

        contestPhaseColumnCacheModel.columnName = getColumnName();

        String columnName = contestPhaseColumnCacheModel.columnName;

        if ((columnName != null) && (columnName.length() == 0)) {
            contestPhaseColumnCacheModel.columnName = null;
        }

        contestPhaseColumnCacheModel.columnWeight = getColumnWeight();

        contestPhaseColumnCacheModel.defaultSort = getDefaultSort();

        return contestPhaseColumnCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", ContestPhasePK=");
        sb.append(getContestPhasePK());
        sb.append(", columnName=");
        sb.append(getColumnName());
        sb.append(", columnWeight=");
        sb.append(getColumnWeight());
        sb.append(", defaultSort=");
        sb.append(getDefaultSort());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ContestPhaseColumn");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ContestPhasePK</column-name><column-value><![CDATA[");
        sb.append(getContestPhasePK());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>columnName</column-name><column-value><![CDATA[");
        sb.append(getColumnName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>columnWeight</column-name><column-value><![CDATA[");
        sb.append(getColumnWeight());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>defaultSort</column-name><column-value><![CDATA[");
        sb.append(getDefaultSort());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
