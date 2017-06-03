package com.example.administrator.widgets.chat;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.widgets.R;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

        inputText = (EditText)findViewById(R.id.input_text);
        send = (Button)findViewById(R.id.send_btn);
        recyclerView = (RecyclerView)findViewById(R.id.msg_recycle);
        adapter = new MsgAdapter(msgList);
        inputText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final MaterialDialog materialDialog = new MaterialDialog(MsgActivity.this)
                        .setMessage("是否保存消息")
                        .setCanceledOnTouchOutside(true);

                 materialDialog.setPositiveButton("是", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MsgActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                        materialDialog.dismiss();
                    }
                })
                        .setNegativeButton("否", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                materialDialog.dismiss();
                            }
                        }).show();

                return true;
            }
        });

            String load = load();
            inputText.setText(load);
            inputText.setSelection(load.length());     //光标移动到末尾


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputText.getText().toString();
                if(!TextUtils.isEmpty(input)){
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String input = inputText.getText().toString();
        save(input);
        Log.d("MsgActivity","onDestroy");
    }

    private void save(String inputString){
        FileOutputStream output = null;
        BufferedWriter writer = null;
        try{
            //openfileout返回一个fileoutputstream对象  在默认路径/data/data/<包名>/files/目录下创建"data"文件
            output = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(output));
            writer.write(inputString);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer!=null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private String load() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content.toString();
    }
}
