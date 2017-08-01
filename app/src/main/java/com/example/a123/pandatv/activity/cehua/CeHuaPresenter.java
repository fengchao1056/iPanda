package com.example.a123.pandatv.activity.cehua;

import com.example.a123.pandatv.model.biz.chinalive.CeHuaModel;
import com.example.a123.pandatv.model.biz.chinalive.CeHuaModelImpl;
import com.example.a123.pandatv.model.entity.CehuaBean;
import com.example.a123.pandatv.net.callback.MyCallback;

/**
 * Created by Administrator on 2017/7/29.
 */

public class CeHuaPresenter implements CeHuaContract.Presenter {
    private CeHuaContract.View view;
    private CeHuaModel ceHuaModel;
    public CeHuaPresenter(CeHuaContract.View view){
        this.view=view;
        this.view.setPresenter(this);
        ceHuaModel=new CeHuaModelImpl();
    }
    @Override
    public void start() {
        ceHuaModel.webUrl(new MyCallback<CehuaBean>() {
            @Override
            public void onSuccess(CehuaBean cehuaBean) {
                view.getWebUrl(cehuaBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}
