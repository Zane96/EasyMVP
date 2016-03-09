package com.example.zane.demo.view;

import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zane.demo.R;
import com.example.zane.demo.model.data;
import com.example.zane.easymvp.view.BaseListViewHolderImpl;

import butterknife.Bind;


/**
 * Created by Zane on 15/12/20.
 */
public class MainListViewHolder extends BaseListViewHolderImpl<data> {

    private TextView mTextView;

    public MainListViewHolder(ViewGroup parent) {
        super(parent, R.layout.listview_item_layout);
    }

    @Override
    public void initView() {
        mTextView = $(R.id.item_text);
    }

    @Override
    public void setData(data data) {
        mTextView.setText(data.getDatas()[0]);
    }
}
