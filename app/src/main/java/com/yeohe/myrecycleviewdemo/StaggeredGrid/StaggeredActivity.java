package com.yeohe.myrecycleviewdemo.StaggeredGrid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.yeohe.myrecycleviewdemo.DividerGridItemDecoration;
import com.yeohe.myrecycleviewdemo.MasonryAdapter;
import com.yeohe.myrecycleviewdemo.Product;
import com.yeohe.myrecycleviewdemo.R;
import com.yeohe.myrecycleviewdemo.SpacesItemDecoration;
import com.yeohe.myrecycleviewdemo.adapter.MyRvAdapter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2017/12/5.
 */

public class StaggeredActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered);

        initView();
        initData();

    }

    private void initData() {
        mLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);//网格布局
        mRecyclerView.setLayoutManager(mLayoutManager);
//        mAdapter = new MyRvAdapter(getData(),this);

        MasonryAdapter adapter=new MasonryAdapter(list,this);
        mRecyclerView.setAdapter(adapter);
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(20);
        mRecyclerView.addItemDecoration(decoration);

        getData();

    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        // 设置布局管理器
//        mRecyclerView.setLayoutManager(mLayoutManager);
        // 设置adapter
//        mRecyclerView.setAdapter(mAdapter);
    }

    List<Meizi> list = new ArrayList<>();
    private void getData() {

        //网易的接口(可以浏览器直接访问)
        String url = "http://c.3g.163.com/recommend/getChanListNews?" +
                "channel=T1456112189138&size=20&passport=&devId=1uuFYbybIU2oqSRGyFrjCw%3D%3D" +
                "&lat=%2F%2FOm%2B%2F8ScD%2B9fX1D8bxYWg%3D%3D&lon=LY2l8sFCNzaGzqWEPPgmUw%3D%3D" +
                "&version=9.0&net=wifi&ts=1464769308" +
                "&sign=bOVsnQQ6gJamli6%2BfINh6fC%2Fi9ydsM5XXPKOGRto5G948ErR02zJ6%2FKXOnxX046I" +
                "&encryption=1&canal=meizu_store2014_news" +
                "&mac=sSduRYcChdp%2BBL1a9Xa%2F9TC0ruPUyXM4Jwce4E9oM30%3D";


        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.optJSONArray("美女");
                    for(int i=0; i < array.length();i++){
                        JSONObject item = array.optJSONObject(i);
                        Meizi bean = new Meizi();
                        if(item.has("imgsrc")) {
                            String imgsrc = item.optString("imgsrc");
                            bean.setImgSrc(imgsrc);
                        }
                        if(item.has("title")) {
                            String title = item.optString("title");
                            bean.setTitle(title);
                        }
                        list.add(bean);
                    }
                    MasonryAdapter adapter=new MasonryAdapter(list,StaggeredActivity.this);
                    adapter.notifyDataSetChanged();
                    mRecyclerView.setAdapter(adapter);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}
