package com.example.zane.easymvp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.example.zane.easymvp.base.IListModel;
import com.example.zane.easymvp.view.BaseListViewHolderImpl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Zane on 15/12/18.
 * 16.4.10修改：所有的数据管理都放在BaseAdapter里面。
 * 由于这个适配器并不提供添加header和foot的功能，所以getItemCount()最好还是要开发者自己实现
 */
public abstract class BaseListAdapterPresenter<M extends IListModel> extends RecyclerView.Adapter<BaseListViewHolderImpl>{

    protected Context mContext;
    //item数据的model集合
    protected List<M> mDatas;
    //开发者添加的头数量
    private int headNum = 0;
    //开发者添加的尾的数量
    private int footNum = 0;

    /**
     * 不传入数据
     * @param mContext
     */
    public BaseListAdapterPresenter(@NonNull Context mContext){
        this(mContext, new ArrayList<M>());
    }

    /**
     * 传入数组类型的数据
     * @param mContext
     * @param mDatas
     */
    public BaseListAdapterPresenter(@NonNull Context mContext, @NonNull M[] mDatas){
        this(mContext, Arrays.asList(mDatas));
    }

    /**
     * 传入List类型的数据
     * @param mContext
     * @param mDatas
     */
    public BaseListAdapterPresenter(@NonNull Context mContext, @NonNull List<M> mDatas){
        this.mContext = mContext;
        this.mDatas = mDatas;
    }


    /**
     * 将viewType返回,具体的实现由开发者去做。
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public BaseListViewHolderImpl onCreateViewHolder(ViewGroup parent, int viewType) {
        return OnCreatViewHolder(parent, viewType);
    }

    public abstract BaseListViewHolderImpl OnCreatViewHolder(ViewGroup parent, int viewType);


    /**
     * 将datas中的某个数据返回给viewholder
     * 前提是在个position不是head不是foot,但是这个判断应该是开发者去实现。
     * 所以这里默认开发者调用的时候已经不是head和foot，所以直接根据开发提供的position减去headNum给数据
     * @param position
     * @return
     */
    public M getItem(int position){
        return mDatas.get(position - headNum);
    }

    @Override
    public int getItemCount() {
        return mDatas.size() + headNum + footNum;
    }

    /**
     * 根据开发者提供的数据去更改头的数量
     */
    private void setBaseHeadNum(){
        headNum = setHeadNum();
    }

    /**
     * 根据开发者提供的数据去更改尾的数量
     */
    private void setBaseFootNum(){
        footNum = setFootNum();
    }

    //开发者去实现，告诉BaseAdapter添加了几个head或者foot
    public abstract int setHeadNum();
    public abstract int setFootNum();


}
