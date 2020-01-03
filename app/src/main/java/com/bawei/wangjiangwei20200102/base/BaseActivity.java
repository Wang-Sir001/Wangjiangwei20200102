package com.bawei.wangjiangwei20200102.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.wangjiangwei20200102.base.mvp.BasePresenter;
import com.bawei.wangjiangwei20200102.base.mvp.IBaseView;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attch(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int layoutId();
}
