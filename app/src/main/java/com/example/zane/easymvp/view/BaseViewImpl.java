package com.example.zane.easymvp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Zane on 15/12/18.
 * 将view加载的过程写在抽象类，做到代码复用。
 */
public abstract class BaseViewImpl implements IView{

    protected View view;

    @Override
    public void creatView(LayoutInflater inflater, ViewGroup parent) {
        int resourceId = getRootViewId();

        if (resourceId == 0){
            throw new RuntimeException("rootview's id can't be null");
        }

        view = inflater.inflate(resourceId, parent, false);
    }

    @Override
    public View getRootView() {
        return view;
    }

    @Override
    public int getRootViewId() {
        return 0;
    }

    @Override
    public void initView() {

    }
}
