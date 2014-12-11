package com.realandylawton.metrodeluxe.model;

import android.content.Context;

import com.google.gson.annotations.SerializedName;
import com.realandylawton.metrodeluxe.util.JsonAssetsLoader;

import java.io.IOException;
import java.util.List;

/**
 * Created by realandylawton on 12/11/14.
 */
public class PredictionModel {

    @SerializedName("Trains") protected List<TrainModel> mTrains;

    public List<TrainModel> getNextTrains(Context context) {
        final PredictionModel cannedPredictions = getCannedPredictions(context);
        return (cannedPredictions != null) ? cannedPredictions.getTrains() : null;
    }

    private PredictionModel getCannedPredictions(Context context) {
        PredictionModel predictionModel = null;
        try {
            predictionModel = JsonAssetsLoader.parseAsset(context, "GetPrediction.json", PredictionModel.class);
        } catch (IOException e) {
            // Failed to parse
        }
        return predictionModel;
    }

    public List<TrainModel> getTrains() {
        return mTrains;
    }

    public void setTrains(List<TrainModel> trains) {
        mTrains = trains;
    }
}
