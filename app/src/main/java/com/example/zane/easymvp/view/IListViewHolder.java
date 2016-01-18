package com.example.zane.easymvp.view;


import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * Created by Zane on 15/12/18.
 */
public interface IListViewHolder {

    void initView();

    void initViewByButterKinfeInActivity(Activity context);

    void initViewByButterKinefInFragment(Context context, View view);

}
