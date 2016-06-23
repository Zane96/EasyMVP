package com.example.zane.easymvp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.zane.easymvp.base.IListModel;
import com.example.zane.easymvp.view.BaseListViewHolderImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
    //item的点击监听接口
    private OnRecycleViewItemClickListener onRecycleViewItemClickListener;

    //用来提供同步代码块的锁
    private final Object mLock = new Object();

//-------------------------------构造器-----------------------------------

    public interface OnRecycleViewItemClickListener{
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }

    public void setOnRecycleViewItemClickListener(OnRecycleViewItemClickListener listener){
        onRecycleViewItemClickListener = listener;
    }

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


//---------------------------对继承函数的重写--------------------------------

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
     * 默认框架实现点击事件接口的回调
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(BaseListViewHolderImpl holder, final int position) {
        OnBindViewHloder(holder, position);

        //设置监听接口
        if (onRecycleViewItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRecycleViewItemClickListener.onClick(v, position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onRecycleViewItemClickListener.onLongClick(v, position);
                    return true;
                }
            });
        }
    }

    public abstract void OnBindViewHloder(BaseListViewHolderImpl holder, int position);

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

// ----------------------------对数据源的操作--------------------------------

    /**
     * 将数据添加到集合最末尾
     * @param data
     */
    public void add(M data){
        add(data, mDatas.size());
    }

    /**
     * 将数据添加到指定位置
     * @param data
     * @param position
     */
    public void add(M data, int position){
        if (data != null){
            synchronized (mLock){
                mDatas.add(position, data);
            }
        }
    }

    /**
     * 将一个集合添加到数据最尾端
     * @param collection
     */
    public void addAll(Collection<? extends M> collection){
        addAll(collection, mDatas.size());
    }

    public void addAll(Collection<? extends M> collection, int position){
        if (collection != null && collection.size() != 0 && position >= 0){
            synchronized (mLock){
                mDatas.addAll(position, collection);
            }
        }
    }

    /**
     * 删除集合最尾部数据
     */
    public void remove(){
        synchronized (mLock){
           remove(mDatas.size() - 1);
        }
    }

    /**
     * 删除指定位置的数据
     * @param position
     */
    public void remove(int position){
        if (position >= 0 && position <= (mDatas.size() - 1)){
            synchronized (mLock){
                mDatas.remove(position);
            }
        }
    }

    /**
     * 删除一个特定数据的元素
     * @param data
     */
    public void remove(M data){
        if (data != null){
            synchronized (mLock){
                mDatas.remove(data);
            }
        }
    }

    /**
     * 清空数据
     */
    public void clear(){
        synchronized (mLock){
            mDatas.clear();
        }
    }

}
