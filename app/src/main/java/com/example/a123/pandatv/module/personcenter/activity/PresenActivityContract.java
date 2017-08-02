package com.example.a123.pandatv.module.personcenter.activity;

import com.example.a123.pandatv.base.BasePresenter;
import com.example.a123.pandatv.base.BaseView;
import com.example.a123.pandatv.model.entity.LoginEntity;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface PresenActivityContract {
    interface View extends BaseView<Presenter> {
        void setLogin(LoginEntity login);
        void setManager(String error);

    }
    interface Presenter extends BasePresenter{
        void setLogin(String username,String pwd);
    }
}
