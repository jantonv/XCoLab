package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the message recipient status local service. This utility wraps {@link com.ext.portlet.service.impl.MessageRecipientStatusLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageRecipientStatusLocalService
 * @see com.ext.portlet.service.base.MessageRecipientStatusLocalServiceBaseImpl
 * @see com.ext.portlet.service.impl.MessageRecipientStatusLocalServiceImpl
 * @generated
 */
public class MessageRecipientStatusLocalServiceUtil {
    private static MessageRecipientStatusLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.MessageRecipientStatusLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the message recipient status to the database. Also notifies the appropriate model listeners.
    *
    * @param messageRecipientStatus the message recipient status
    * @return the message recipient status that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.MessageRecipientStatus addMessageRecipientStatus(
        com.ext.portlet.model.MessageRecipientStatus messageRecipientStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addMessageRecipientStatus(messageRecipientStatus);
    }

    /**
    * Creates a new message recipient status with the primary key. Does not add the message recipient status to the database.
    *
    * @param messageRecipientId the primary key for the new message recipient status
    * @return the new message recipient status
    */
    public static com.ext.portlet.model.MessageRecipientStatus createMessageRecipientStatus(
        long messageRecipientId) {
        return getService().createMessageRecipientStatus(messageRecipientId);
    }

    /**
    * Deletes the message recipient status with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param messageRecipientId the primary key of the message recipient status
    * @throws PortalException if a message recipient status with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static void deleteMessageRecipientStatus(long messageRecipientId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteMessageRecipientStatus(messageRecipientId);
    }

    /**
    * Deletes the message recipient status from the database. Also notifies the appropriate model listeners.
    *
    * @param messageRecipientStatus the message recipient status
    * @throws SystemException if a system exception occurred
    */
    public static void deleteMessageRecipientStatus(
        com.ext.portlet.model.MessageRecipientStatus messageRecipientStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteMessageRecipientStatus(messageRecipientStatus);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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

    public static com.ext.portlet.model.MessageRecipientStatus fetchMessageRecipientStatus(
        long messageRecipientId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchMessageRecipientStatus(messageRecipientId);
    }

    /**
    * Returns the message recipient status with the primary key.
    *
    * @param messageRecipientId the primary key of the message recipient status
    * @return the message recipient status
    * @throws PortalException if a message recipient status with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.MessageRecipientStatus getMessageRecipientStatus(
        long messageRecipientId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getMessageRecipientStatus(messageRecipientId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the message recipient statuses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of message recipient statuses
    * @param end the upper bound of the range of message recipient statuses (not inclusive)
    * @return the range of message recipient statuses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.MessageRecipientStatus> getMessageRecipientStatuses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMessageRecipientStatuses(start, end);
    }

    /**
    * Returns the number of message recipient statuses.
    *
    * @return the number of message recipient statuses
    * @throws SystemException if a system exception occurred
    */
    public static int getMessageRecipientStatusesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMessageRecipientStatusesCount();
    }

    /**
    * Updates the message recipient status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param messageRecipientStatus the message recipient status
    * @return the message recipient status that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.MessageRecipientStatus updateMessageRecipientStatus(
        com.ext.portlet.model.MessageRecipientStatus messageRecipientStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateMessageRecipientStatus(messageRecipientStatus);
    }

    /**
    * Updates the message recipient status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param messageRecipientStatus the message recipient status
    * @param merge whether to merge the message recipient status with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the message recipient status that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.MessageRecipientStatus updateMessageRecipientStatus(
        com.ext.portlet.model.MessageRecipientStatus messageRecipientStatus,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateMessageRecipientStatus(messageRecipientStatus, merge);
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

    public static int countByMessageId(long messageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByMessageId(messageId);
    }

    public static java.util.List<com.ext.portlet.model.MessageRecipientStatus> findByMessageId(
        long messageId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByMessageId(messageId, start, end);
    }

    public static int countArchivedMessagesForUser(long userid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countArchivedMessagesForUser(userid);
    }

    public static java.util.List<com.ext.portlet.model.MessageRecipientStatus> findArchivedMessagesForUser(
        long userid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findArchivedMessagesForUser(userid, start, end);
    }

    public static int countInboxMessagesForUser(long userid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countInboxMessagesForUser(userid);
    }

    public static java.util.List<com.ext.portlet.model.MessageRecipientStatus> findInboxMessagesForUser(
        long userid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findInboxMessagesForUser(userid, start, end);
    }

    public static com.ext.portlet.model.MessageRecipientStatus findByMessageRecipient(
        long userid, long messageid)
        throws com.ext.portlet.NoSuchMessageRecipientStatusException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByMessageRecipient(userid, messageid);
    }

    public static void clearService() {
        _service = null;
    }

    public static MessageRecipientStatusLocalService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MessageRecipientStatusLocalService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    MessageRecipientStatusLocalService.class.getName(),
                    portletClassLoader);

            _service = new MessageRecipientStatusLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(MessageRecipientStatusLocalServiceUtil.class,
                "_service");
            MethodCache.remove(MessageRecipientStatusLocalService.class);
        }

        return _service;
    }

    public void setService(MessageRecipientStatusLocalService service) {
        MethodCache.remove(MessageRecipientStatusLocalService.class);

        _service = service;

        ReferenceRegistry.registerReference(MessageRecipientStatusLocalServiceUtil.class,
            "_service");
        MethodCache.remove(MessageRecipientStatusLocalService.class);
    }
}
