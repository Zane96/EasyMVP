package com.example.zane.easymvp.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
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
        v.creatView(inflater, container, savedInstanceState);
        v.setActivityContext((Activity) getContext());
        return v.getRootView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v.initView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        v.removeView();
        v = null;
    }
    
    public abstract Class<T> getRootViewClass();
    public abstract FragmentActivity getContext();

}
