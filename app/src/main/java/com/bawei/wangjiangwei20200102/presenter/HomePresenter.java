package com.bawei.wangjiangwei20200102.presenter;

import com.bawei.wangjiangwei20200102.base.mvp.BasePresenter;
import com.bawei.wangjiangwei20200102.contract.IHomeContract;
import com.bawei.wangjiangwei20200102.model.HomeModel;
import com.bawei.wangjiangwei20200102.model.entity.HomeEntity;

public class HomePresenter extends BasePresenter<HomeModel, IHomeContract.IView> implements IHomeContract.IView {

    @Override
    protected HomeModel initModel() {
        return new HomeModel();
    }

    @Override
    public void success(HomeEntity homeEntity) {

    }

    @Override
    public void error(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
