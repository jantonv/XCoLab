package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ContestSchedule service. Represents a row in the &quot;xcolab_ContestSchedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.ContestScheduleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.ContestScheduleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestSchedule
 * @see com.ext.portlet.model.impl.ContestScheduleImpl
 * @see com.ext.portlet.model.impl.ContestScheduleModelImpl
 * @generated
 */
public interface ContestScheduleModel extends BaseModel<ContestSchedule> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a contest schedule model instance should use the {@link ContestSchedule} interface instead.
     */

    /**
     * Returns the primary key of this contest schedule.
     *
     * @return the primary key of this contest schedule
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this contest schedule.
     *
     * @param primaryKey the primary key of this contest schedule
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ID of this contest schedule.
     *
     * @return the ID of this contest schedule
     */
    public long getId();

    /**
     * Sets the ID of this contest schedule.
     *
     * @param id the ID of this contest schedule
     */
    public void setId(long id);

    /**
     * Returns the name of this contest schedule.
     *
     * @return the name of this contest schedule
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this contest schedule.
     *
     * @param name the name of this contest schedule
     */
    public void setName(String name);

    /**
     * Returns the description of this contest schedule.
     *
     * @return the description of this contest schedule
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this contest schedule.
     *
     * @param description the description of this contest schedule
     */
    public void setDescription(String description);

    /**
     * Returns the status of this contest schedule.
     *
     * @return the status of this contest schedule
     */
    @AutoEscape
    public String getStatus();

    /**
     * Sets the status of this contest schedule.
     *
     * @param status the status of this contest schedule
     */
    public void setStatus(String status);

    /**
     * Returns the base schedule ID of this contest schedule.
     *
     * @return the base schedule ID of this contest schedule
     */
    public Long getBaseScheduleId();

    /**
     * Sets the base schedule ID of this contest schedule.
     *
     * @param baseScheduleId the base schedule ID of this contest schedule
     */
    public void setBaseScheduleId(Long baseScheduleId);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(com.ext.portlet.model.ContestSchedule contestSchedule);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.ContestSchedule> toCacheModel();

    @Override
    public com.ext.portlet.model.ContestSchedule toEscapedModel();

    @Override
    public com.ext.portlet.model.ContestSchedule toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
