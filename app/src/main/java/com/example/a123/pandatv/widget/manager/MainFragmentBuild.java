package com.example.a123.pandatv.widget.manager;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.base.BaseFragment;

/**
 * Created by Administrator on 2017/7/12.
 */
public class MainFragmentBuild {
    private static MainFragmentBuild fragmentBuild;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private BaseFragment fragment,lastFragment;
    private MainFragmentBuild(){
        manager = App.context.getSupportFragmentManager();
    }
    public static MainFragmentBuild getInsenter(){

        if (fragmentBuild==null){
            synchronized (MainFragmentBuild.class){
                if (fragmentBuild==null){
                    fragmentBuild=new MainFragmentBuild();
                }
            }
        }

        return fragmentBuild;
    }

    public MainFragmentBuild setFragmentView(int viewID,Class<? extends BaseFragment> fragmentClass){

        transaction = manager.beginTransaction();
        String simpleName = fragmentClass.getSimpleName();
        fragment= (BaseFragment) manager.findFragmentByTag(simpleName);
        if (fragment==null){
            try {
                fragment=fragmentClass.newInstance();
                transaction.add(viewID,fragment,simpleName);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (lastFragment!=null)
            transaction.hide(lastFragment);
        transaction.show(fragment);
        lastFragment=fragment;
        transaction.addToBackStack(simpleName);

        return this;

    }
    public BaseFragment getFragmentContext(){
        if (fragment!=null){

            return fragment;
        }
        return null;
    }
    public MainFragmentBuild builder(){
        transaction.commitAllowingStateLoss();
        return this;
    }

}
