package com.realandylawton.metrodeluxe.presenter;

import android.content.Context;

import com.realandylawton.metrodeluxe.contracts.TrainListContract;
import com.realandylawton.metrodeluxe.model.PredictionModel;
import com.realandylawton.metrodeluxe.model.TrainModel;
import com.realandylawton.metrodeluxe.mvp.ViewPresenter;

import java.util.List;

/**
 * Created by realandylawton on 12/11/14.
 */
public class TrainListPresenter extends ViewPresenter<TrainListContract> {

    private PredictionModel mPredictionModel;

    public TrainListPresenter() {
        mPredictionModel = new PredictionModel();
    }

    @Override
    public Class<TrainListContract> getPresenterContractClazz() {
        return TrainListContract.class;
    }

    public void loadUpcomingTrains(Context context) {
        final List<TrainModel> nextTrains = mPredictionModel.getNextTrains(context);
        if(nextTrains == null || nextTrains.isEmpty()) {
            mView.showNoTrainsDialog();
        } else {
            mView.showTrains(nextTrains);
        }
    }
}
