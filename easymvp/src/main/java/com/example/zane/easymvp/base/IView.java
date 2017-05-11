package com.example.zane.easymvp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

/**
 * Created by Zane on 15/12/18.
 * 所有view子类的基接口。确定最基础的操作方法
 */
public interface IView{

    /**
     * 加载根视图
     * @param inflater
     * @param parent
     * @param bundle
     */
    void creatView(LayoutInflater inflater, ViewGroup parent, Bundle bundle);

    /**
     * 返回根视图给presenter
     * @return
     */
    View getRootView();

    /**
     * 返回根视图的id
     * @return
     */
    int getRootViewId();

    /**
     * 初始化组件，默认使用butterKinfe
     */
    void initView();

    /**
     * 解除butterkinfe的绑定
     */
    void removeView();

    /**
     * 注入P
     * @param persenter
     */
    void injectPresenter(IPersenter persenter);

    /**
     * 在presenter销毁的时候调用,生命周期同步一下,有时候需要在view释放什么
     */
    void onPresenterDestory();
}
