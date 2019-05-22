package com.example.project3.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by 高华华 on 2019/5/22.
 */

public class BaseM {
    protected CompositeDisposable compositeDisposable=new CompositeDisposable();

    public void onDestory(){
        compositeDisposable.clear();
    }
}
