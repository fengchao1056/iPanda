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

/**
 * Created by Administrator on 2017/8/1.
 */

public class PhoneRegisterFragment extends BaseFragment implements PhoneRegisterContract.View ,View.OnClickListener{
    @BindView(R.id.register_shouji_zhanghao)
    EditText registerShoujiZhanghao;
    @BindView(R.id.register_shouji_photoyanzheng)
    EditText registerShoujiPhotoyanzheng;
    @BindView(R.id.register_shouji_recivie)
    EditText registerShoujiRecivie;
    @BindView(R.id.register_shouji_receivebut)
    Button registerShoujiReceivebut;
    @BindView(R.id.register_shouji_writepass)
    EditText registerShoujiWritepass;
    @BindView(R.id.register_shouji_radiobutton)
    RadioButton registerShoujiRadiobutton;
    @BindView(R.id.register_shouji_button)
    Button registerShoujiButton;
    @BindView(R.id.image_code)
    ImageView imageCode;

    private PhoneRegisterPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.register_shoujiregister;
    }

    @Override
    protected void initView(View view) {
        new PhoneRegisterPresenter(this);
        presenter.start();
    }

    @Override
    protected void loadDate() {

    }

    @Override
    protected void setListener() {
        registerShoujiButton.setOnClickListener(this);
        registerShoujiReceivebut.setOnClickListener(this);
        imageCode.setOnClickListener(this);
    }

    @Override
    public void setImg(Drawable drawable) {
        imageCode.setImageDrawable(drawable);
    }

    @Override
    public void phoneNum(String isSucces) {
        Toast.makeText(getContext(),isSucces,Toast.LENGTH_SHORT).show();
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
    public void setPresenter(PhoneRegisterContract.Presenter presenter) {
        this.presenter= (PhoneRegisterPresenter) presenter;
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

            case R.id.register_shouji_button:

                break;
            case R.id.register_shouji_receivebut:
                String phone = registerShoujiZhanghao.getText().toString().trim();
                String phoneImg = registerShoujiPhotoyanzheng.getText().toString().trim();
                if (phone!=null && phoneImg!=null){
                    presenter.sendYZM(phone,phoneImg);
                }else {
                    Toast.makeText(getContext(),"输入内容不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.image_code:
                presenter.start();
                break;
        }
    }
}
