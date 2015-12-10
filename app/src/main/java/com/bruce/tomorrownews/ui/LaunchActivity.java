package com.bruce.tomorrownews.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.bruce.tomorrownews.R;


public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//让title隐藏
        setContentView(R.layout.activity_launch_layout);//加载启动布局，里面是一个图片当作启动页面
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(LaunchActivity.this,
                        NewsMainctivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
