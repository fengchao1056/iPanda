package com.example.a123.pandatv.module.personcenter.activity;

import com.example.a123.pandatv.model.biz.personcenter.IPersonCenter;
import com.example.a123.pandatv.model.biz.personcenter.PersonCenterImp;
import com.example.a123.pandatv.model.entity.LoginEntity;
import com.example.a123.pandatv.net.callback.MyCallback;

/**
 * Created by Administrator on 2017/7/31.
 */

public class PresenterActivityPresenter implements PresenActivityContract.Presenter {
    private PresenActivityContract.View view;
    private IPersonCenter personCenter;
    public PresenterActivityPresenter(PresenActivityContract.View view){
        this.view=view;
        this.view.setPresenter(this);
        personCenter=new PersonCenterImp();
    }
    @Override
    public void setLogin(String username, String pwd) {
        personCenter.userLogin(username, pwd, new MyCallback<LoginEntity>() {
            @Override
            public void onSuccess(LoginEntity loginEntity) {
                view.setLogin(loginEntity);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void start() {

    }
}
