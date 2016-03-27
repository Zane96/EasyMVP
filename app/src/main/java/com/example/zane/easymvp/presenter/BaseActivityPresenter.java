package com.example.zane.easymvp.presenter;

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
        v.setActivityContext(getContext());

        setContentView(v.getRootView());

        inCreat(savedInstanceState);
    }
    //接触绑定
    @Override
    protected void onDestroy() {
        super.onDestroy();
        v.removeView();
        v = null;
        inDestory();
    }

    public abstract Class<V> getRootViewClass();
    public abstract void inCreat(Bundle savedInstanceState);
    public abstract void inDestory();
    public abstract Context getContext();
    public void inPause(){}
    public void inRestart(){}
    public void inStop(){}
    public void inResume(){}
    public void inStart(){}

    @Override
    protected void onStart() {
        super.onStart();
        inStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        inResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        inStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        inRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        inPause();
    }


}
