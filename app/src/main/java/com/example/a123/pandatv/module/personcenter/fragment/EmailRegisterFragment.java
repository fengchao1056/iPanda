package com.example.a123.pandatv.module.personcenter.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/1.
 */

public class EmailRegisterFragment extends BaseFragment implements EmailRegisterContract.View,View.OnClickListener {
    @BindView(R.id.register_youxiang_zhanghao)
    EditText registerYouxiangZhanghao;
    @BindView(R.id.register_youxiang_pass)
    EditText registerYouxiangPass;
    @BindView(R.id.register_youxiang_querenpass)
    EditText registerYouxiangQuerenpass;
    @BindView(R.id.register_youxiang_yanzhengma)
    EditText registerYouxiangYanzhengma;
    @BindView(R.id.register_youxiang_receivebut)
    ImageView registerYouxiangReceivebut;
    @BindView(R.id.register_shouji_radiobutton)
    RadioButton registerShoujiRadiobutton;
    @BindView(R.id.register_youxiang_button)
    Button registerYouxiangButton;

    private EmailRegisterContract.Presenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.register_youxiangregister;
    }

    @Override
    protected void initView(View view) {
        new EmailRegisterPresenter(this);

    }

    @Override
    protected void loadDate() {
        presenter.start();
    }

    @Override
    protected void setListener() {
        registerYouxiangButton.setOnClickListener(this);
        registerYouxiangReceivebut.setOnClickListener(this);
    }

    @Override
    public void getImg(Drawable Img) {
        registerYouxiangReceivebut.setImageDrawable(Img);

    }

    @Override
    public void getResult(String succes) {

    }

    @Override
    public void getManager(String error) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(EmailRegisterContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_youxiang_button:
                String email = registerYouxiangZhanghao.getText().toString().trim();
                String pwd = registerYouxiangPass.getText().toString().trim();
                String imgNum = registerYouxiangYanzhengma.getText().toString().trim();
                if (email!=null&&pwd!=null&&imgNum!=null){
                    presenter.registerManager(email,pwd,imgNum);
                }else {
                    Toast.makeText(getContext(),"输入内容不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.register_youxiang_receivebut:
                presenter.start();
                break;
        }
    }
}
