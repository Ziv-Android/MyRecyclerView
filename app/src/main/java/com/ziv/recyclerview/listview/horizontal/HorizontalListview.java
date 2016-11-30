package com.ziv.recyclerview.listview.horizontal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ziv.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用RecyclerView实现ListView Horizontal
 * Created by ziv on 16-11-29.
 */

public class HorizontalListview extends AppCompatActivity {
    public static final int SPAN_COUNT = 4;

    private RecyclerView mRecyclerView;
    private HorizontalListAdapter mAdapter;

    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_horizontal);

        initData();
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.list_vertical);
        LinearLayoutManager layoutManager = new GridLayoutManager(this, SPAN_COUNT);
        // 可通过layoutManager获取诸多属性信息
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        // RecyclerView添加item之间的分割线(该分割线是系统默认的样式)
        // 样式的改变在style中通过设置<item name="android:listDivider">的属性值即可
        // 纵向简单间隔可以使用item的margin属性设置
        // 设置DividerItemDecoration.HORIZONTAL没有效果…???
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            mDatas.add(String.valueOf(i));
        }
        // 此处传入ApplicationContext与this的区别在哪里?那种方法好，为什么…???
        mAdapter = new HorizontalListAdapter(getApplicationContext(), mDatas);
    }
}