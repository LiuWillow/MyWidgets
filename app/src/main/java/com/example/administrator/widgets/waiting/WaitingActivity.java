package com.example.administrator.widgets.waiting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.widgets.R;

/**
 * Created by Administrator on 2017/6/8.
 */

public class WaitingActivity extends AppCompatActivity {
    RollSquareView waiting;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiting_layout);
        waiting = (RollSquareView)findViewById(R.id.waiting);
    }
}
