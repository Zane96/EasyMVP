package com.example.zane.demo.view;

import android.widget.Button;
import android.widget.EditText;

import com.example.zane.demo.R;
import com.example.zane.easymvp.view.BaseViewImpl;

import butterknife.Bind;

/**
 * Created by Zane on 16/1/27.
 */
public class MainView2 extends BaseViewImpl {

    @Bind(R.id.button)
    Button button;


    @Override
    public int getRootViewId() {
        return R.layout.activity_2;
    }

}
