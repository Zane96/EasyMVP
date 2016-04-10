package com.example.zane.demo.Bean;

import com.example.zane.easymvp.base.IListModel;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Zane on 16/4/10.
 */
public class Data_Two extends RecycleviewData{

    private String dataTwo;

    public Data_Two(String dataTwo){
        this.dataTwo = dataTwo;
    }

    public String getDataTwo() {
        return dataTwo;
    }

    public void setDataTwo(String dataTwo) {
        this.dataTwo = dataTwo;
    }
}
