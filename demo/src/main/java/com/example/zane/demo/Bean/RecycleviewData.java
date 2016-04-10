package com.example.zane.demo.Bean;

import com.example.zane.easymvp.base.IListModel;

/**
 * Created by Zane on 16/4/10.
 */
public class RecycleviewData implements IListModel{

    private Data_One data_one;
    private Data_Two data_two;

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
}
