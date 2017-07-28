package com.example.a123.pandatv.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a123.pandatv.app.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    protected Unbinder unbinder;
    protected  Bundle bundle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        unbinder= ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setListener();
        loadDate();
      /*  ShowDialogUtils showutils = ShowDialogUtils.getInsenter().updateConnectedFlags(getContext());
        Boolean netConnected = showutils.isNetConnected();
        if(!netConnected) {
            ToastManager.show("似乎没有网络了");
        }*/


    }

    protected abstract int getLayoutId();
    protected abstract void initView(View view);
    protected abstract void loadDate();
    protected abstract void setListener();
    public void onShow(){}
    public void onHidden(){}
    public void setBundle(Bundle bundle){
        this.bundle = bundle;
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            onHidden();
        }else {
            onShow();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (this != null) {
            FragmentManager f= App.context.getSupportFragmentManager();
            if (f != null) {
                final FragmentTransaction ft = f.beginTransaction();
                if (ft != null) {
                    ft.remove(this).commitAllowingStateLoss();
                }
            }
        }
    }
}
