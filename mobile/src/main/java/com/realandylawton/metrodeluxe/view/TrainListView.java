package com.realandylawton.metrodeluxe.view;

import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import com.realandylawton.metrodeluxe.adapter.TrainListAdapter;
import com.realandylawton.metrodeluxe.contracts.TrainListContract;
import com.realandylawton.metrodeluxe.model.TrainModel;
import com.realandylawton.metrodeluxe.presenter.TrainListPresenter;

import java.util.List;

/**
 * Created by realandylawton on 12/11/14.
 */
public class TrainListView extends ListView implements TrainListContract {

    private final TrainListPresenter mPresenter;
    private TrainListAdapter mTrainListAdapter;

    public TrainListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPresenter = new TrainListPresenter();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mPresenter.takeView(this);

        mTrainListAdapter = new TrainListAdapter(getContext());
        setAdapter(mTrainListAdapter);

        mPresenter.loadUpcomingTrains(getContext());

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mPresenter.dropView();
    }

    @Override
    public void showTrains(List<TrainModel> trainList) {
        mTrainListAdapter.setItems(trainList);
        mTrainListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showNoTrainsDialog() {
        new AlertDialog.Builder(getContext())
                .setTitle("Error")
                .setMessage("No upcoming trains")
                .create()
                .show();
    }
}
