package com.ziv.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ziv.recyclerview.gridview.horizontal.HorizontalGridview;
import com.ziv.recyclerview.gridview.vertical.VerticalGridview;
import com.ziv.recyclerview.listview.horizontal.HorizontalListview;
import com.ziv.recyclerview.listview.vertical.VerticalListview;
import com.ziv.recyclerview.waterfall.WaterFallview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * activity_main.xml使用LinearLayout实现，亦可尝试使用RecyclerView实现ExpandableListView
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 使用butterKnife绑定控件
        ButterKnife.bind(this);
    }

    // @formatter:off
    @BindView(R.id.btn_list_horizontal) Button horizontalListBtn;
    @BindView(R.id.btn_list_vertical)   Button verticalListBtn;
    @BindView(R.id.btn_grid_horizontal) Button horizontalGridBtn;
    @BindView(R.id.btn_grid_vertical)   Button verticalGridBtn;
    @BindView(R.id.btn_waterfall)       Button waterfallBtn;

    @OnClick({R.id.btn_list_horizontal, R.id.btn_list_vertical, R.id.btn_grid_horizontal,
              R.id.btn_grid_vertical, R.id.btn_waterfall})
    protected void onButtonClick(View view){
        Intent intent= new Intent();
        Class clazz = null;
        switch (view.getId()){
            case R.id.btn_list_horizontal:  clazz = HorizontalListview.class;   break;
            case R.id.btn_list_vertical:    clazz = VerticalListview.class;     break;
            case R.id.btn_grid_horizontal:  clazz = HorizontalGridview.class;   break;
            case R.id.btn_grid_vertical:    clazz = VerticalGridview.class;     break;
            case R.id.btn_waterfall:        clazz = WaterFallview.class;        break;
        }
        intent.setClass(this,clazz);
        startActivity(intent);
    }
    // @formatter:on
}
