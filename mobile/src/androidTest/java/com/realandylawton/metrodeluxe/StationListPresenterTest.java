package com.realandylawton.metrodeluxe;

import android.content.Context;

import com.realandylawton.metrodeluxe.contracts.StationListContract;
import com.realandylawton.metrodeluxe.model.StationModel;
import com.realandylawton.metrodeluxe.model.StationsModel;
import com.realandylawton.metrodeluxe.presenter.StationListPresenter;

import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

/**
 * Created by realandylawton on 12/12/14.
 */
public class StationListPresenterTest extends PresenterTests<StationListContract, StationListPresenter> {

    // Can Create mocks via annotations
    @Mock Context mMockContext;

    @Override
    public Class<?> getContractClazz() {
        return StationListContract.class;
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        final StationListPresenter stationListPresenter = new StationListPresenter();
        setPresenter(stationListPresenter);
        getPresenter().takeView(getViewContract());
    }

    public void testLoadNearbyStations_fails_showUnableToFindStations() throws Exception {

        final StationsModel stationsModelMock = Mockito.mock(StationsModel.class);
        final ArrayList<StationModel> emptyStations = new ArrayList<>();
        Mockito.when(stationsModelMock.getNearbyStations(mMockContext))
                .thenReturn(emptyStations);

        getPresenter().setStationsModelModel(stationsModelMock);

        getPresenter().loadNearbyLocations(mMockContext);

        Mockito.verify(getViewContract(), Mockito.times(1))
                .showUnableToFindStations();

        Mockito.verify(getViewContract(), Mockito.never())
                .startStationTrainsActivity();

    }

    public void testLoadNearbyStations_hasStations_showUnableToFindStations() throws Exception {

        final StationsModel stationsModelMock = Mockito.mock(StationsModel.class);
        final ArrayList<StationModel> someStations = new ArrayList<>();
        someStations.add(Mockito.mock(StationModel.class));

        Mockito.when(stationsModelMock.getNearbyStations(mMockContext))
                .thenReturn(someStations);
        getPresenter().setStationsModelModel(stationsModelMock);

        getPresenter().loadNearbyLocations(mMockContext);

        Mockito.verify(getViewContract(), Mockito.times(1))
                .showStations(someStations);

    }

}
