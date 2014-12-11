package com.realandylawton.metrodeluxe.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.realandylawton.metrodeluxe.R;
import com.realandylawton.metrodeluxe.model.TrainModel;
import com.realandylawton.metrodeluxe.view.TrainItemView;

/**
 * Created by realandylawton on 12/11/14.
 */
public class TrainListAdapter extends BetterBaseAdapter<TrainModel> {

    public TrainListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TrainItemView trainItemView = (convertView != null) ? (TrainItemView)convertView :
                (TrainItemView)getInflater().inflate(R.layout.train_item, parent, false);

        final TrainModel trainModel = getItem(position);
        trainItemView.setModel(trainModel);

        return trainItemView;

    }
}
