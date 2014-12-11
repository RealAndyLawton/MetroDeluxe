package com.realandylawton.metrodeluxe.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.realandylawton.metrodeluxe.activity.StationTrainsActivity;
import com.realandylawton.metrodeluxe.adapter.StationListAdapter;
import com.realandylawton.metrodeluxe.contracts.StationListContract;
import com.realandylawton.metrodeluxe.model.StationModel;
import com.realandylawton.metrodeluxe.presenter.StationListPresenter;

import java.util.List;

/**
 * Created by realandylawton on 12/11/14.
 */
public class StationListView extends ListView implements StationListContract {

    private StationListAdapter mListAdapter;
    private StationListPresenter mPresenter;

    public StationListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPresenter = new StationListPresenter();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mPresenter.takeView(this);

        mListAdapter = new StationListAdapter(getContext());
        setOnItemClickListener(mPresenter);
        setAdapter(mListAdapter);

        mPresenter.loadNearbyLocations(getContext());

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mPresenter.dropView();
    }

    @Override
    public void showStations(List<StationModel> stationList) {
        mListAdapter.setItems(stationList);
        mListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showUnableToFindStations() {
        new AlertDialog.Builder(getContext())
                .setTitle("Error")
                .setMessage("Unable to find trains nearby")
                .create()
                .show();
    }

    @Override
    public void startStationTrainsActivity() {
        final Intent intent = new Intent(getContext(), StationTrainsActivity.class);
        getContext().startActivity(intent);
    }

}
