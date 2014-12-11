package com.realandylawton.metrodeluxe.model;

import android.content.Context;
import android.location.Location;

import com.google.gson.annotations.SerializedName;
import com.realandylawton.metrodeluxe.util.JsonAssetsLoader;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by realandylawton on 12/11/14.
 */
public class StationsModel {

    private static final double ARTISPHERE_LAT = 38.895452;
    private static final double ARTISPHERE_LON = -77.070004;
    private static final int NEARBY_THRESHOLD_METERS = 5000;

    public List<StationModel> getNearbyStations(Context context) {

        final StationsModel cannedStations = getCannedStations(context);
        if(cannedStations == null)
            return null;

        final List<StationModel> nearbyStations = new LinkedList<>();

        for(StationModel station : cannedStations.getStations()) {
            float[] results = new float[1];
            Location.distanceBetween(ARTISPHERE_LAT, ARTISPHERE_LON, station.getLat(), station.getLon(), results);
            float distanceInMeters = results[0];
            if(distanceInMeters < NEARBY_THRESHOLD_METERS) {
                nearbyStations.add(station);
            }
        }

        return nearbyStations;

    }

    @SerializedName("Stations") protected List<StationModel> mStations;

    public List<StationModel> getStations() {
        return mStations;
    }

    public void setStations(List<StationModel> stations) {
        mStations = stations;
    }

    private StationsModel getCannedStations(Context context) {
        StationsModel stationsModel = null;
        try {
            stationsModel = JsonAssetsLoader.parseAsset(context, "Stations.json", StationsModel.class);
        } catch (IOException e) {
            // Failed
        }
        return stationsModel;
    }

}
