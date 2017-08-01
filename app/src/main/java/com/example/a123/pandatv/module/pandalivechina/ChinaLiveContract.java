package com.example.a123.pandatv.module.pandalivechina;

import com.example.a123.pandatv.base.BasePresenter;
import com.example.a123.pandatv.base.BaseView;
import com.example.a123.pandatv.model.entity.LiveChinaTitleBean;
import com.example.a123.pandatv.model.entity.PandaHomeBean;

import java.util.List;

/**
 * Created by xingge on 2017/7/26.
 */

public interface ChinaLiveContract {
    interface View extends BaseView<Presenter> {
        void showResult(LiveChinaTitleBean liveChinaBean);
        void initDatatitle(List<LiveChinaTitleBean.TablistBean> tablist);
        void initDataOther(List<LiveChinaTitleBean.AlllistBean> alllist);
        void showPopup();
        void setRefresh();
        void showErrorMassage(String msg);
    }

    interface Presenter extends BasePresenter {
        void showPopup();
    }

}
