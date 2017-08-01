package com.example.a123.pandatv.activity.cehua;

import com.example.a123.pandatv.base.BasePresenter;
import com.example.a123.pandatv.base.BaseView;
import com.example.a123.pandatv.model.entity.CehuaBean;

/**
 * Created by Administrator on 2017/7/29.
 */

public interface CeHuaContract {
    interface View extends BaseView<Presenter>{
        void getWebUrl(CehuaBean cehuaBean);
    }
    interface Presenter extends BasePresenter{

    }
}
