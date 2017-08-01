package com.example.a123.pandatv.module.pandalivechina;

import com.example.a123.pandatv.base.BasePresenter;
import com.example.a123.pandatv.base.BaseView;
import com.example.a123.pandatv.model.entity.PandaHomeBean;

/**
 * Created by xingge on 2017/7/26.
 */

public interface ChinaLiveContract {

    interface View extends BaseView<Presenter> {
        void showResult(PandaHomeBean pandaHome);
        void playVideo();
        void showErrorMassage(String msg);
    }

    interface Presenter extends BasePresenter{
    }

}
