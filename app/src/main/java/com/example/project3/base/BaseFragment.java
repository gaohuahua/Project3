package com.example.project3.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 高华华 on 2019/5/22.
 */

public abstract class BaseFragment <V extends BaseV,P extends BaseP> extends Fragment implements BaseV{
    private Unbinder unbinder;
    private P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        unbinder = ButterKnife.bind(this, inflate);
        mPresenter=initPresenter();
        if (mPresenter!=null){
            mPresenter.bind((V)this);
        }
        initView();
        initListener();
        initData();
        return inflate;
    }

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int getLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.onDestroy();
        mPresenter=null;
    }
}
