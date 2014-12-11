package com.realandylawton.metrodeluxe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realandylawton.metrodeluxe.R;
import com.realandylawton.metrodeluxe.model.StationModel;
import com.realandylawton.metrodeluxe.view.StationItemView;

/**
 * Created by realandylawton on 12/11/14.
 */
public class StationListAdapter extends BetterBaseAdapter<StationModel> {

    public StationListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(getContext());

        StationItemView stationItemView = (convertView != null) ? (StationItemView)convertView :
                (StationItemView)inflater.inflate(R.layout.station_item, parent, false);

        final StationModel item = getItem(position);
        stationItemView.setModel(item);

        return stationItemView;

    }

}
