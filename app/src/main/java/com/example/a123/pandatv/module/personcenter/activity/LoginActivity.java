package com.example.a123.pandatv.module.personcenter.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseActivity;
import com.example.a123.pandatv.model.entity.LoginEntity;
import com.example.a123.pandatv.utils.ACache;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.shareboard.SnsPlatform;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/31.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener, PresenActivityContract.View {
    @BindView(R.id.login_radiobutton_wenxin)
    RadioButton loginRadiobuttonWenxin;
    @BindView(R.id.login_radiobutton_qq)
    RadioButton loginRadiobuttonQq;
    @BindView(R.id.login_radiobutton_sina)
    RadioButton loginRadiobuttonSina;
    @BindView(R.id.login_radiogroup)
    RadioGroup loginRadiogroup;
    @BindView(R.id.login_edit_number)
    EditText loginEditNumber;
    @BindView(R.id.login_edit_password)
    EditText loginEditPassword;
    @BindView(R.id.livechina_wangjimimaa)
    TextView livechinaWangjimimaa;
    @BindView(R.id.login_button)
    Button loginButton;
    @BindView(R.id.login_backImg)
    ImageView loginBackImg;
    @BindView(R.id.register_btn)
    TextView registerBtn;

    public ArrayList<SnsPlatform> platforms = new ArrayList<SnsPlatform>();
    private PresenActivityContract.Presenter presenter;
    private ACache aCache;

    @Override
    protected int getLayoutId() {
        return R.layout.login_main;
    }

    @Override
    protected void initView() {
        aCache = ACache.get(this);
        new PresenterActivityPresenter(this);
    }

    @Override
    protected void setListener() {
        loginBackImg.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        loginRadiobuttonSina.setOnClickListener(this);
        loginEditNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });
    }

    @Override
    protected void setIntent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_backImg:
                finish();
                break;
            case R.id.login_button:
                String username = loginEditNumber.getText().toString();
                String pwd = loginEditPassword.getText().toString();
                if ("".equals(username) && "".equals(pwd)) {
                    presenter.setLogin(username, pwd);
                } else {
                    Toast.makeText(this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.register_btn:
                Intent intent=new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login_radiobutton_sina:
                UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.SINA, authListener);
                break;
        }
    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
//            ShowPopuUtils.getInsent().create(LoginActivity.this);
        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
//            dialog.popuUtilsDismiss();
//            Toast.makeText(LoginActivity.this, "成功了", Toast.LENGTH_LONG).show();
            Set<String> keyset = data.keySet();
            String str=null;
            for (String string:keyset){
                str=data.get(string);
            }
            String name=data.get("name");
            Intent intent=getIntent();
            intent.putExtra("na",name);
            aCache.put("wbname",name);
            setResult(200,intent);
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
//            dialog.popuUtilsDismiss();
            Toast.makeText(LoginActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
//            dialog.popuUtilsDismiss();
            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };
    @Override
    public void setLogin(LoginEntity login) {

        ACache aCache= ACache.get(LoginActivity.this);
        aCache.put("loginEntity",login);
        SharedPreferences loginUserManager = getSharedPreferences("loginUserManager", MODE_PRIVATE);
        SharedPreferences.Editor edit = loginUserManager.edit();
        edit.putString("isLogin","loginEntity");
        edit.commit();
        String errMsg = login.getErrMsg();
        if(errMsg.equals("成功")) {
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setManager(String error) {

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
    public void setPresenter(PresenActivityContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
