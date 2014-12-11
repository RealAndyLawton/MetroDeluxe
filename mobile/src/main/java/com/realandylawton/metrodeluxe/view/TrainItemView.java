package com.realandylawton.metrodeluxe.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.realandylawton.metrodeluxe.R;
import com.realandylawton.metrodeluxe.model.TrainModel;
import com.realandylawton.metrodeluxe.mvp.HasModel;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by realandylawton on 12/11/14.
 */
public class TrainItemView extends FrameLayout implements HasModel<TrainModel> {

    @InjectView(R.id.train_item_label) protected TextView mLabelView;
    @InjectView(R.id.train_item_icon) protected ImageView mIconView;

    public TrainItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
    }

    @Override
    public void setModel(TrainModel trainModel) {

        String label = parseLabel(trainModel.getMinutes());
        mLabelView.setText(label);

        Integer iconRes = getIconResForColor(trainModel.getLineColor());

        Picasso.with(getContext())
                .load(iconRes)
                .into(mIconView);

    }

    private String parseLabel(String minutes) {
        return (minutes.equals(TrainModel.BOARDING_MINUTES)) ? "Boarding" : String.format("%s minutes", minutes);
    }

    private Integer getIconResForColor(TrainModel.Color lineColor) {
        switch (lineColor) {
            case BLUE:
                return R.drawable.blue;
            case ORANGE:
                return R.drawable.orange;
            case SILVER:
                return R.drawable.silver;
            default:
                return 0;
        }
    }
}
