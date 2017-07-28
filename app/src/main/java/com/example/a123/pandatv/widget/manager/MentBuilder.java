package com.example.a123.pandatv.widget.manager;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.base.BaseFragment;

public class MentBuilder {
    private static MentBuilder builder;
    private static BaseFragment lasrfragment;

    /**
     * 切换Fragment的方法
     *
     * @param fragmentClass 要跳转的Fragment
     * @param containId     容器ID
     * @param isHidden      是否隐藏
     * @param bundle        参数
     * @param isBack        是否添加到回退栈
     * @return
     */
    public static BaseFragment changeFragment(Class<? extends BaseFragment> fragmentClass, int containId, boolean isHidden, Bundle bundle, boolean isBack) {
        FragmentManager manager = App.context.getSupportFragmentManager();
        //开启事物
        FragmentTransaction transaction = manager.beginTransaction();
        String simpleName = fragmentClass.getSimpleName();
        //通过名字 找到当前fragment
        BaseFragment currentFragment = (BaseFragment) manager.findFragmentByTag(simpleName);
        if (currentFragment == null) {
            try {
                //如果没有，就创建一个fragment
                currentFragment = fragmentClass.newInstance();
                //添加到事物
                transaction.add(containId, currentFragment, simpleName);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (isHidden) {
            //隐藏上一个fragment
            if (lasrfragment != null) {
                transaction.hide(lasrfragment);
                transaction.show(currentFragment);
            }
        } else {
            //如果不隐藏的话，就替换他
            transaction.replace(containId, currentFragment, simpleName);
        }
        if (bundle != null) {
            currentFragment.setBundle(bundle);
        }
        if (isBack) {
            transaction.addToBackStack(simpleName);
        }
        transaction.commit();
        lasrfragment = currentFragment;
        return lasrfragment;
    }
}
