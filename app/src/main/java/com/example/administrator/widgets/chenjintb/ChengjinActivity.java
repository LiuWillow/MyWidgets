package com.example.administrator.widgets.chenjintb;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.widgets.R;

/**
 * Created by Administrator on 2017/5/31.
 */

public class ChengjinActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chenjin_layout);

       if(Build.VERSION.SDK_INT >= 21){
           View decorView = getWindow().getDecorView();
           int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|      //全屏
                   View.SYSTEM_UI_FLAG_LAYOUT_STABLE|
                   View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;       //隐藏下方导航
           decorView.setSystemUiVisibility(option);
           getWindow().setNavigationBarColor(Color.TRANSPARENT);    //设置下方导航透明
           getWindow().setStatusBarColor(Color.TRANSPARENT);       //设置状态栏透明
       }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    //真正的沉浸式
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
