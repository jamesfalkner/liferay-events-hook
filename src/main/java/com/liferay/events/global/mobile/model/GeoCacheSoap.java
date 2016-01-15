package com.liferay.events.global.mobile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author James Falkner
 * @generated
 */
public class GeoCacheSoap implements Serializable {
    private String _address;
    private double _lat;
    private double _lng;
    private long _geoCacheId;
    private Date _createDate;

    public GeoCacheSoap() {
    }

    public static GeoCacheSoap toSoapModel(GeoCache model) {
        GeoCacheSoap soapModel = new GeoCacheSoap();

        soapModel.setAddress(model.getAddress());
        soapModel.setLat(model.getLat());
        soapModel.setLng(model.getLng());
        soapModel.setGeoCacheId(model.getGeoCacheId());
        soapModel.setCreateDate(model.getCreateDate());

        return soapModel;
    }

    public static GeoCacheSoap[] toSoapModels(GeoCache[] models) {
        GeoCacheSoap[] soapModels = new GeoCacheSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static GeoCacheSoap[][] toSoapModels(GeoCache[][] models) {
        GeoCacheSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new GeoCacheSoap[models.length][models[0].length];
        } else {
            soapModels = new GeoCacheSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static GeoCacheSoap[] toSoapModels(List<GeoCache> models) {
        List<GeoCacheSoap> soapModels = new ArrayList<GeoCacheSoap>(models.size());

        for (GeoCache model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new GeoCacheSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _geoCacheId;
    }

    public void setPrimaryKey(long pk) {
        setGeoCacheId(pk);
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public double getLat() {
        return _lat;
    }

    public void setLat(double lat) {
        _lat = lat;
    }

    public double getLng() {
        return _lng;
    }

    public void setLng(double lng) {
        _lng = lng;
    }

    public long getGeoCacheId() {
        return _geoCacheId;
    }

    public void setGeoCacheId(long geoCacheId) {
        _geoCacheId = geoCacheId;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }
}
