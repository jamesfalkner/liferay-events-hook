package com.liferay.events.global.mobile.model.impl;

import com.liferay.events.global.mobile.model.GeoCache;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GeoCache in entity cache.
 *
 * @author James Falkner
 * @see GeoCache
 * @generated
 */
public class GeoCacheCacheModel implements CacheModel<GeoCache>, Externalizable {
    public String address;
    public double lat;
    public double lng;
    public long geoCacheId;
    public long createDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{address=");
        sb.append(address);
        sb.append(", lat=");
        sb.append(lat);
        sb.append(", lng=");
        sb.append(lng);
        sb.append(", geoCacheId=");
        sb.append(geoCacheId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public GeoCache toEntityModel() {
        GeoCacheImpl geoCacheImpl = new GeoCacheImpl();

        if (address == null) {
            geoCacheImpl.setAddress(StringPool.BLANK);
        } else {
            geoCacheImpl.setAddress(address);
        }

        geoCacheImpl.setLat(lat);
        geoCacheImpl.setLng(lng);
        geoCacheImpl.setGeoCacheId(geoCacheId);

        if (createDate == Long.MIN_VALUE) {
            geoCacheImpl.setCreateDate(null);
        } else {
            geoCacheImpl.setCreateDate(new Date(createDate));
        }

        geoCacheImpl.resetOriginalValues();

        return geoCacheImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        address = objectInput.readUTF();
        lat = objectInput.readDouble();
        lng = objectInput.readDouble();
        geoCacheId = objectInput.readLong();
        createDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (address == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(address);
        }

        objectOutput.writeDouble(lat);
        objectOutput.writeDouble(lng);
        objectOutput.writeLong(geoCacheId);
        objectOutput.writeLong(createDate);
    }
}
