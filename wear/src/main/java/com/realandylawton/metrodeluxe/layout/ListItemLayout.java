package com.realandylawton.metrodeluxe.layout;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.realandylawton.metrodeluxe.R;

/**
 * Created by johnfontaine on 12/11/14.
 */
public class ListItemLayout extends LinearLayout
        implements WearableListView.Item {
    protected ImageView mCircle;
    protected TextView mTrainDetails;
    protected float mScale;
    private final float mFadedTextAlpha;
    public ListItemLayout(Context context) {
        super(context);
        mFadedTextAlpha = getResources()
                .getInteger(R.integer.action_text_faded_alpha) / 100f;
        init(context);
    }

    private void init(Context context) {

    }

    public ListItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mFadedTextAlpha = getResources()
                .getInteger(R.integer.action_text_faded_alpha) / 100f;
        init(context);
    }

    public ListItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mFadedTextAlpha = getResources()
                .getInteger(R.integer.action_text_faded_alpha) / 100f;
        init(context);
    }

    public ListItemLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mFadedTextAlpha = getResources()
                .getInteger(R.integer.action_text_faded_alpha) / 100f;
        init(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mCircle =  (ImageView) findViewById(R.id.circle);
        mTrainDetails = (TextView)findViewById(R.id.train_details);
    }

    @Override
    public float getProximityMinValue() {
        return 1f;
    }

    @Override
    public float getProximityMaxValue() {
        return 1.6f;
    }

    @Override
    public float getCurrentProximityValue() {
        return mScale;
    }

    @Override
    public void setScalingAnimatorValue(float v) {
        mScale = v;
        mCircle.setScaleX(mScale);
        mCircle.setScaleY(mScale);
    }

    @Override
    public void onScaleUpStart() {
        mTrainDetails.setAlpha(1f);
    }

    @Override
    public void onScaleDownStart() {
        mTrainDetails.setAlpha(mFadedTextAlpha);
    }
}
