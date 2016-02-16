package com.example.zane.easymvp.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

import butterknife.ButterKnife;


/**
 * Created by Zane on 15/12/18.
 * 将view加载的过程写在抽象类，做到代码复用。
 */
public abstract class BaseViewImpl implements IView{

    protected View view;
    protected final SparseArray<View> mViews = new SparseArray<View>();

    @Override
    final public void creatView(LayoutInflater inflater, ViewGroup parent, Bundle bundle) {
        int resourceId = getRootViewId();

        if (resourceId == 0){
            throw new RuntimeException("rootview's id can't be null");
        }

        view = inflater.inflate(resourceId, parent, false);
    }

    @Override
    final public View getRootView() {
        return view;
    }
    @Override
    public abstract int getRootViewId();

    //添加注解view方式
    @Override
    final public void initView() {
        ButterKnife.bind(this, view);
    }

    @Override
    final public void removeView() {
        ButterKnife.unbind(this);
    }

    final public <T extends View> T bindView(int id) {
        T view2 = (T) mViews.get(id);
        if (view2 == null) {
            view2 = $(id);
            mViews.put(id, view2);
        }
        return view2;
    }

    final public <T extends View> T get(int id) {
        return (T) bindView(id);
    }

    final protected <T extends View> T $(@IdRes int id) {
        return (T) view.findViewById(id);
    }


    final public void setOnClickListener(View.OnClickListener listener, int... ids) {
        if (ids == null) {
            return;
        }
        for (int id : ids) {
            get(id).setOnClickListener(listener);
        }
    }
}
