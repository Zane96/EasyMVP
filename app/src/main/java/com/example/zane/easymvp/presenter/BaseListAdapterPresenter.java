package com.example.zane.easymvp.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.zane.easymvp.view.BaseListViewHolderImpl;

import java.util.List;


/**
 * Created by Zane on 15/12/18.
 */
public abstract class BaseListAdapterPresenter<M extends Object> extends RecyclerView.Adapter<BaseListViewHolderImpl>{

    protected Context mContext;
    protected List<M> mDatas;

    public BaseListAdapterPresenter(Context mContext){
        this(mContext, null);
    }

    public BaseListAdapterPresenter(Context mContext, List<M> mDatas){
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public BaseListViewHolderImpl onCreateViewHolder(ViewGroup parent, int viewType) {

        return OnCreatViewHolder(parent, viewType);
    }

    public abstract BaseListViewHolderImpl OnCreatViewHolder(ViewGroup parent, int viewType);


    public M getItem(int position){
        return mDatas.get(position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
