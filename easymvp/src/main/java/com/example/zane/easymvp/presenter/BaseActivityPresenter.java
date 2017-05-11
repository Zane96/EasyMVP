package com.example.zane.easymvp.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.zane.easymvp.base.IPersenter;
import com.example.zane.easymvp.base.IView;


/**
 * Created by Zane on 15/12/18.
 */
public abstract class BaseActivityPresenter<V extends IView> extends AppCompatActivity implements IPersenter{

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

        v.creatView(getLayoutInflater(), null, savedInstanceState);
        v.initView();
        v.injectPresenter(getPersenter());

        setContentView(v.getRootView());

        inCreat(savedInstanceState);
    }
    //解除绑定
    @Override
    protected void onDestroy() {
        super.onDestroy();
        inDestory();
        v.removeView();
        v.onPresenterDestory();
        v = null;
    }

    public abstract Class<V> getRootViewClass();
    public abstract void inCreat(Bundle savedInstanceState);
    public abstract void inDestory();
    public abstract IPersenter getPersenter();

}
