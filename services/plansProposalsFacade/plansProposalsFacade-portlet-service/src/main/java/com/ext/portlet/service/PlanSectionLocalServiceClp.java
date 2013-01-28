package com.ext.portlet.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;


public class PlanSectionLocalServiceClp implements PlanSectionLocalService {
    private ClassLoaderProxy _classLoaderProxy;
    private MethodKey _addPlanSectionMethodKey0;
    private MethodKey _createPlanSectionMethodKey1;
    private MethodKey _deletePlanSectionMethodKey2;
    private MethodKey _deletePlanSectionMethodKey3;
    private MethodKey _dynamicQueryMethodKey4;
    private MethodKey _dynamicQueryMethodKey5;
    private MethodKey _dynamicQueryMethodKey6;
    private MethodKey _dynamicQueryCountMethodKey7;
    private MethodKey _fetchPlanSectionMethodKey8;
    private MethodKey _getPlanSectionMethodKey9;
    private MethodKey _getPersistedModelMethodKey10;
    private MethodKey _getPlanSectionsMethodKey11;
    private MethodKey _getPlanSectionsCountMethodKey12;
    private MethodKey _updatePlanSectionMethodKey13;
    private MethodKey _updatePlanSectionMethodKey14;
    private MethodKey _getBeanIdentifierMethodKey15;
    private MethodKey _setBeanIdentifierMethodKey16;
    private MethodKey _getCurrentForPlanSectionDefMethodKey17;
    private MethodKey _getCurrentForPlanSectionDefMethodKey18;
    private MethodKey _getForPlanSectionDefMethodKey19;
    private MethodKey _getForPlanSectionDefMethodKey20;
    private MethodKey _createForPlanFromMethodKey21;
    private MethodKey _createNewVersionForPlanSectionDefinitionMethodKey22;
    private MethodKey _createNewVersionForPlanSectionDefinitionMethodKey23;
    private MethodKey _getAllForPlanDefinitionMethodKey24;
    private MethodKey _storeMethodKey25;
    private MethodKey _getDefinitionMethodKey26;
    private MethodKey _addPlanReferenceMethodKey27;
    private MethodKey _getReferencedPlansMethodKey28;

    public PlanSectionLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;

