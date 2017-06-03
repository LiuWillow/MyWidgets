package com.example.administrator.widgets.imgloader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.widgets.R;

/**
 * Created by Administrator on 2017/6/3.
 */

public class LoadActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    ImgAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.img_load_layout);
        recyclerView = (RecyclerView)findViewById(R.id.recycle);
        adapter = new ImgAdapter(this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}
