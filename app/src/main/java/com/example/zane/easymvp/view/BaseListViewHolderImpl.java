package com.example.zane.easymvp.view;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Zane on 15/12/18.
 * 这个中间的base层用来做到viewholder与adapter的解耦。
 */
public abstract class BaseListViewHolderImpl<M extends Object> extends RecyclerView.ViewHolder{

    public BaseListViewHolderImpl(View itemView) {
        super(itemView);
    }

    //生成viewholder的构造方法。
    public BaseListViewHolderImpl(ViewGroup parent, @LayoutRes int res){
        super(LayoutInflater.from(parent.getContext()).inflate(res, parent, false));
    }

    public abstract void initView();


    public void setData(M data){

    }


    protected <T extends View> T $(@IdRes int id) {
        return (T) itemView.findViewById(id);
    }

}
