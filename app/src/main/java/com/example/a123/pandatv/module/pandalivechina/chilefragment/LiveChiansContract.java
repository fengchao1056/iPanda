package com.example.a123.pandatv.module.pandalivechina.chilefragment;

import com.example.a123.pandatv.base.BasePresenter;
import com.example.a123.pandatv.base.BaseView;
import com.example.a123.pandatv.model.entity.LiveChinasBean;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface LiveChiansContract {
    interface View extends BaseView<Presenter> {
        void setLiveChinaFragment(LiveChinasBean liveChinaFragmentBean);
    }
    interface Presenter extends BasePresenter {
        void setResult(String url);
    }
}
