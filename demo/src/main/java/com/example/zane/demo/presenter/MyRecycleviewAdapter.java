package com.example.zane.demo.presenter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.zane.demo.model.data;
import com.example.zane.demo.view.MainListViewHolder;
import com.example.zane.easymvp.presenter.BaseListAdapterPresenter;
import com.example.zane.easymvp.view.BaseListViewHolderImpl;

import java.util.List;

/**
 * Created by Zane on 15/12/20.
 */
public class MyRecycleviewAdapter extends BaseListAdapterPresenter<data>{

    public MyRecycleviewAdapter(Context mContext, List<data> datas){
        super(mContext, datas);
    }



    @Override
    public BaseListViewHolderImpl OnCreatViewHolder(ViewGroup parent, int viewType) {
        return new MainListViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseListViewHolderImpl holder, int position) {
        holder.setData(getItem(position));
    }
}
