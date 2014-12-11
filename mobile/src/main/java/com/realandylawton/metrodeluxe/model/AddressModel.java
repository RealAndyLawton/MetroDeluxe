package com.realandylawton.metrodeluxe.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by realandylawton on 12/11/14.
 */
public class AddressModel {

    @SerializedName("City") protected String mCity;
    @SerializedName("State") protected String mState;
    @SerializedName("Street") protected String mStreet;
    @SerializedName("Zip") protected String mZip;

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getStreet() {
        return mStreet;
    }

    public void setStreet(String street) {
        mStreet = street;
    }

    public String getZip() {
        return mZip;
    }

    public void setZip(String zip) {
        mZip = zip;
    }
}
