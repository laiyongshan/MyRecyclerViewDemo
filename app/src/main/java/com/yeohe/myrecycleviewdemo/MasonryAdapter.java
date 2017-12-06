package com.yeohe.myrecycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yeohe.myrecycleviewdemo.StaggeredGrid.Meizi;

import java.util.List;

/**
 * Created by Administrator on 2017/12/5.
 */

public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView> {

    private List<Meizi> products;
    private Context context;

    public MasonryAdapter(List<Meizi> list,Context context) {
        products=list;
        this.context=context;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.masonry_item, viewGroup, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, int position) {
        Glide.with(context)
                .load(products.get(position).getImgSrc())
                .centerCrop()
                .into(masonryView.imageView);
        masonryView.textView.setText(products.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class MasonryView extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public MasonryView(View itemView){
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.masonry_item_img );
            textView= (TextView) itemView.findViewById(R.id.masonry_item_title);
        }

    }


}
