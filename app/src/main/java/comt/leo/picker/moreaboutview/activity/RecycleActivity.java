package comt.leo.picker.moreaboutview.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.adapter.ManagerIconsAdapter;

/**
 * Created by leo
 * on 2019/4/26.
 */
public class RecycleActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.ItemDecoration itemDecoration;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        recyclerView = findViewById(R.id.recyclerView);

        itemDecoration = new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.right = -45;
            }
        };

        ArrayList<String> stringArr  = new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            stringArr.add("tu");
        }

        final ManagerIconsAdapter adapter = new ManagerIconsAdapter(this);
        ArrayList<String> stringList = new ArrayList<>();
        stringList.addAll(stringArr);
        stringList.add("数字" + stringArr.size());
        adapter.setList(stringList);
        LinearLayoutManager layoutManagertip = new LinearLayoutManager(this);
        layoutManagertip.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManagertip);
        recyclerView.removeItemDecoration(itemDecoration);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
    }
}
