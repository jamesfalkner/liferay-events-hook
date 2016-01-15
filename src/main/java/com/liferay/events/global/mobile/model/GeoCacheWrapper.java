package com.liferay.events.global.mobile.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GeoCache}.
 * </p>
 *
 * @author James Falkner
 * @see GeoCache
 * @generated
 */
public class GeoCacheWrapper implements GeoCache, ModelWrapper<GeoCache> {
    private GeoCache _geoCache;

    public GeoCacheWrapper(GeoCache geoCache) {
        _geoCache = geoCache;
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

    /**
    * Returns the primary key of this geo cache.
    *
    * @return the primary key of this geo cache
    */
    @Override
    public long getPrimaryKey() {
        return _geoCache.getPrimaryKey();
    }

    /**
    * Sets the primary key of this geo cache.
    *
    * @param primaryKey the primary key of this geo cache
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _geoCache.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the address of this geo cache.
    *
    * @return the address of this geo cache
    */
    @Override
    public java.lang.String getAddress() {
        return _geoCache.getAddress();
    }

    /**
    * Sets the address of this geo cache.
    *
    * @param address the address of this geo cache
    */
    @Override
    public void setAddress(java.lang.String address) {
        _geoCache.setAddress(address);
    }

    /**
    * Returns the lat of this geo cache.
    *
    * @return the lat of this geo cache
    */
    @Override
    public double getLat() {
        return _geoCache.getLat();
    }

    /**
    * Sets the lat of this geo cache.
    *
    * @param lat the lat of this geo cache
    */
    @Override
    public void setLat(double lat) {
        _geoCache.setLat(lat);
    }

    /**
    * Returns the lng of this geo cache.
    *
    * @return the lng of this geo cache
    */
    @Override
    public double getLng() {
        return _geoCache.getLng();
    }

    /**
    * Sets the lng of this geo cache.
    *
    * @param lng the lng of this geo cache
    */
    @Override
    public void setLng(double lng) {
        _geoCache.setLng(lng);
    }

    /**
    * Returns the geo cache ID of this geo cache.
    *
    * @return the geo cache ID of this geo cache
    */
    @Override
    public long getGeoCacheId() {
        return _geoCache.getGeoCacheId();
    }

    /**
    * Sets the geo cache ID of this geo cache.
    *
    * @param geoCacheId the geo cache ID of this geo cache
    */
    @Override
    public void setGeoCacheId(long geoCacheId) {
        _geoCache.setGeoCacheId(geoCacheId);
    }

    /**
    * Returns the create date of this geo cache.
    *
    * @return the create date of this geo cache
    */
    @Override
    public java.util.Date getCreateDate() {
        return _geoCache.getCreateDate();
    }

    /**
    * Sets the create date of this geo cache.
    *
    * @param createDate the create date of this geo cache
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _geoCache.setCreateDate(createDate);
    }

    @Override
    public boolean isNew() {
        return _geoCache.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _geoCache.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _geoCache.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _geoCache.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _geoCache.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _geoCache.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _geoCache.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _geoCache.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _geoCache.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _geoCache.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _geoCache.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new GeoCacheWrapper((GeoCache) _geoCache.clone());
    }

    @Override
    public int compareTo(
        com.liferay.events.global.mobile.model.GeoCache geoCache) {
        return _geoCache.compareTo(geoCache);
    }

    @Override
    public int hashCode() {
        return _geoCache.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.events.global.mobile.model.GeoCache> toCacheModel() {
        return _geoCache.toCacheModel();
    }

    @Override
    public com.liferay.events.global.mobile.model.GeoCache toEscapedModel() {
        return new GeoCacheWrapper(_geoCache.toEscapedModel());
    }

    @Override
    public com.liferay.events.global.mobile.model.GeoCache toUnescapedModel() {
        return new GeoCacheWrapper(_geoCache.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _geoCache.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _geoCache.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _geoCache.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof GeoCacheWrapper)) {
            return false;
        }

        GeoCacheWrapper geoCacheWrapper = (GeoCacheWrapper) obj;

        if (Validator.equals(_geoCache, geoCacheWrapper._geoCache)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public GeoCache getWrappedGeoCache() {
        return _geoCache;
    }

    @Override
    public GeoCache getWrappedModel() {
        return _geoCache;
    }

    @Override
    public void resetOriginalValues() {
        _geoCache.resetOriginalValues();
    }
}
