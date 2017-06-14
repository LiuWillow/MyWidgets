package com.example.administrator.widgets.banner;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2017/6/14.
 */

public interface ViewPageHolder<T> {
    View createView(Context context);
    void onBind(Context context, int position, T data);
}
