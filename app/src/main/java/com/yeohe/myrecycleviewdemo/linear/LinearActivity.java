package com.yeohe.myrecycleviewdemo.linear;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yeohe.myrecycleviewdemo.DividerItemDecoration;
import com.yeohe.myrecycleviewdemo.R;
import com.yeohe.myrecycleviewdemo.adapter.MyRvAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/5.
 */

public class LinearActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        initData();
        initView();

    }


    private void initData() {
//        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);//垂直布局
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);//横向布局
        mAdapter = new MyRvAdapter(getData(),this);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(mLayoutManager);
        // 设置adapter
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));//添加间隔
    }

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for(int i = 0; i < 20; i++) {
            data.add(i + temp);
        }

        return data;
    }


}
