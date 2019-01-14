package comt.leo.picker.moreaboutview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.adapter.MainAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by leo
 * on 2019/1/11.
 *
 * 添加依赖 :     implementation 'se.emilsjolander:stickylistheaders:2.7.0'
 *
 */
public class StickeyHeadActivity extends AppCompatActivity {
    private StickyListHeadersListView stickyListHeadersListView;
    private MainAdapter mainAdapter;
    private List<String> headList;
    private List<String> bodyList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stickey);

        //初始化
        stickyListHeadersListView = (StickyListHeadersListView) findViewById(R.id.sl_list);
        mainAdapter = new MainAdapter(this);

        //设置头部的数据
        headList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            headList.add("头部停留  " + i);
        }
        mainAdapter.setHeadList(headList);

        //设置内容的数据
        bodyList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            bodyList.add("内容 -- " + i);
        }
        mainAdapter.setBodyList(bodyList);

        //设置头部的点击事件
        stickyListHeadersListView.setOnHeaderClickListener(new StickyListHeadersListView.OnHeaderClickListener() {
            @Override
            public void onHeaderClick(StickyListHeadersListView l, View header, int itemPosition, long headerId, boolean currentlySticky) {
                Toast.makeText(StickeyHeadActivity.this, "headerId:" + headerId, Toast.LENGTH_SHORT).show();
            }
        });

        //设置内容的点击事件
        stickyListHeadersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(StickeyHeadActivity.this, "i:" + i, Toast.LENGTH_SHORT).show();
            }
        });

        //设置头部改变的监听
        stickyListHeadersListView.setOnStickyHeaderChangedListener(new StickyListHeadersListView.OnStickyHeaderChangedListener() {
            @Override
            public void onStickyHeaderChanged(StickyListHeadersListView l, View header, int itemPosition, long headerId) {
                Toast.makeText(StickeyHeadActivity.this, "itemPosition:" + itemPosition, Toast.LENGTH_SHORT).show();
            }
        });
        stickyListHeadersListView.setAdapter(mainAdapter);
    }
}
