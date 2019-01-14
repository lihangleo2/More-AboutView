package comt.leo.picker.moreaboutview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.adapter.ImpressWordAdapter;
import comt.leo.picker.moreaboutview.bean.ImpressSonBean;
import comt.leo.picker.moreaboutview.bean.NewImpressItemBean;

/**
 * Created by leo
 * on 2019/1/14.
 * <p>
 * app build.gradle  添加依赖 ： implementation 'com.zhy:flowlayout-lib:1.0.3'
 * 这是自适应标签的 一个依赖。
 * 点击张开和收起 则是利用了recycleView adapter 的 remove and insert
 */
public class RecycleViewTagActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recycleView;
    private ImpressWordAdapter adapter;

    private ArrayList<NewImpressItemBean> impressList = new ArrayList<>();

    //需要展开的那个条目
    private NewImpressItemBean addBeauImpressBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleviewtag);
        recycleView = findViewById(R.id.recycleView);
        initData();

        adapter = new ImpressWordAdapter(this, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(layoutManager);

        NewImpressItemBean newImpressItemBean = new NewImpressItemBean();
        newImpressItemBean.setCode("flag");

        ArrayList<ImpressSonBean> tagList = new ArrayList<>();
        ImpressSonBean impressSonBean = new ImpressSonBean();
        impressSonBean.setTagCount(2);
        impressSonBean.setTitle("可爱");
        tagList.add(impressSonBean);


        ImpressSonBean impressSonBean2 = new ImpressSonBean();
        impressSonBean2.setTagCount(1);
        impressSonBean2.setTitle("美丽大方");
        tagList.add(impressSonBean2);

        ImpressSonBean impressSonBean3 = new ImpressSonBean();
        impressSonBean3.setTitle("贤惠");
        tagList.add(impressSonBean3);


        ImpressSonBean impressSonBean4 = new ImpressSonBean();
        impressSonBean4.setTitle("无敌美少女战士");
        tagList.add(impressSonBean4);

        ImpressSonBean impressSonBean5 = new ImpressSonBean();
        impressSonBean5.setTagCount(5);
        impressSonBean5.setTitle("美");
        tagList.add(impressSonBean5);

        ImpressSonBean impressSonBean6 = new ImpressSonBean();
        impressSonBean6.setTitle("小巧");
        tagList.add(impressSonBean6);

        ImpressSonBean impressSonBean7 = new ImpressSonBean();
        impressSonBean7.setTitle("34D");
        tagList.add(impressSonBean7);

        newImpressItemBean.setTagList(tagList);
        impressList.add(newImpressItemBean);

        //展开的item
        NewImpressItemBean zhankaiBean = new NewImpressItemBean();
        zhankaiBean.setCode("zhanK");
        zhankaiBean.setRemark("展开");
        impressList.add(zhankaiBean);


        adapter.setData(impressList);
        recycleView.setAdapter(adapter);
    }

    private void initData() {
        addBeauImpressBean = new NewImpressItemBean();
        addBeauImpressBean.setCode("flag");

        ArrayList<ImpressSonBean> tagList = new ArrayList<>();
        ImpressSonBean impressSonBean = new ImpressSonBean();
        impressSonBean.setTagCount(2);
        impressSonBean.setTitle("可爱");
        tagList.add(impressSonBean);


        ImpressSonBean impressSonBean2 = new ImpressSonBean();
        impressSonBean2.setTagCount(1);
        impressSonBean2.setTitle("美丽大方");
        tagList.add(impressSonBean2);

        ImpressSonBean impressSonBean3 = new ImpressSonBean();
        impressSonBean3.setTitle("贤惠");
        tagList.add(impressSonBean3);


        ImpressSonBean impressSonBean4 = new ImpressSonBean();
        impressSonBean4.setTitle("精巧鼻");
        tagList.add(impressSonBean4);

        ImpressSonBean impressSonBean5 = new ImpressSonBean();
        impressSonBean5.setTagCount(5);
        impressSonBean5.setTitle("美");
        tagList.add(impressSonBean5);

        ImpressSonBean impressSonBean6 = new ImpressSonBean();
        impressSonBean6.setTitle("小巧");
        tagList.add(impressSonBean6);

        ImpressSonBean impressSonBean7 = new ImpressSonBean();
        impressSonBean7.setTitle("无与伦比");
        tagList.add(impressSonBean7);

        ImpressSonBean impressSonBean8 = new ImpressSonBean();
        impressSonBean8.setTitle("时尚");
        tagList.add(impressSonBean8);

        addBeauImpressBean.setTagList(tagList);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_zhankItem:
                //点击展开条目的时候触发
                NewImpressItemBean zhankBean = (NewImpressItemBean) view.getTag();
                if (addBeauImpressBean.isMore()) {
                    zhankBean.setRemark("展开");
                    ((TextView) view).setText("展开");
                    impressList.remove(addBeauImpressBean);
                    adapter.notifyItemRemoved(1);
                    addBeauImpressBean.setMore(false);
                } else {
                    zhankBean.setRemark("收起");
                    ((TextView) view).setText("收起");
                    impressList.add(1, addBeauImpressBean);
                    adapter.notifyItemInserted(1);
                    addBeauImpressBean.setMore(true);
                }
                break;
        }
    }
}
