package com.example.zane.demo.view;

import android.support.annotation.LayoutRes;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zane.demo.App;
import com.example.zane.demo.Bean.Data_Two;
import com.example.zane.demo.Bean.RecycleviewData;
import com.example.zane.demo.R;
import com.example.zane.easymvp.view.BaseListViewHolderImpl;

/**
 * Created by Zane on 16/4/10.
 */
public class DataTwoViewHolder extends BaseListViewHolderImpl<Data_Two>{

    private TextView mTextView;

    public DataTwoViewHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
    }

    @Override
    public void initView() {
        mTextView = get(R.id.item_text_show);
        Log.i("DataTwoViewHolder", String.valueOf(mTextView));
    }

    @Override
    public void setData(Data_Two data) {
        mTextView.setText(data.getDataTwo());
    }
}
