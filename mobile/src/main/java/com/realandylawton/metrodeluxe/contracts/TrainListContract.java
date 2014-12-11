package com.realandylawton.metrodeluxe.contracts;

import com.realandylawton.metrodeluxe.model.TrainModel;
import com.realandylawton.metrodeluxe.mvp.ViewContract;

import java.util.List;

/**
 * Created by realandylawton on 12/11/14.
 */
public interface TrainListContract extends ViewContract {
    void showTrains(List<TrainModel> trainList);
    void showNoTrainsDialog();
}
