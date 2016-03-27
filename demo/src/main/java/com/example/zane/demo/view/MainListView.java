package com.example.zane.demo.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zane.demo.R;
import com.example.zane.demo.presenter.MyRecycleviewAdapter;
import com.example.zane.easymvp.view.BaseViewImpl;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Zane on 15/12/20.
 */
public class MainListView extends BaseViewImpl {
    @Bind(R.id.recycleview)
    RecyclerView mRecycleview;

    @Override
    public int getRootViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void setActivityContext(Context activity) {

    }


    public void initRecycleview(LinearLayoutManager manager, MyRecycleviewAdapter adapter) {
        mRecycleview.setAdapter(adapter);
        mRecycleview.setLayoutManager(manager);
    }

}
