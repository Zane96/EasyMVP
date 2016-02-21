package com.example.zane.easymvp.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Zane on 15/12/18.
 * 这个中间的base层用来做到viewholder与adapter的解耦。
 */
public abstract class BaseListViewHolderImpl<M extends Object> extends RecyclerView.ViewHolder{

    private  View view;
    protected final SparseArray<View> mViews = new SparseArray<View>();

    public BaseListViewHolderImpl(View itemView) {
        super(itemView);
        this.view = itemView;
        initView();
    }

    //生成viewholder的构造方法。
    public BaseListViewHolderImpl(ViewGroup parent, @LayoutRes int res){
        super(LayoutInflater.from(parent.getContext()).inflate(res, parent, false));
        view = LayoutInflater.from(parent.getContext()).inflate(res, parent, false);
        initView();
    }

    public abstract void initView();

    public abstract void setData(M data);

    final protected <T extends View> T $(@IdRes int id) {
        return (T) view.findViewById(id);
    }


}
