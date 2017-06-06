package com.example.administrator.widgets.zhima;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.widgets.R;

/**
 * Created by Administrator on 2017/6/6.
 */

public class ZhimaActivity extends AppCompatActivity {
    EditText editText;
    ZhimaView zhimaView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhima_layout);
        editText = (EditText) findViewById(R.id.jifen);
        zhimaView = (ZhimaView) findViewById(R.id.zhimaview);
    }

    public void update(View view){
        int num = Integer.valueOf(editText.getText().toString());
        zhimaView.setCurrentNumAnim(num);
    }
}
