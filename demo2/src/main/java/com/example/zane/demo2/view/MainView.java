package com.example.zane.demo2.view;

import android.widget.EditText;

import com.example.zane.demo2.R;
import com.example.zane.easymvp.view.BaseViewImpl;

/**
 * Created by Zane on 16/1/15.
 */
public class MainView extends BaseViewImpl{

    private EditText mAccount;
    private EditText mPassword;

    @Override
    public int getRootViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mAccount = (EditText)getRootView().findViewById(R.id.account);
        mPassword = (EditText)getRootView().findViewById(R.id.password);
    }
}
