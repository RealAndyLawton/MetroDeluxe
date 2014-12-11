package com.realandylawton.metrodeluxe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by realandylawton on 12/11/14.
 */
public abstract class BetterBaseAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected LayoutInflater mInflater;
    private List<T> mItems;

    public BetterBaseAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mItems = new LinkedList<T>();
    }

    @Override public int getCount() {
        return mItems.size();
    }

    @Override public T getItem(int position) {
        return mItems.get(position);
    }

    @Override public long getItemId(int position) {
        return 0;
    }

    public List<T> getItems() {
        return mItems;
    }

    public void setItems(List<T> items) {
        if (items == null) {
            mItems = new LinkedList<T>();
        } else {
            mItems = items;
        }
        notifyDataSetChanged();
    }

    public Context getContext() {
        return mContext;
    }

    public LayoutInflater getInflater() {
        return mInflater;
    }
}