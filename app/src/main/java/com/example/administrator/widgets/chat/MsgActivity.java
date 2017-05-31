package com.example.administrator.widgets.chat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.widgets.R;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by Administrator on 2017/5/30.
 */

public class MsgActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView recyclerView;
    private MsgAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liaotian_layout);
        initMsgs();
         final MaterialDialog materialDialog = new MaterialDialog(MsgActivity.this)
                .setMessage("是否保存消息")
                 .setPositiveButton("是", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MsgActivity.this,"保存成功",Toast.LENGTH_SHORT);
                    }
                })
                .setNegativeButton("否", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                 .setCanceledOnTouchOutside(true);

        inputText = (EditText)findViewById(R.id.input_text);
        send = (Button)findViewById(R.id.send_btn);
        recyclerView = (RecyclerView)findViewById(R.id.msg_recycle);
        adapter = new MsgAdapter(msgList);
        inputText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                materialDialog.show();
                return true;
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputText.getText().toString().length() > 0){
                    Msg msgInput=new Msg(inputText.getText().toString(),Msg.TYPE_SENT);
                    adapter.addItem(msgInput);
                    inputText.setText("");
                }else{
                    Toast.makeText(MsgActivity.this,"不能发送空消息!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initMsgs(){
        Msg msg1 = new Msg("哈咯帅哥",Msg.TYPE_RECEIVED);
        Msg msg2 = new Msg("干哈啊美女", Msg.TYPE_SENT);
        Msg msg3 = new Msg("晚上有空吗？",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);
    }
}
