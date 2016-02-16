package com.example.zane.easymvp.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

/**
 * Created by Zane on 15/12/18.
 * 所有view子类的基接口。确定最基础的操作方法
 */
public interface IView{

    void creatView(LayoutInflater inflater, ViewGroup parent, Bundle bundle);

    View getRootView();

    int getRootViewId();

    void initView();

    void removeView();
}
