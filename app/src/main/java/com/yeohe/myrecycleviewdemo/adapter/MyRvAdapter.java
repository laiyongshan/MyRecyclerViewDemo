package com.yeohe.myrecycleviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yeohe.myrecycleviewdemo.R;

import java.util.List;

/**
 * Created by Administrator on 2017/12/5.
 */

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyViewholder> {


    private List<String> mData;
    private Context context;
    private LayoutInflater inflater;

    public MyRvAdapter(List<String> mData,Context context){
        this.context=context;
        this.mData=mData;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_layout,parent, false);
        MyViewholder holder= new MyViewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
            holder.tv.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewholder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewholder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.item_tv);
        }
    }
}
