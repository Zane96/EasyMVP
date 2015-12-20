package com.example.zane.easymvp.view;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Zane on 15/12/18.
 * 将view加载的过程写在抽象类，做到代码复用。
 */
public abstract class BaseViewImpl implements IView{

    protected View view;
    protected final SparseArray<View> mViews = new SparseArray<View>();

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

    public <T extends View> T bindView(int id) {
        T view = (T) mViews.get(id);
        if (view == null) {
            view = (T) view.findViewById(id);
            mViews.put(id, view);
        }
        return view;
    }

    public <T extends View> T get(int id) {
        return (T) bindView(id);
    }

    @Override
    public int getRootViewId() {
        return 0;
    }

    @Override
    public void initView() {

    }
}
