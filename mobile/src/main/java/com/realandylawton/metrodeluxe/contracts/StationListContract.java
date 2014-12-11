package com.realandylawton.metrodeluxe.contracts;

import com.realandylawton.metrodeluxe.model.StationModel;
import com.realandylawton.metrodeluxe.mvp.ViewContract;

import java.util.List;

/**
 * Created by realandylawton on 12/11/14.
 */
public interface StationListContract extends ViewContract {
    void showStations(List<StationModel> stationList);
    void showUnableToFindStations();
    void startStationTrainsActivity();
}
