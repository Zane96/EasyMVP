package com.example.zane.demo.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.zane.demo.R;
import com.example.zane.demo.presenter.MyRecycleviewAdapter;
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
        mRecycleview = $(R.id.recycleview);
    }

    public void initRecycleview(LinearLayoutManager manager, MyRecycleviewAdapter adapter){
        mRecycleview.setAdapter(adapter);
        mRecycleview.setLayoutManager(manager);
    }

}
