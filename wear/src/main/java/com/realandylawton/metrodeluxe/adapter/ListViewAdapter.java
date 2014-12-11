package com.realandylawton.metrodeluxe.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.realandylawton.metrodeluxe.R;

/**
 * Created by johnfontaine on 12/11/14.
 */
public class ListViewAdapter extends WearableListView.Adapter {
    private final String[] mTrainDetailsData = {"5 min Franconia-Springfield", "7 min Wiehle-Reston East", "7 min New Carrollton", "15 min Vienna", "15 min Largo Town Center"};
    private final Integer[] mTrainColorData = {0, 1, 2, 2, 1};
    private final Context mContext;
    private final LayoutInflater mInflater;
    public ListViewAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(mInflater.inflate(R.layout.train_info_layout, null));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder, int i) {
        ItemViewHolder itemHolder = (ItemViewHolder) holder;
        itemHolder.detailsView.setText(mTrainDetailsData[i]);
        itemHolder.circleImageView.setImageLevel(mTrainColorData[i]);
    }

    @Override
    public int getItemCount() {
        return mTrainDetailsData.length;
    }

    public static class ItemViewHolder extends WearableListView.ViewHolder {
        private TextView detailsView;
        private ImageView circleImageView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            // find the text view within the custom item's layout
            detailsView = (TextView) itemView.findViewById(R.id.train_details);
            circleImageView = (ImageView) itemView.findViewById(R.id.circle);
        }
    }

}
