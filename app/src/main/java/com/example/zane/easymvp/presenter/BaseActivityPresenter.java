package com.example.zane.easymvp.presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.zane.easymvp.view.IView;

/**
 * Created by Zane on 15/12/18.
 */
public abstract class BaseActivityPresenter<V extends IView> extends AppCompatActivity{

    protected V v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            v = getRootViewClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        v.creatView(getLayoutInflater(), null);
        setContentView(v.getRootView());

        inCreat();
    }

    //接触绑定
    @Override
    protected void onDestroy() {
        super.onDestroy();
        v = null;
        inDestory();
    }


    public abstract Class<V> getRootViewClass();

    public abstract void inCreat();
    public abstract void inDestory();
}
