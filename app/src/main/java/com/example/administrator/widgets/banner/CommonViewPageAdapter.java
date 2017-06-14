package com.example.administrator.widgets.banner;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.widgets.R;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class CommonViewPageAdapter<T>/* extends PagerAdapter*/ {
 /*   private List<T> mDatas;
    private ViewPageHolderCreator mCreator;

    public CommonViewPageAdapter(List<T> datas, ViewPageHolderCreator creator){
        mDatas = datas;
        mCreator = creator;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       View view = getView(position, null, container);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    //获取ViewPager页面展示View
    private View getView(int position, View view, ViewGroup container){
        ViewPageHolder holder = null;
        if(view == null){
            //创建holder
            holder = mCreator.createViewHolder();
            view = holder.createView(container.getContext());
            view.setTag(R.id.common_view_pager_item_tag, holder);
        }else {
            holder = (ViewPageHolder) view.getTag(R.id.common_view_pager_item_tag);
        }
        if(holder != null && mDatas != null && mDatas.size() > 0){
            //数据绑定
            holder.onBind(container.getContext(), position, mDatas.get(position));
        }
        return view;
    }*/
}
