package com.example.administrator.widgets.imgloader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.widgets.R;

/**
 * Created by Administrator on 2017/6/3.
 */

public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.ImgHolder> {
    String[] imgs = Images.imageThumbUrls;
    Context mContext;
    public ImgAdapter(Context context){
        mContext = context;
    }

    @Override
    public ImgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImgHolder(LayoutInflater.from(mContext).inflate(R.layout.img_load_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ImgHolder holder, int position) {
        ImageLoader.getInstance().loadImage(imgs[position], holder.imageView, true);
    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }

    class ImgHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ImgHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.img);
        }
    }
}
