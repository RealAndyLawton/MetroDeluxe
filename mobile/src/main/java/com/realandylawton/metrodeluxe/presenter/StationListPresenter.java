package com.realandylawton.metrodeluxe.presenter;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import com.realandylawton.metrodeluxe.contracts.StationListContract;
import com.realandylawton.metrodeluxe.model.StationModel;
import com.realandylawton.metrodeluxe.model.StationsModel;
import com.realandylawton.metrodeluxe.mvp.ViewPresenter;

import java.util.List;

/**
 * Created by realandylawton on 12/11/14.
 */
public class StationListPresenter extends ViewPresenter<StationListContract> implements AdapterView.OnItemClickListener {

    private StationsModel mStationsModelModel;

    public StationListPresenter() {
        mStationsModelModel = new StationsModel();
    }

    @Override
    public Class<StationListContract> getPresenterContractClazz() {
        return StationListContract.class;
    }

    public void loadNearbyLocations(Context context) {
        final List<StationModel> nearbyStations = mStationsModelModel.getNearbyStations(context);
        if(nearbyStations == null || nearbyStations.isEmpty()) {
            mView.showUnableToFindStations();
        } else {
            mView.showStations(nearbyStations);
        }
    }

    public void setStationsModelModel(StationsModel stationsModelModel) {
        mStationsModelModel = stationsModelModel;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        getView().startStationTrainsActivity();
    }

}
