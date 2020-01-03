package com.bawei.wangjiangwei20200102.contract;

import com.bawei.wangjiangwei20200102.base.mvp.IBaseModel;
import com.bawei.wangjiangwei20200102.base.mvp.IBaseView;
import com.bawei.wangjiangwei20200102.model.entity.HomeEntity;

public interface IHomeContract {
    interface IModel extends IBaseModel {
        void getData(String url,ModelCallback modelCallback);

        interface ModelCallback{
            void success(HomeEntity homeEntity);
            void error(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void success(HomeEntity homeEntity);
        void error(Throwable throwable);
    }
    interface IPresenter{
        void getData(String url);
    }
}
