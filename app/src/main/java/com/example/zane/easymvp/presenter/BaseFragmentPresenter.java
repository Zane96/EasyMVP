package com.example.zane.easymvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zane.easymvp.view.IView;

/**
 * Created by Zane on 15/12/18.
 */
public abstract class BaseFragmentPresenter<T extends IView> extends Fragment{

    protected T v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            v = getRootViewClass().newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        v.creatView(inflater, container);
        v.initView();
        inCreatView();

        return v.getRootView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        v = null;
        inDestory();
    }

    public abstract Class<T> getRootViewClass();

    public abstract void inCreatView();
    public abstract void inDestory();
}
