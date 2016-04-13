package com.example.zane.demo.view;

import android.support.annotation.LayoutRes;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zane.demo.Bean.Data_One;
import com.example.zane.demo.Bean.RecycleviewData;
import com.example.zane.demo.R;
import com.example.zane.easymvp.view.BaseListViewHolderImpl;


/**
 * Created by Zane on 15/12/20.
 */
public class DataOneViewHolder extends BaseListViewHolderImpl<Data_One> {

    private TextView mTextView;

    public DataOneViewHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
    }

    @Override
    public void initView() {
        mTextView = get(R.id.item_text_show);
    }

    @Override
    public void setData(Data_One data) {
        mTextView.setText(data.getDataOne());
    }

}
