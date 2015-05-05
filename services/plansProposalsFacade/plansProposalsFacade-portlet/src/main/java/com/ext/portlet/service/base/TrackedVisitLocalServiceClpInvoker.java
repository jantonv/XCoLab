package com.ext.portlet.service.base;

import com.ext.portlet.service.TrackedVisitLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TrackedVisitLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName658;
    private String[] _methodParameterTypes658;
    private String _methodName659;
    private String[] _methodParameterTypes659;
    private String _methodName664;
    private String[] _methodParameterTypes664;

    public TrackedVisitLocalServiceClpInvoker() {
        _methodName0 = "addTrackedVisit";

        _methodParameterTypes0 = new String[] {
                "com.ext.portlet.model.TrackedVisit"
            };

        _methodName1 = "createTrackedVisit";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteTrackedVisit";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteTrackedVisit";

        _methodParameterTypes3 = new String[] {
                "com.ext.portlet.model.TrackedVisit"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchTrackedVisit";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getTrackedVisit";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getTrackedVisits";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getTrackedVisitsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateTrackedVisit";

        _methodParameterTypes15 = new String[] {
                "com.ext.portlet.model.TrackedVisit"
            };

        _methodName658 = "getBeanIdentifier";

        _methodParameterTypes658 = new String[] {  };

        _methodName659 = "setBeanIdentifier";

        _methodParameterTypes659 = new String[] { "java.lang.String" };

        _methodName664 = "addTrackedVisit";

        _methodParameterTypes664 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.addTrackedVisit((com.ext.portlet.model.TrackedVisit) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.createTrackedVisit(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.deleteTrackedVisit(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.deleteTrackedVisit((com.ext.portlet.model.TrackedVisit) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.fetchTrackedVisit(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.getTrackedVisit(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.getTrackedVisits(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.getTrackedVisitsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.updateTrackedVisit((com.ext.portlet.model.TrackedVisit) arguments[0]);
        }

        if (_methodName658.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes658, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName659.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes659, parameterTypes)) {
            TrackedVisitLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName664.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes664, parameterTypes)) {
            return TrackedVisitLocalServiceUtil.addTrackedVisit((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                (java.lang.String) arguments[6], (java.lang.String) arguments[7]);
        }

        throw new UnsupportedOperationException();
    }
}
