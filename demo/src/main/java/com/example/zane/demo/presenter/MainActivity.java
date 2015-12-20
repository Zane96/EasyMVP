package com.example.zane.demo.presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.zane.demo.R;
import com.example.zane.demo.model.data;
import com.example.zane.demo.view.MainListView;
import com.example.zane.easymvp.presenter.BaseActivityPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivityPresenter<MainListView>{

    public LinearLayoutManager linearLayoutManager;
    public MyRecycleviewAdapter adapter;
    public List<data> datas = new ArrayList<>();

    @Override
    public Class<MainListView> getRootViewClass() {
        return MainListView.class;
    }

    @Override
    public void inCreat() {
        for (int i = 0; i <= 10; i++){
            datas.add(new data());
        }
        linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MyRecycleviewAdapter(this, datas);
        v.mRecycleview.setAdapter(adapter);
        v.mRecycleview.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void inDestory() {

    }
}
