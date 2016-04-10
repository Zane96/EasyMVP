package com.example.zane.demo.presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.zane.demo.Bean.Data_One;
import com.example.zane.demo.Bean.Data_Two;
import com.example.zane.demo.Bean.RecycleviewData;
import com.example.zane.demo.Constant;
import com.example.zane.demo.view.MainListView;
import com.example.zane.easymvp.presenter.BaseActivityPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivityPresenter<MainListView>{

    public LinearLayoutManager linearLayoutManager;
    public MyRecycleviewAdapter adapter;
    public List<RecycleviewData> datas = new ArrayList<>();

    private static final String TAG = "MainActivity_demo";

    @Override
    public Class<MainListView> getRootViewClass() {
        return MainListView.class;
    }

    @Override
    public void inCreat(Bundle bundle) {

        for (int i = 0; i < Constant.DataOne.length; i++){
            RecycleviewData recycleviewData = new RecycleviewData();
            recycleviewData.setData_one(new Data_One(Constant.DataOne[i]));
            datas.add(recycleviewData);
            Log.i(TAG, Constant.DataOne[i]);
        }

        for (int j = 0; j < Constant.DataTwo.length; j++){
            RecycleviewData recycleviewData = new RecycleviewData();
            recycleviewData.setData_two(new Data_Two(Constant.DataTwo[j]));
            datas.add(recycleviewData);
        }

        linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MyRecycleviewAdapter(this, datas);
        v.initRecycleview(linearLayoutManager, adapter);


    }

    @Override
    public void inDestory() {

    }

    @Override
    public AppCompatActivity getContext() {
        return this;
    }
}
