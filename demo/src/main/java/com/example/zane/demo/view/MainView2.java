package com.example.zane.demo.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zane.demo.R;
import com.example.zane.demo.presenter.MainActivity;
import com.example.zane.easymvp.view.BaseViewImpl;

import butterknife.Bind;

/**
 * Created by Zane on 16/1/27.
 */
public class MainView2 extends BaseViewImpl {

    @Bind(R.id.button)
    Button button;
    @Bind(R.id.button2)
    Button button2;
    private Context context;

    @Override
    public int getRootViewId() {
        return R.layout.activity_2;
    }

    @Override
    public void setActivityContext(AppCompatActivity activity) {
        context = activity;
    }

    public void ClickButtonShowToast() {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "传递context到View层中去", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
