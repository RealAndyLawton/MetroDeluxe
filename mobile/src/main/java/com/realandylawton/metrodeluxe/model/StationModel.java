package com.realandylawton.metrodeluxe.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by realandylawton on 12/11/14.
 */
public class StationModel {

    @SerializedName("Address")
    AddressModel mAddress;
    @SerializedName("Lat") Double mLat;
    @SerializedName("Lon") Double mLon;
    @SerializedName("LineCode1") String mLineCode1;
    @SerializedName("LineCode2") String mLineCode2;
    @SerializedName("LineCode3") String mLineCode3;
    @SerializedName("Name") String mName;

    public AddressModel getAddress() {
        return mAddress;
    }

    public Double getLat() {
        return mLat;
    }

    public Double getLon() {
        return mLon;
    }

    public String getLineCode1() {
        return mLineCode1;
    }

    public String getLineCode2() {
        return mLineCode2;
    }

    public String getLineCode3() {
        return mLineCode3;
    }

    public String getName() {
        return mName;
    }
}
