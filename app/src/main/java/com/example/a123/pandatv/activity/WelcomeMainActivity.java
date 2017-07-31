package com.example.a123.pandatv.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.a123.pandatv.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeMainActivity extends AppCompatActivity {

    @BindView(R.id.welcome_image)
    ImageView welcomeImage;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    private boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_main);
        ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences("start", MODE_PRIVATE);
        edit = sharedPreferences.edit();
        isFirst = sharedPreferences.getBoolean("isFirst", true);
        init();
    }
    public void init() {
        if (isFirst) {

            edit.putBoolean("isFirst", false);
            edit.commit();

            handler.sendEmptyMessageDelayed(100, 2000);

        } else {
            handler.sendEmptyMessageDelayed(200, 2000);
        }


    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100:
                    Intent intent1 = new Intent(WelcomeMainActivity.this,StartMainActivity.class);
                    startActivity(intent1);
                    break;
                case 200:
                    Intent intent = new Intent(WelcomeMainActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
            }
            finish();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(200);
        handler.removeMessages(100);
    }
}
