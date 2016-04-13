package com.example.zane.demo.Bean;

import android.util.Log;

import com.example.zane.easymvp.base.IListModel;

/**
 * Created by Zane on 16/4/10.
 */
public class RecycleviewData implements IListModel{

    private Data_One data_one;
    private Data_Two data_two;

    public static final int DATA_ONE = 1122;
    public static final int DATA_TWO = 2211;

    public RecycleviewData(){
    }

    public Data_One getData_one() {
        return data_one;
    }

    public void setData_one(Data_One data_one) {
        this.data_one = data_one;
    }

    public Data_Two getData_two() {
        return data_two;
    }

    public void setData_two(Data_Two data_two) {
        this.data_two = data_two;
    }


    /**
     * 管理多个数据model的父类来根据model存在与否而返回不同的viewtype
     * @return
     */
    @Override
    public int getModelViewType() {
        Log.i("RecycleviewData", String.valueOf(data_one));
        if (data_one != null){
            return DATA_ONE;
        }else {
            return DATA_TWO;
        }
    }

}
