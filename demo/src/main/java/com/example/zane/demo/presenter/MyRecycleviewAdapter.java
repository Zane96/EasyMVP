package com.example.zane.demo.presenter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import com.example.zane.demo.Bean.Data_One;
import com.example.zane.demo.Bean.Data_Two;
import com.example.zane.demo.Bean.RecycleviewData;
import com.example.zane.demo.R;
import com.example.zane.demo.view.DataOneViewHolder;
import com.example.zane.demo.view.DataTwoViewHolder;
import com.example.zane.easymvp.presenter.BaseListAdapterPresenter;
import com.example.zane.easymvp.view.BaseListViewHolderImpl;

import java.util.IllegalFormatException;
import java.util.List;

/**
 * Created by Zane on 15/12/20.
 */
public class MyRecycleviewAdapter extends BaseListAdapterPresenter<RecycleviewData>{

    public MyRecycleviewAdapter(Context mContext, List<RecycleviewData> datas){
        super(mContext, datas);
    }

    @Override
    public int getItemViewType(int position) {

        if (mDatas.get(position).getData_one() != null){
            return RecycleviewData.DATA_ONE;
        }else {
            return RecycleviewData.DATA_TWO;
        }

    }

    @Override
    public BaseListViewHolderImpl OnCreatViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){

            case RecycleviewData.DATA_ONE:
                return new DataOneViewHolder(parent, R.layout.listview_item_layout);

            case RecycleviewData.DATA_TWO:
                return new DataTwoViewHolder(parent, R.layout.listview_item_layout);

            default:
                throw new IllegalArgumentException("没有匹配的ViewHolder!");

        }

    }

    @Override
    public void onBindViewHolder(BaseListViewHolderImpl holder, int position) {
        holder.setData(mDatas.get(position));
    }

    //没有头
    @Override
    public int setHeadNum() {
        return 0;
    }

    //没有尾
    @Override
    public int setFootNum() {
        return 0;
    }
}
