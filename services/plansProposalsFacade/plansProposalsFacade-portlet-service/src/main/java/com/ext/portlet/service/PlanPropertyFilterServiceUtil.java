package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the plan property filter remote service. This utility wraps {@link com.ext.portlet.service.impl.PlanPropertyFilterServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanPropertyFilterService
 * @see com.ext.portlet.service.base.PlanPropertyFilterServiceBaseImpl
 * @see com.ext.portlet.service.impl.PlanPropertyFilterServiceImpl
 * @generated
 */
public class PlanPropertyFilterServiceUtil {
    private static PlanPropertyFilterService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.PlanPropertyFilterServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */
    public static void clearService() {
        _service = null;
    }

    public static PlanPropertyFilterService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PlanPropertyFilterService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    PlanPropertyFilterService.class.getName(),
                    portletClassLoader);

            _service = new PlanPropertyFilterServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(PlanPropertyFilterServiceUtil.class,
                "_service");
            MethodCache.remove(PlanPropertyFilterService.class);
        }

        return _service;
    }

    public void setService(PlanPropertyFilterService service) {
        MethodCache.remove(PlanPropertyFilterService.class);

        _service = service;

        ReferenceRegistry.registerReference(PlanPropertyFilterServiceUtil.class,
            "_service");
        MethodCache.remove(PlanPropertyFilterService.class);
    }
}
