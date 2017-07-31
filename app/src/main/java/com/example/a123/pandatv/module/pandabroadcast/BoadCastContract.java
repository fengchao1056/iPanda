package com.example.a123.pandatv.module.pandabroadcast;

import com.example.a123.pandatv.base.BasePresenter;
import com.example.a123.pandatv.base.BaseView;
import com.example.a123.pandatv.model.entity.PandaBoadCastBean;

/**
 * Created by xingge on 2017/7/26.
 */

public interface BoadCastContract {

    interface View extends BaseView<Presenter> {
        void showResult(PandaBoadCastBean pandaHome);
        void playVideo();

    }

    interface Presenter extends BasePresenter{
    }

}
