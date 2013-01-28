package com.ext.portlet.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the plan attribute filter remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanAttributeFilterServiceUtil
 * @see com.ext.portlet.service.base.PlanAttributeFilterServiceBaseImpl
 * @see com.ext.portlet.service.impl.PlanAttributeFilterServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PlanAttributeFilterService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PlanAttributeFilterServiceUtil} to access the plan attribute filter remote service. Add custom service methods to {@link com.ext.portlet.service.impl.PlanAttributeFilterServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
}
