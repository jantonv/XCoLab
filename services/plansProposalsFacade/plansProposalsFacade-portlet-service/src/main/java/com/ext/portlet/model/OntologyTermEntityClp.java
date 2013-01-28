package com.ext.portlet.model;

import com.ext.portlet.service.OntologyTermEntityLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;


public class OntologyTermEntityClp extends BaseModelImpl<OntologyTermEntity>
    implements OntologyTermEntity {
    private long _id;
    private long _termId;
    private long _classNameId;
    private long _classPK;

    public OntologyTermEntityClp() {
    }

    public Class<?> getModelClass() {
        return OntologyTermEntity.class;
    }

    public String getModelClassName() {
        return OntologyTermEntity.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public long getTermId() {
        return _termId;
    }

    public void setTermId(long termId) {
        _termId = termId;
    }

    public String getClassName() {
        if (getClassNameId() <= 0) {
            return StringPool.BLANK;
        }

        return PortalUtil.getClassName(getClassNameId());
    }

    public long getClassNameId() {
        return _classNameId;
    }

    public void setClassNameId(long classNameId) {
        _classNameId = classNameId;
    }

    public long getClassPK() {
        return _classPK;
    }

    public void setClassPK(long classPK) {
        _classPK = classPK;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            OntologyTermEntityLocalServiceUtil.addOntologyTermEntity(this);
        } else {
            OntologyTermEntityLocalServiceUtil.updateOntologyTermEntity(this);
        }
    }

    @Override
    public OntologyTermEntity toEscapedModel() {
        return (OntologyTermEntity) Proxy.newProxyInstance(OntologyTermEntity.class.getClassLoader(),
            new Class[] { OntologyTermEntity.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        OntologyTermEntityClp clone = new OntologyTermEntityClp();

        clone.setId(getId());
        clone.setTermId(getTermId());
        clone.setClassNameId(getClassNameId());
        clone.setClassPK(getClassPK());

        return clone;
    }

    public int compareTo(OntologyTermEntity ontologyTermEntity) {
        long primaryKey = ontologyTermEntity.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        OntologyTermEntityClp ontologyTermEntity = null;

        try {
            ontologyTermEntity = (OntologyTermEntityClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = ontologyTermEntity.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", termId=");
        sb.append(getTermId());
        sb.append(", classNameId=");
        sb.append(getClassNameId());
        sb.append(", classPK=");
        sb.append(getClassPK());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.OntologyTermEntity");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>termId</column-name><column-value><![CDATA[");
        sb.append(getTermId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>classNameId</column-name><column-value><![CDATA[");
        sb.append(getClassNameId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>classPK</column-name><column-value><![CDATA[");
        sb.append(getClassPK());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
