package com.example.zane.demo;

import android.os.Bundle;

import com.example.zane.easymvp.base.IView;
import com.example.zane.easymvp.presenter.BaseActivityPresenter;

/**
 * Created by Zane on 2016/12/11.
 * Email: zanebot96@gmail.com
 * Blog: zane96.github.io
 */

public abstract class BaseActivity<V extends IView> extends BaseActivityPresenter<V>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log();
    }

    public abstract void log();
}
