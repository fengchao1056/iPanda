package com.example.a123.pandatv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.module.pandahome.adapter.StartViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class StartMainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<ImageView> imageViewList=new ArrayList<>();
    private ImageView imageView;
    private StartViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_main);
        init();
        setListener();
    }
    public void init(){
        viewPager= (ViewPager) findViewById(R.id.start_viewpager);
        add_image();
        adapter=new StartViewPagerAdapter(imageViewList);
        viewPager.setAdapter(adapter);
    }
    public void add_image(){
        imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.one);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageViewList.add(imageView);

        imageView =new ImageView(this);
        imageView.setImageResource(R.drawable.guide_two);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageViewList.add(imageView);

        imageView =new ImageView(this);
        imageView.setImageResource(R.drawable.three);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageViewList.add(imageView);
    }


    public void setListener(){
        imageViewList.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartMainActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
