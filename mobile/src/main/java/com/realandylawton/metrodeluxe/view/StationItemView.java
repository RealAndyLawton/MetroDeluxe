package com.realandylawton.metrodeluxe.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.realandylawton.metrodeluxe.R;
import com.realandylawton.metrodeluxe.model.StationModel;
import com.realandylawton.metrodeluxe.mvp.HasModel;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by realandylawton on 12/11/14.
 */
public class StationItemView extends FrameLayout implements HasModel<StationModel> {

    @InjectView(R.id.station_item_label) protected TextView mLabelView;

    public StationItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
    }

    public void setModel(StationModel stationModel) {
        mLabelView.setText(stationModel.getName());
    }

}
