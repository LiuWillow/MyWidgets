package com.example.administrator.widgets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.widgets.chat.MsgActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layou_true);

        ((Button)findViewById(R.id.start_liaotian)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMsgActivity();
            }
        });


    }

    private void goMsgActivity(){
        Intent intent = new Intent(MainActivity.this,MsgActivity.class);
        startActivity(intent);
    }


}