        _addPlanSectionMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
                "addPlanSection", com.ext.portlet.model.PlanSection.class);

        _createPlanSectionMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
                "createPlanSection", long.class);

        _deletePlanSectionMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
                "deletePlanSection", long.class);

        _deletePlanSectionMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
                "deletePlanSection", com.ext.portlet.model.PlanSection.class);

        _dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
                "dynamicQuery",
                com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

        _dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
                "dynamicQuery",
                com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
                int.class, int.class);

        _dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
                "dynamicQuery",
                com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
                int.class, int.class,
                com.liferay.portal.kernel.util.OrderByComparator.class);

        _dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
                "dynamicQueryCount",
                com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

        _fetchPlanSectionMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
                "fetchPlanSection", long.class);

        _getPlanSectionMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
                "getPlanSection", long.class);

        _getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
                "getPersistedModel", java.io.Serializable.class);

        _getPlanSectionsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
                "getPlanSections", int.class, int.class);

        _getPlanSectionsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
                "getPlanSectionsCount");

        _updatePlanSectionMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
                "updatePlanSection", com.ext.portlet.model.PlanSection.class);

        _updatePlanSectionMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
                "updatePlanSection", com.ext.portlet.model.PlanSection.class,
                boolean.class);

        _getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
                "getBeanIdentifier");

        _setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
                "setBeanIdentifier", java.lang.String.class);

        _getCurrentForPlanSectionDefMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
                "getCurrentForPlanSectionDef",
                com.ext.portlet.model.PlanItem.class,
                com.ext.portlet.model.PlanSectionDefinition.class);

        _getCurrentForPlanSectionDefMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
                "getCurrentForPlanSectionDef",
                com.ext.portlet.model.PlanItem.class,
                com.ext.portlet.model.PlanSectionDefinition.class, boolean.class);

        _getForPlanSectionDefMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
                "getForPlanSectionDef", com.ext.portlet.model.PlanItem.class,
                com.ext.portlet.model.PlanSectionDefinition.class);

        _getForPlanSectionDefMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
                "getForPlanSectionDef", com.ext.portlet.model.PlanItem.class,
                com.ext.portlet.model.PlanSectionDefinition.class,
                boolean.class, boolean.class);

        _createForPlanFromMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
                "createForPlanFrom", com.ext.portlet.model.PlanItem.class,
                com.ext.portlet.model.PlanSection.class, boolean.class);

        _createNewVersionForPlanSectionDefinitionMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
                "createNewVersionForPlanSectionDefinition",
                com.ext.portlet.model.PlanItem.class,
                com.ext.portlet.model.PlanSectionDefinition.class);

        _createNewVersionForPlanSectionDefinitionMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
                "createNewVersionForPlanSectionDefinition",
                com.ext.portlet.model.PlanItem.class,
                com.ext.portlet.model.PlanSectionDefinition.class, boolean.class);

        _getAllForPlanDefinitionMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
                "getAllForPlanDefinition",
                com.ext.portlet.model.PlanItem.class,
                com.ext.portlet.model.PlanSectionDefinition.class);

        _storeMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
                "store", com.ext.portlet.model.PlanSection.class);

        _getDefinitionMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
                "getDefinition", com.ext.portlet.model.PlanSection.class);

        _addPlanReferenceMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
                "addPlanReference", com.ext.portlet.model.PlanSection.class,
                java.lang.Long.class);

        _getReferencedPlansMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
                "getReferencedPlans", com.ext.portlet.model.PlanSection.class);
    }

    public com.ext.portlet.model.PlanSection addPlanSection(
        com.ext.portlet.model.PlanSection planSection)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_addPlanSectionMethodKey0,
                ClpSerializer.translateInput(planSection));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSection) ClpSerializer.translateOutput(returnObj);
    }

    public com.ext.portlet.model.PlanSection createPlanSection(long id) {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_createPlanSectionMethodKey1,
                id);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSection) ClpSerializer.translateOutput(returnObj);
    }

    public void deletePlanSection(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        MethodHandler methodHandler = new MethodHandler(_deletePlanSectionMethodKey2,
                id);

        try {
            _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public void deletePlanSection(com.ext.portlet.model.PlanSection planSection)
        throws com.liferay.portal.kernel.exception.SystemException {
        MethodHandler methodHandler = new MethodHandler(_deletePlanSectionMethodKey3,
                ClpSerializer.translateInput(planSection));

        try {
            _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
                ClpSerializer.translateInput(dynamicQuery));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
    }

    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
                ClpSerializer.translateInput(dynamicQuery), start, end);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
    }

    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
                ClpSerializer.translateInput(dynamicQuery), start, end,
                ClpSerializer.translateInput(orderByComparator));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
    }

    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
                ClpSerializer.translateInput(dynamicQuery));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Long) returnObj).longValue();
    }

    public com.ext.portlet.model.PlanSection fetchPlanSection(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_fetchPlanSectionMethodKey8,
                id);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSection) ClpSerializer.translateOutput(returnObj);
    }

    public com.ext.portlet.model.PlanSection getPlanSection(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getPlanSectionMethodKey9,
                id);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSection) ClpSerializer.translateOutput(returnObj);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey10,
                ClpSerializer.translateInput(primaryKeyObj));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.model.PersistedModel) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<com.ext.portlet.model.PlanSection> getPlanSections(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getPlanSectionsMethodKey11,
                start, end);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.ext.portlet.model.PlanSection>) ClpSerializer.translateOutput(returnObj);
    }

    public int getPlanSectionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getPlanSectionsCountMethodKey12);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    public com.ext.portlet.model.PlanSection updatePlanSection(
        com.ext.portlet.model.PlanSection planSection)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_updatePlanSectionMethodKey13,
                ClpSerializer.translateInput(planSection));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSection) ClpSerializer.translateOutput(returnObj);
    }

    public com.ext.portlet.model.PlanSection updatePlanSection(
        com.ext.portlet.model.PlanSection planSection, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_updatePlanSectionMethodKey14,
                ClpSerializer.translateInput(planSection), merge);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSection) ClpSerializer.translateOutput(returnObj);
    }

    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey15);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey16,
                ClpSerializer.translateInput(beanIdentifier));

        try {
            _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public com.ext.portlet.model.PlanSection getCurrentForPlanSectionDef(
        com.ext.portlet.model.PlanItem plan,
        com.ext.portlet.model.PlanSectionDefinition def)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getCurrentForPlanSectionDefMethodKey17,
                ClpSerializer.translateInput(plan),
                ClpSerializer.translateInput(def));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSection) ClpSerializer.translateOutput(returnObj);
    }

    public com.ext.portlet.model.PlanSection getCurrentForPlanSectionDef(
        com.ext.portlet.model.PlanItem plan,
        com.ext.portlet.model.PlanSectionDefinition def, boolean createOnEmpty)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getCurrentForPlanSectionDefMethodKey18,
                ClpSerializer.translateInput(plan),
                ClpSerializer.translateInput(def), createOnEmpty);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSection) ClpSerializer.translateOutput(returnObj);
    }

    public com.ext.portlet.model.PlanSection getForPlanSectionDef(
        com.ext.portlet.model.PlanItem plan,
        com.ext.portlet.model.PlanSectionDefinition def)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getForPlanSectionDefMethodKey19,
                ClpSerializer.translateInput(plan),
                ClpSerializer.translateInput(def));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSection) ClpSerializer.translateOutput(returnObj);
    }

    public com.ext.portlet.model.PlanSection getForPlanSectionDef(
        com.ext.portlet.model.PlanItem plan,
        com.ext.portlet.model.PlanSectionDefinition def, boolean current,
        boolean createOnEmpty)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getForPlanSectionDefMethodKey20,
                ClpSerializer.translateInput(plan),
                ClpSerializer.translateInput(def), current, createOnEmpty);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSection) ClpSerializer.translateOutput(returnObj);
    }

    public com.ext.portlet.model.PlanSection createForPlanFrom(
        com.ext.portlet.model.PlanItem plan,
        com.ext.portlet.model.PlanSection from, boolean store)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_createForPlanFromMethodKey21,
                ClpSerializer.translateInput(plan),
                ClpSerializer.translateInput(from), store);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSection) ClpSerializer.translateOutput(returnObj);
    }

    public com.ext.portlet.model.PlanSection createNewVersionForPlanSectionDefinition(
        com.ext.portlet.model.PlanItem plan,
        com.ext.portlet.model.PlanSectionDefinition def)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_createNewVersionForPlanSectionDefinitionMethodKey22,
                ClpSerializer.translateInput(plan),
                ClpSerializer.translateInput(def));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSection) ClpSerializer.translateOutput(returnObj);
    }

    public com.ext.portlet.model.PlanSection createNewVersionForPlanSectionDefinition(
        com.ext.portlet.model.PlanItem plan,
        com.ext.portlet.model.PlanSectionDefinition def, boolean store)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_createNewVersionForPlanSectionDefinitionMethodKey23,
                ClpSerializer.translateInput(plan),
                ClpSerializer.translateInput(def), store);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSection) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<com.ext.portlet.model.PlanSection> getAllForPlanDefinition(
        com.ext.portlet.model.PlanItem plan,
        com.ext.portlet.model.PlanSectionDefinition def)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getAllForPlanDefinitionMethodKey24,
                ClpSerializer.translateInput(plan),
                ClpSerializer.translateInput(def));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.ext.portlet.model.PlanSection>) ClpSerializer.translateOutput(returnObj);
    }

    public void store(com.ext.portlet.model.PlanSection ps)
        throws com.liferay.portal.kernel.exception.SystemException {
        MethodHandler methodHandler = new MethodHandler(_storeMethodKey25,
                ClpSerializer.translateInput(ps));

        try {
            _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public com.ext.portlet.model.PlanSectionDefinition getDefinition(
        com.ext.portlet.model.PlanSection ps)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getDefinitionMethodKey26,
                ClpSerializer.translateInput(ps));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.ext.portlet.model.PlanSectionDefinition) ClpSerializer.translateOutput(returnObj);
    }

    public void addPlanReference(com.ext.portlet.model.PlanSection ps,
        java.lang.Long planId)
        throws com.liferay.portal.kernel.exception.SystemException {
        MethodHandler methodHandler = new MethodHandler(_addPlanReferenceMethodKey27,
                ClpSerializer.translateInput(ps),
                ClpSerializer.translateInput(planId));

        try {
            _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public java.util.List<com.ext.portlet.model.PlanItem> getReferencedPlans(
        com.ext.portlet.model.PlanSection ps)
        throws com.ext.portlet.NoSuchPlanItemException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getReferencedPlansMethodKey28,
                ClpSerializer.translateInput(ps));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.ext.portlet.NoSuchPlanItemException) {
                throw (com.ext.portlet.NoSuchPlanItemException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.ext.portlet.model.PlanItem>) ClpSerializer.translateOutput(returnObj);
    }

    public ClassLoaderProxy getClassLoaderProxy() {
        return _classLoaderProxy;
    }
}
