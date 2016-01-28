package com.example.zane.easymvp.presenter;

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

    public static final String VIEW = "V";

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
        v.initView();
        setContentView(v.getRootView());

        inCreat(savedInstanceState);
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//
//
//
//        super.onSaveInstanceState(outState);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//
//        if (savedInstanceState != null){
//            v = (V)savedInstanceState.getSerializable(VIEW);
//        }
//
//        super.onRestoreInstanceState(savedInstanceState);
//    }

    //接触绑定
    @Override
    protected void onDestroy() {
        super.onDestroy();
        v.removeView();
        v = null;
        inDestory();
    }

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

    public abstract Class<V> getRootViewClass();

    public abstract void inCreat(Bundle savedInstanceState);
    public abstract void inDestory();
    public void inPause(){}
    public void inRestart(){}
    public void inStop(){}
    public void inResume(){}
    public void inStart(){}


}
