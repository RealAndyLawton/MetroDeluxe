package com.realandylawton.metrodeluxe.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by realandylawton on 12/11/14.
 */
public class TrainModel {

    public static String BOARDING_MINUTES = "BRD";

    public static enum Color {

        SILVER("SV"), ORANGE("OR"), BLUE("BL");

        private String key;

        Color(String key) {
            this.key = key;
        }

        public static Color getColorFromKey(String key) {
            for(Color color : Color.values()) {
                if(color.key.equals(key))
                    return color;
            }
            return null;
        }

    }

    @SerializedName("Car") protected String mCar;
    @SerializedName("Destination") protected String mDestinatino;
    @SerializedName("DestinationCode") protected String mDestinationCode;
    @SerializedName("DestinationName") protected String mDestinationName;
    @SerializedName("Group") protected String mGroup;
    @SerializedName("Line") protected String mLine;
    @SerializedName("LocationCode") protected String mLocationCode;
    @SerializedName("LocationName") protected String mLocationName;
    @SerializedName("Min") protected String mMinutes;

    public String getCar() {
        return mCar;
    }

    public String getDestinatino() {
        return mDestinatino;
    }

    public String getDestinationCode() {
        return mDestinationCode;
    }

    public String getDestinationName() {
        return mDestinationName;
    }

    public String getGroup() {
        return mGroup;
    }

    public String getLine() {
        return mLine;
    }

    public String getLocationCode() {
        return mLocationCode;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public String getMinutes() {
        return mMinutes;
    }

    public Color getLineColor() {
        return Color.getColorFromKey(getLine());
    }

}
