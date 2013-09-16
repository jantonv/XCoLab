package com.ext.portlet.service.persistence;

import com.ext.portlet.model.Proposal;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the proposal service. This utility wraps {@link ProposalPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalPersistence
 * @see ProposalPersistenceImpl
 * @generated
 */
public class ProposalUtil {
    private static ProposalPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Proposal proposal) {
        getPersistence().clearCache(proposal);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Proposal> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Proposal> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Proposal> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Proposal update(Proposal proposal, boolean merge)
        throws SystemException {
        return getPersistence().update(proposal, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Proposal update(Proposal proposal, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(proposal, merge, serviceContext);
    }

    /**
    * Caches the proposal in the entity cache if it is enabled.
    *
    * @param proposal the proposal
    */
    public static void cacheResult(com.ext.portlet.model.Proposal proposal) {
        getPersistence().cacheResult(proposal);
    }

    /**
    * Caches the proposals in the entity cache if it is enabled.
    *
    * @param proposals the proposals
    */
    public static void cacheResult(
        java.util.List<com.ext.portlet.model.Proposal> proposals) {
        getPersistence().cacheResult(proposals);
    }

    /**
    * Creates a new proposal with the primary key. Does not add the proposal to the database.
    *
    * @param proposalId the primary key for the new proposal
    * @return the new proposal
    */
    public static com.ext.portlet.model.Proposal create(long proposalId) {
        return getPersistence().create(proposalId);
    }

    /**
    * Removes the proposal with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param proposalId the primary key of the proposal
    * @return the proposal that was removed
    * @throws com.ext.portlet.NoSuchProposalException if a proposal with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.Proposal remove(long proposalId)
        throws com.ext.portlet.NoSuchProposalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(proposalId);
    }

    public static com.ext.portlet.model.Proposal updateImpl(
        com.ext.portlet.model.Proposal proposal, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(proposal, merge);
    }

    /**
    * Returns the proposal with the primary key or throws a {@link com.ext.portlet.NoSuchProposalException} if it could not be found.
    *
    * @param proposalId the primary key of the proposal
    * @return the proposal
    * @throws com.ext.portlet.NoSuchProposalException if a proposal with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.Proposal findByPrimaryKey(
        long proposalId)
        throws com.ext.portlet.NoSuchProposalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(proposalId);
    }

    /**
    * Returns the proposal with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param proposalId the primary key of the proposal
    * @return the proposal, or <code>null</code> if a proposal with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.Proposal fetchByPrimaryKey(
        long proposalId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(proposalId);
    }

    /**
    * Returns all the proposals.
    *
    * @return the proposals
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.Proposal> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the proposals.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of proposals
    * @param end the upper bound of the range of proposals (not inclusive)
    * @return the range of proposals
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.Proposal> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the proposals.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of proposals
    * @param end the upper bound of the range of proposals (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of proposals
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.Proposal> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the proposals from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of proposals.
    *
    * @return the number of proposals
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ProposalPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ProposalPersistence) PortletBeanLocatorUtil.locate(com.ext.portlet.service.ClpSerializer.getServletContextName(),
                    ProposalPersistence.class.getName());

            ReferenceRegistry.registerReference(ProposalUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    public void setPersistence(ProposalPersistence persistence) {
        _persistence = persistence;

        ReferenceRegistry.registerReference(ProposalUtil.class, "_persistence");
    }
}
