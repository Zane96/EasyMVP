package com.example.zane.demo.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zane.demo.R;
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
    public void setActivityContext(Activity activity) {
        context = activity;
    }

    @Override
    public void onPresenterDestory() {
        Toast.makeText(context, "destory", Toast.LENGTH_SHORT).show();
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
