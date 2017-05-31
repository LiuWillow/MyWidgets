package com.example.administrator.widgets;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.widgets.chat.MsgActivity;
import com.example.administrator.widgets.chenjintb.ChengjinActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layou_true);

        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void goMsgActivity(View view){
        Intent intent = new Intent(MainActivity.this,MsgActivity.class);
        startActivity(intent);
    }

    public void goChenjinActivity(View view){
        Intent intent = new Intent(MainActivity.this, ChengjinActivity.class);
        startActivity(intent);
    }


}
