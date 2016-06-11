package com.example.zane.easymvp.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.zane.easymvp.view.IView;

import java.io.Serializable;

import butterknife.ButterKnife;


/**
 * Created by Zane on 15/12/18.
 */
public abstract class BaseActivityPresenter<V extends IView> extends AppCompatActivity{

    protected V v;
    private static final String V_STATE = "vState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BaseActivityPresenter", "creat");
        try {
            v = getRootViewClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        v.creatView(getLayoutInflater(), null, savedInstanceState);
        v.initView();
        v.setActivityContext(getContext());

        setContentView(v.getRootView());

        inCreat(savedInstanceState);
    }
    //解除绑定
    @Override
    protected void onDestroy() {
        super.onDestroy();
        inDestory();
        v.removeView();
        v = null;
    }

    public abstract Class<V> getRootViewClass();
    public abstract void inCreat(Bundle savedInstanceState);
    public abstract void inDestory();
    public abstract Activity getContext();

}
