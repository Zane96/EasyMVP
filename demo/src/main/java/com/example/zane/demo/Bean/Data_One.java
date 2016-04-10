package com.example.zane.demo.Bean;

import com.example.zane.easymvp.base.IListModel;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Zane on 16/4/10.
 */
public class Data_One extends RecycleviewData{

    private String dataOne;

    public Data_One(String dataOne){
        this.dataOne = dataOne;
    }

    public void setDataOne(String dataOne) {
        this.dataOne = dataOne;
    }

    public String getDataOne(){
        return dataOne;
    }

}
