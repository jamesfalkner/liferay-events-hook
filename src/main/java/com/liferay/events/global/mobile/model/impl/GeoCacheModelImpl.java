package com.liferay.events.global.mobile.model.impl;

import com.liferay.events.global.mobile.model.GeoCache;
import com.liferay.events.global.mobile.model.GeoCacheModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the GeoCache service. Represents a row in the &quot;Matcher_GeoCache&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.events.global.mobile.model.GeoCacheModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GeoCacheImpl}.
 * </p>
 *
 * @author James Falkner
 * @see GeoCacheImpl
 * @see com.liferay.events.global.mobile.model.GeoCache
 * @see com.liferay.events.global.mobile.model.GeoCacheModel
 * @generated
 */
public class GeoCacheModelImpl extends BaseModelImpl<GeoCache>
    implements GeoCacheModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a geo cache model instance should use the {@link com.liferay.events.global.mobile.model.GeoCache} interface instead.
     */
    public static final String TABLE_NAME = "Matcher_GeoCache";
    public static final Object[][] TABLE_COLUMNS = {
            { "address", Types.VARCHAR },
            { "lat", Types.DOUBLE },
            { "lng", Types.DOUBLE },
            { "geoCacheId", Types.BIGINT },
            { "createDate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table Matcher_GeoCache (address VARCHAR(75) null,lat DOUBLE,lng DOUBLE,geoCacheId LONG not null primary key,createDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table Matcher_GeoCache";
    public static final String ORDER_BY_JPQL = " ORDER BY geoCache.geoCacheId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY Matcher_GeoCache.geoCacheId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.liferay.events.global.mobile.model.GeoCache"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.liferay.events.global.mobile.model.GeoCache"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.liferay.events.global.mobile.model.GeoCache"),
            true);
    public static long ADDRESS_COLUMN_BITMASK = 1L;
    public static long GEOCACHEID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.liferay.events.global.mobile.model.GeoCache"));
    private static ClassLoader _classLoader = GeoCache.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            GeoCache.class
        };
    private String _address;
    private String _originalAddress;
    private double _lat;
    private double _lng;
    private long _geoCacheId;
    private Date _createDate;
    private long _columnBitmask;
    private GeoCache _escapedModel;

    public GeoCacheModelImpl() {
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

    @Override
    public String getAddress() {
        if (_address == null) {
            return StringPool.BLANK;
        } else {
            return _address;
        }
    }

    @Override
    public void setAddress(String address) {
        _columnBitmask |= ADDRESS_COLUMN_BITMASK;

        if (_originalAddress == null) {
            _originalAddress = _address;
        }

        _address = address;
    }

    public String getOriginalAddress() {
        return GetterUtil.getString(_originalAddress);
    }

    @Override
    public double getLat() {
        return _lat;
    }

    @Override
    public void setLat(double lat) {
        _lat = lat;
    }

    @Override
    public double getLng() {
        return _lng;
    }

    @Override
    public void setLng(double lng) {
        _lng = lng;
    }

    @Override
    public long getGeoCacheId() {
        return _geoCacheId;
    }

    @Override
    public void setGeoCacheId(long geoCacheId) {
        _geoCacheId = geoCacheId;
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            GeoCache.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public GeoCache toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (GeoCache) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        GeoCacheImpl geoCacheImpl = new GeoCacheImpl();

        geoCacheImpl.setAddress(getAddress());
        geoCacheImpl.setLat(getLat());
        geoCacheImpl.setLng(getLng());
        geoCacheImpl.setGeoCacheId(getGeoCacheId());
        geoCacheImpl.setCreateDate(getCreateDate());

        geoCacheImpl.resetOriginalValues();

        return geoCacheImpl;
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

        if (!(obj instanceof GeoCache)) {
            return false;
        }

        GeoCache geoCache = (GeoCache) obj;

        long primaryKey = geoCache.getPrimaryKey();

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
    public void resetOriginalValues() {
        GeoCacheModelImpl geoCacheModelImpl = this;

        geoCacheModelImpl._originalAddress = geoCacheModelImpl._address;

        geoCacheModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<GeoCache> toCacheModel() {
        GeoCacheCacheModel geoCacheCacheModel = new GeoCacheCacheModel();

        geoCacheCacheModel.address = getAddress();

        String address = geoCacheCacheModel.address;

        if ((address != null) && (address.length() == 0)) {
            geoCacheCacheModel.address = null;
        }

        geoCacheCacheModel.lat = getLat();

        geoCacheCacheModel.lng = getLng();

        geoCacheCacheModel.geoCacheId = getGeoCacheId();

        Date createDate = getCreateDate();

        if (createDate != null) {
            geoCacheCacheModel.createDate = createDate.getTime();
        } else {
            geoCacheCacheModel.createDate = Long.MIN_VALUE;
        }

        return geoCacheCacheModel;
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