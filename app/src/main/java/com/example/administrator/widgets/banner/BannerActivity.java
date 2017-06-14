package com.example.administrator.widgets.banner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.widgets.R;

/**
 * Created by Administrator on 2017/6/14.
 */

public class BannerActivity extends AppCompatActivity {
    ViewPager viewPager;
    CircleIndicatorView indicatorView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banner_layout);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        indicatorView = (CircleIndicatorView)findViewById(R.id.indicator_view);

        indicatorView.setUpWithViewPager(viewPager);
    }

}
