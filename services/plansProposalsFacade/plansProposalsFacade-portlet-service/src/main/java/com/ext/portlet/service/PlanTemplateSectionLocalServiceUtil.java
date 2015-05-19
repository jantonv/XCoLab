package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for PlanTemplateSection. This utility wraps
 * {@link com.ext.portlet.service.impl.PlanTemplateSectionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PlanTemplateSectionLocalService
 * @see com.ext.portlet.service.base.PlanTemplateSectionLocalServiceBaseImpl
 * @see com.ext.portlet.service.impl.PlanTemplateSectionLocalServiceImpl
 * @generated
 */
public class PlanTemplateSectionLocalServiceUtil {
    private static PlanTemplateSectionLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.PlanTemplateSectionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the plan template section to the database. Also notifies the appropriate model listeners.
    *
    * @param planTemplateSection the plan template section
    * @return the plan template section that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanTemplateSection addPlanTemplateSection(
        com.ext.portlet.model.PlanTemplateSection planTemplateSection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addPlanTemplateSection(planTemplateSection);
    }

    /**
    * Creates a new plan template section with the primary key. Does not add the plan template section to the database.
    *
    * @param planTemplateSectionPK the primary key for the new plan template section
    * @return the new plan template section
    */
    public static com.ext.portlet.model.PlanTemplateSection createPlanTemplateSection(
        com.ext.portlet.service.persistence.PlanTemplateSectionPK planTemplateSectionPK) {
        return getService().createPlanTemplateSection(planTemplateSectionPK);
    }

    /**
    * Deletes the plan template section with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param planTemplateSectionPK the primary key of the plan template section
    * @return the plan template section that was removed
    * @throws PortalException if a plan template section with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanTemplateSection deletePlanTemplateSection(
        com.ext.portlet.service.persistence.PlanTemplateSectionPK planTemplateSectionPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deletePlanTemplateSection(planTemplateSectionPK);
    }

    /**
    * Deletes the plan template section from the database. Also notifies the appropriate model listeners.
    *
    * @param planTemplateSection the plan template section
    * @return the plan template section that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanTemplateSection deletePlanTemplateSection(
        com.ext.portlet.model.PlanTemplateSection planTemplateSection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deletePlanTemplateSection(planTemplateSection);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanTemplateSectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanTemplateSectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.ext.portlet.model.PlanTemplateSection fetchPlanTemplateSection(
        com.ext.portlet.service.persistence.PlanTemplateSectionPK planTemplateSectionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchPlanTemplateSection(planTemplateSectionPK);
    }

    /**
    * Returns the plan template section with the primary key.
    *
    * @param planTemplateSectionPK the primary key of the plan template section
    * @return the plan template section
    * @throws PortalException if a plan template section with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanTemplateSection getPlanTemplateSection(
        com.ext.portlet.service.persistence.PlanTemplateSectionPK planTemplateSectionPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanTemplateSection(planTemplateSectionPK);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the plan template sections.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanTemplateSectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of plan template sections
    * @param end the upper bound of the range of plan template sections (not inclusive)
    * @return the range of plan template sections
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanTemplateSection> getPlanTemplateSections(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanTemplateSections(start, end);
    }

    /**
    * Returns the number of plan template sections.
    *
    * @return the number of plan template sections
    * @throws SystemException if a system exception occurred
    */
    public static int getPlanTemplateSectionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanTemplateSectionsCount();
    }

    /**
    * Updates the plan template section in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param planTemplateSection the plan template section
    * @return the plan template section that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanTemplateSection updatePlanTemplateSection(
        com.ext.portlet.model.PlanTemplateSection planTemplateSection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updatePlanTemplateSection(planTemplateSection);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static java.util.List<com.ext.portlet.model.PlanTemplateSection> findByPlanTemplateId(
        java.lang.Long planTemplateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPlanTemplateId(planTemplateId);
    }

    public static java.util.List<com.ext.portlet.model.PlanTemplateSection> findByPlanSectionDefinitionId(
        java.lang.Long planSectionDefinitionId) throws java.lang.Exception {
        return getService()
                   .findByPlanSectionDefinitionId(planSectionDefinitionId);
    }

    public static com.ext.portlet.model.PlanTemplateSection addPlanTemplateSection(
        java.lang.Long planTemplateId, java.lang.Long sectionId, int weight)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addPlanTemplateSection(planTemplateId, sectionId, weight);
    }

    public static void removePlanTemplateSection(
        java.lang.Long planTemplateId, java.lang.Long sectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().removePlanTemplateSection(planTemplateId, sectionId);
    }

    public static void store(com.ext.portlet.model.PlanTemplateSection section)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().store(section);
    }

    public static void remove(com.ext.portlet.model.PlanTemplateSection section)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().remove(section);
    }

    public static void clearService() {
        _service = null;
    }

    public static PlanTemplateSectionLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PlanTemplateSectionLocalService.class.getName());

            if (invokableLocalService instanceof PlanTemplateSectionLocalService) {
                _service = (PlanTemplateSectionLocalService) invokableLocalService;
            } else {
                _service = new PlanTemplateSectionLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(PlanTemplateSectionLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(PlanTemplateSectionLocalService service) {
    }
}
