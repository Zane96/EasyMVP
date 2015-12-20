package com.example.zane.demo.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zane.demo.R;
import com.example.zane.easymvp.view.BaseViewImpl;

/**
 * Created by Zane on 15/12/20.
 */
public class MainListView extends BaseViewImpl{

    public RecyclerView mRecycleview;

    @Override
    public int getRootViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mRecycleview = (RecyclerView)getRootView().findViewById(R.id.recycleview);
    }

}
