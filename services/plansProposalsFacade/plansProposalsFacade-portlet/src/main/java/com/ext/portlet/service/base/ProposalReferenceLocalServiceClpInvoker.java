package com.ext.portlet.service.base;

import com.ext.portlet.service.ProposalReferenceLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProposalReferenceLocalServiceClpInvoker {
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
    private String _methodName638;
    private String[] _methodParameterTypes638;
    private String _methodName639;
    private String[] _methodParameterTypes639;
    private String _methodName644;
    private String[] _methodParameterTypes644;
    private String _methodName645;
    private String[] _methodParameterTypes645;
    private String _methodName646;
    private String[] _methodParameterTypes646;
    private String _methodName647;
    private String[] _methodParameterTypes647;

    public ProposalReferenceLocalServiceClpInvoker() {
        _methodName0 = "addProposalReference";

        _methodParameterTypes0 = new String[] {
                "com.ext.portlet.model.ProposalReference"
            };

        _methodName1 = "createProposalReference";

        _methodParameterTypes1 = new String[] {
                "com.ext.portlet.service.persistence.ProposalReferencePK"
            };

        _methodName2 = "deleteProposalReference";

        _methodParameterTypes2 = new String[] {
                "com.ext.portlet.service.persistence.ProposalReferencePK"
            };

        _methodName3 = "deleteProposalReference";

        _methodParameterTypes3 = new String[] {
                "com.ext.portlet.model.ProposalReference"
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

        _methodName10 = "fetchProposalReference";

        _methodParameterTypes10 = new String[] {
                "com.ext.portlet.service.persistence.ProposalReferencePK"
            };

        _methodName11 = "getProposalReference";

        _methodParameterTypes11 = new String[] {
                "com.ext.portlet.service.persistence.ProposalReferencePK"
            };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getProposalReferences";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getProposalReferencesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateProposalReference";

        _methodParameterTypes15 = new String[] {
                "com.ext.portlet.model.ProposalReference"
            };

        _methodName638 = "getBeanIdentifier";

        _methodParameterTypes638 = new String[] {  };

        _methodName639 = "setBeanIdentifier";

        _methodParameterTypes639 = new String[] { "java.lang.String" };

        _methodName644 = "getByProposalId";

        _methodParameterTypes644 = new String[] { "long" };

        _methodName645 = "getBySubProposalId";

        _methodParameterTypes645 = new String[] { "long" };

        _methodName646 = "populateTable";

        _methodParameterTypes646 = new String[] {  };

        _methodName647 = "populateTableWithProposal";

        _methodParameterTypes647 = new String[] { "com.ext.portlet.model.Proposal" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.addProposalReference((com.ext.portlet.model.ProposalReference) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.createProposalReference((com.ext.portlet.service.persistence.ProposalReferencePK) arguments[0]);
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.deleteProposalReference((com.ext.portlet.service.persistence.ProposalReferencePK) arguments[0]);
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.deleteProposalReference((com.ext.portlet.model.ProposalReference) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.fetchProposalReference((com.ext.portlet.service.persistence.ProposalReferencePK) arguments[0]);
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.getProposalReference((com.ext.portlet.service.persistence.ProposalReferencePK) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.getProposalReferences(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.getProposalReferencesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.updateProposalReference((com.ext.portlet.model.ProposalReference) arguments[0]);
        }

        if (_methodName638.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes638, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName639.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes639, parameterTypes)) {
            ProposalReferenceLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName644.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes644, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.getByProposalId(((Long) arguments[0]).longValue());
        }

        if (_methodName645.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes645, parameterTypes)) {
            return ProposalReferenceLocalServiceUtil.getBySubProposalId(((Long) arguments[0]).longValue());
        }

        if (_methodName646.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes646, parameterTypes)) {
            ProposalReferenceLocalServiceUtil.populateTable();

            return null;
        }

        if (_methodName647.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes647, parameterTypes)) {
            ProposalReferenceLocalServiceUtil.populateTableWithProposal((com.ext.portlet.model.Proposal) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}