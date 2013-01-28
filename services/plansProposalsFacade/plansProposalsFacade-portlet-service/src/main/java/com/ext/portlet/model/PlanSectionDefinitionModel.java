package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the PlanSectionDefinition service. Represents a row in the &quot;xcolab_PlanSectionDefinition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.PlanSectionDefinitionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.PlanSectionDefinitionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanSectionDefinition
 * @see com.ext.portlet.model.impl.PlanSectionDefinitionImpl
 * @see com.ext.portlet.model.impl.PlanSectionDefinitionModelImpl
 * @generated
 */
public interface PlanSectionDefinitionModel extends BaseModel<PlanSectionDefinition> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a plan section definition model instance should use the {@link PlanSectionDefinition} interface instead.
     */

    /**
     * Returns the primary key of this plan section definition.
     *
     * @return the primary key of this plan section definition
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this plan section definition.
     *
     * @param primaryKey the primary key of this plan section definition
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ID of this plan section definition.
     *
     * @return the ID of this plan section definition
     */
    public long getId();

    /**
     * Sets the ID of this plan section definition.
     *
     * @param id the ID of this plan section definition
     */
    public void setId(long id);

    /**
     * Returns the admin title of this plan section definition.
     *
     * @return the admin title of this plan section definition
     */
    @AutoEscape
    public String getAdminTitle();

    /**
     * Sets the admin title of this plan section definition.
     *
     * @param adminTitle the admin title of this plan section definition
     */
    public void setAdminTitle(String adminTitle);

    /**
     * Returns the title of this plan section definition.
     *
     * @return the title of this plan section definition
     */
    @AutoEscape
    public String getTitle();

    /**
     * Sets the title of this plan section definition.
     *
     * @param title the title of this plan section definition
     */
    public void setTitle(String title);

    /**
     * Returns the default text of this plan section definition.
     *
     * @return the default text of this plan section definition
     */
    @AutoEscape
    public String getDefaultText();

    /**
     * Sets the default text of this plan section definition.
     *
     * @param defaultText the default text of this plan section definition
     */
    public void setDefaultText(String defaultText);

    /**
     * Returns the help text of this plan section definition.
     *
     * @return the help text of this plan section definition
     */
    @AutoEscape
    public String getHelpText();

    /**
     * Sets the help text of this plan section definition.
     *
     * @param helpText the help text of this plan section definition
     */
    public void setHelpText(String helpText);

    /**
     * Returns the character limit of this plan section definition.
     *
     * @return the character limit of this plan section definition
     */
    public int getCharacterLimit();

    /**
     * Sets the character limit of this plan section definition.
     *
     * @param characterLimit the character limit of this plan section definition
     */
    public void setCharacterLimit(int characterLimit);

    /**
     * Returns the focus area ID of this plan section definition.
     *
     * @return the focus area ID of this plan section definition
     */
    public long getFocusAreaId();

    /**
     * Sets the focus area ID of this plan section definition.
     *
     * @param focusAreaId the focus area ID of this plan section definition
     */
    public void setFocusAreaId(long focusAreaId);

    /**
     * Returns the locked of this plan section definition.
     *
     * @return the locked of this plan section definition
     */
    public boolean getLocked();

    /**
     * Returns <code>true</code> if this plan section definition is locked.
     *
     * @return <code>true</code> if this plan section definition is locked; <code>false</code> otherwise
     */
    public boolean isLocked();

    /**
     * Sets whether this plan section definition is locked.
     *
     * @param locked the locked of this plan section definition
     */
    public void setLocked(boolean locked);

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(PlanSectionDefinition planSectionDefinition);

    public int hashCode();

    public CacheModel<PlanSectionDefinition> toCacheModel();

    public PlanSectionDefinition toEscapedModel();

    public String toString();

    public String toXmlString();
}
