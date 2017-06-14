package com.example.administrator.widgets.banner;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.widgets.R;

/**
 * Created by Administrator on 2017/6/14.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private static final int RES[] = new int[]{R.mipmap.q1, R.mipmap.q2, R.mipmap.q3, R.mipmap.q4};
    @Override
    public int getCount() {
        return RES.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.banner_item_layout, null);
        ImageView imageView = (ImageView)view.findViewById(R.id.image_item);
        imageView.setImageResource(RES[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
