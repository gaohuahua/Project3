package com.example.project3.base;

import java.util.ArrayList;

/**
 * Created by 高华华 on 2019/5/22.
 */

public abstract class BaseP <V extends BaseV>{
    protected V mView;
    protected ArrayList<BaseM> mModels=new ArrayList<>();

    public BaseP(){
        initModel();
    }

    protected abstract void initModel();

    public void bind(V view){
        this.mView=view;
    }

    public void onDestroy() {
        mView=null;
        if (mModels.size()>0){
            for (BaseM model:mModels) {
                model.onDestory();
            }
        }
    }
}
