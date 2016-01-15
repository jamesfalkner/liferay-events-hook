package com.liferay.events.global.mobile.model;

import com.liferay.events.global.mobile.service.ClpSerializer;
import com.liferay.events.global.mobile.service.GeoCacheLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class GeoCacheClp extends BaseModelImpl<GeoCache> implements GeoCache {
    private String _address;
    private double _lat;
    private double _lng;
    private long _geoCacheId;
    private Date _createDate;
    private BaseModel<?> _geoCacheRemoteModel;
    private Class<?> _clpSerializerClass = com.liferay.events.global.mobile.service.ClpSerializer.class;

    public GeoCacheClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return GeoCache.class;
    }

    @Override
    public String getModelClassName() {
        return GeoCache.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _geoCacheId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setGeoCacheId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _geoCacheId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("address", getAddress());
        attributes.put("lat", getLat());
        attributes.put("lng", getLng());
        attributes.put("geoCacheId", getGeoCacheId());
        attributes.put("createDate", getCreateDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String address = (String) attributes.get("address");

        if (address != null) {
            setAddress(address);
        }

        Double lat = (Double) attributes.get("lat");

        if (lat != null) {
            setLat(lat);
        }

        Double lng = (Double) attributes.get("lng");

        if (lng != null) {
            setLng(lng);
        }

        Long geoCacheId = (Long) attributes.get("geoCacheId");

        if (geoCacheId != null) {
            setGeoCacheId(geoCacheId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }
    }

    @Override
    public String getAddress() {
        return _address;
    }

    @Override
    public void setAddress(String address) {
        _address = address;

        if (_geoCacheRemoteModel != null) {
            try {
                Class<?> clazz = _geoCacheRemoteModel.getClass();

                Method method = clazz.getMethod("setAddress", String.class);

                method.invoke(_geoCacheRemoteModel, address);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getLat() {
        return _lat;
    }

    @Override
    public void setLat(double lat) {
        _lat = lat;

        if (_geoCacheRemoteModel != null) {
            try {
                Class<?> clazz = _geoCacheRemoteModel.getClass();

                Method method = clazz.getMethod("setLat", double.class);

                method.invoke(_geoCacheRemoteModel, lat);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getLng() {
        return _lng;
    }

    @Override
    public void setLng(double lng) {
        _lng = lng;

        if (_geoCacheRemoteModel != null) {
            try {
                Class<?> clazz = _geoCacheRemoteModel.getClass();

                Method method = clazz.getMethod("setLng", double.class);

                method.invoke(_geoCacheRemoteModel, lng);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGeoCacheId() {
        return _geoCacheId;
    }

    @Override
    public void setGeoCacheId(long geoCacheId) {
        _geoCacheId = geoCacheId;

        if (_geoCacheRemoteModel != null) {
            try {
                Class<?> clazz = _geoCacheRemoteModel.getClass();

                Method method = clazz.getMethod("setGeoCacheId", long.class);

                method.invoke(_geoCacheRemoteModel, geoCacheId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_geoCacheRemoteModel != null) {
            try {
                Class<?> clazz = _geoCacheRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_geoCacheRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getGeoCacheRemoteModel() {
        return _geoCacheRemoteModel;
    }

    public void setGeoCacheRemoteModel(BaseModel<?> geoCacheRemoteModel) {
        _geoCacheRemoteModel = geoCacheRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _geoCacheRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_geoCacheRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            GeoCacheLocalServiceUtil.addGeoCache(this);
        } else {
            GeoCacheLocalServiceUtil.updateGeoCache(this);
        }
    }

    @Override
    public GeoCache toEscapedModel() {
        return (GeoCache) ProxyUtil.newProxyInstance(GeoCache.class.getClassLoader(),
            new Class[] { GeoCache.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        GeoCacheClp clone = new GeoCacheClp();

        clone.setAddress(getAddress());
        clone.setLat(getLat());
        clone.setLng(getLng());
        clone.setGeoCacheId(getGeoCacheId());
        clone.setCreateDate(getCreateDate());

        return clone;
    }

    @Override
    public int compareTo(GeoCache geoCache) {
        long primaryKey = geoCache.getPrimaryKey();

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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof GeoCacheClp)) {
            return false;
        }

        GeoCacheClp geoCache = (GeoCacheClp) obj;

        long primaryKey = geoCache.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{address=");
        sb.append(getAddress());
        sb.append(", lat=");
        sb.append(getLat());
        sb.append(", lng=");
        sb.append(getLng());
        sb.append(", geoCacheId=");
        sb.append(getGeoCacheId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.liferay.events.global.mobile.model.GeoCache");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>address</column-name><column-value><![CDATA[");
        sb.append(getAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lat</column-name><column-value><![CDATA[");
        sb.append(getLat());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lng</column-name><column-value><![CDATA[");
        sb.append(getLng());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>geoCacheId</column-name><column-value><![CDATA[");
        sb.append(getGeoCacheId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
