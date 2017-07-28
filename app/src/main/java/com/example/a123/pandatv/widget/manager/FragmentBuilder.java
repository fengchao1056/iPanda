package com.example.a123.pandatv.widget.manager;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.base.BaseFragment;

public class FragmentBuilder {
    public static FragmentBuilder builder;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private BaseFragment lastFragment, fragment;
    private FragmentManager supportFragmentManager;

    private FragmentBuilder() {
        manager = App.context.getSupportFragmentManager();

    }

    public static FragmentBuilder getInstance() {
        synchronized (FragmentBuilder.class) {
            if (builder == null) {
                builder = new FragmentBuilder();
            }

        }
        return builder;
    }

    public BaseFragment changeFragment(Class<? extends BaseFragment> fragmentClass,
                                       int containId, boolean isHidden, Bundle bundle, boolean isBack) {


        FragmentTransaction transaction = manager.beginTransaction();
        //获取Fragment的类名，用类名当做Tag
        String fragmentName = fragmentClass.getSimpleName();
        //根据tag来查找当前Fragment，如果不为null 就代表当前Fragment已经被加载过至少一次
        BaseFragment currentFragment = (BaseFragment) manager.findFragmentByTag(fragmentName);
        if (currentFragment == null) {
            //如果Fragment为null 就创建Fragment对象，添加到FragmentManager中
            try {
                //通过Java动态代理创建的对象
                currentFragment = fragmentClass.newInstance();
                //添加到FragmentManager中
                transaction.add(containId, currentFragment, fragmentName);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (isHidden) {
            //隐藏上一个Fragment
            if (lastFragment != null)
                transaction.hide(lastFragment);
            //显示当前Fragment
            transaction.show(currentFragment);
        } else {
            //替换上一个Fragment
            transaction.replace(containId, currentFragment, fragmentName);
        }
        //传递参数
        if (bundle != null) {
            currentFragment.setBundle(bundle);
        }

        if (isBack) {
            transaction.addToBackStack(fragmentName);
        }

        transaction.commitNowAllowingStateLoss();

        lastFragment = currentFragment;

        return lastFragment;

    }



}
