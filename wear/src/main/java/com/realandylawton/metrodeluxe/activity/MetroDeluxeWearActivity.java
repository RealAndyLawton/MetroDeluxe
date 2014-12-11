package com.realandylawton.metrodeluxe.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.CardScrollView;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;
import android.view.Gravity;
import android.widget.TextView;

import com.realandylawton.metrodeluxe.R;
import com.realandylawton.metrodeluxe.adapter.ListViewAdapter;

public class MetroDeluxeWearActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.station_info_layout);
        WearableListView listView =
                (WearableListView) findViewById(R.id.wearable_list);
        listView.setAdapter(new ListViewAdapter(this));
    }
}
