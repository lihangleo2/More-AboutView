package comt.leo.picker.moreaboutview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.bigkoo.quicksidebar.QuickSideBarTipsView;
import com.bigkoo.quicksidebar.QuickSideBarView;
import com.bigkoo.quicksidebar.listener.OnQuickSideBarTouchListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.adapter.SortAdapter;
import comt.leo.picker.moreaboutview.bean.VocationBean;
import comt.leo.picker.moreaboutview.bean.VocationSortBean;
import comt.leo.picker.moreaboutview.myView.siderbar.PinyinComparator;
import comt.leo.picker.moreaboutview.myView.siderbar.PinyinUtils;

/**
 * Created by leo
 * on 2019/1/10.
 * <p>
 * 首先lib里处理首字母排序jar: pinyin4j-2.5.0.jar
 * 右边siderBar控件引入moudle: quicksidebar
 */
public class PingyActivity extends AppCompatActivity implements OnQuickSideBarTouchListener {

    private ArrayList<VocationBean> vocationList = new ArrayList<>();
    ListView sortListView;
    private SortAdapter adapter;
    private List<VocationSortBean> SourceDateList;

    /*
     * 优化、
     * */
    QuickSideBarView quickSideBarView;
    QuickSideBarTipsView quickSideBarTipsView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pingy);
        quickSideBarView = (QuickSideBarView) findViewById(R.id.quickSideBarView);
        //设置监听
        quickSideBarView.setOnQuickSideBarTouchListener(this);
        quickSideBarTipsView = findViewById(R.id.quickSideBarTipsView);

        sortListView = findViewById(R.id.lv_contact);
        vocationList.add(new VocationBean("阿里巴巴"));
        vocationList.add(new VocationBean("阿珂"));
        vocationList.add(new VocationBean("宝宝"));
        vocationList.add(new VocationBean("北京街"));
        vocationList.add(new VocationBean("贝乐蒂"));
        vocationList.add(new VocationBean("小蔡"));
        vocationList.add(new VocationBean("小哥"));
        vocationList.add(new VocationBean("谷歌"));
        vocationList.add(new VocationBean("哥哥"));
        vocationList.add(new VocationBean("密码是"));
        vocationList.add(new VocationBean("纯粹是"));
        vocationList.add(new VocationBean("利率"));
        vocationList.add(new VocationBean("李书豪"));
        vocationList.add(new VocationBean("大飞机"));
        vocationList.add(new VocationBean("大脑斧"));
        vocationList.add(new VocationBean("鹅卵石"));
        vocationList.add(new VocationBean("鹅疙瘩"));
        setAdapter();

    }

    private void setAdapter() {
        SourceDateList = filledData(vocationList);
        Collections.sort(SourceDateList, new PinyinComparator());
        adapter = new SortAdapter(this, SourceDateList);
        sortListView.setAdapter(adapter);
    }


    //    String[] date
    private List<VocationSortBean> filledData(ArrayList<VocationBean> list) {
        List<VocationSortBean> mSortList = new ArrayList<>();
        ArrayList<String> indexString = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            VocationSortBean sortModel = new VocationSortBean();
            sortModel.setName(list.get(i).getName());
            String pinyin = PinyinUtils.getPingYin(list.get(i).getName());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
                if (!indexString.contains(sortString)) {
                    indexString.add(sortString);
                }
            } else {
                sortModel.setSortLetters("#");
                if (!indexString.contains(sortString)) {
//                    indexString.add("#");
                }
            }
            mSortList.add(sortModel);
        }
        Collections.sort(indexString);
        //不自定义则默认26个字母
        quickSideBarView.setLetters(indexString);
        return mSortList;
    }

    @Override
    public void onLetterChanged(String letter, int position, float y) {
        /*
         * 第4个参数
         * 解决第一次点击，没有测量就已经走了方法mWith为0的Bug
         * */
        quickSideBarTipsView.setText(letter, position, y, quickSideBarTipsView.getMeasuredWidth());
        //该字母首次出现的位置
        int newPosition = adapter.getPositionForSection(letter.charAt(0));
        if (position != -1) {
            sortListView.setSelection(newPosition);
        }
    }

    @Override
    public void onLetterTouching(boolean touching) {
        //可以自己加入动画效果渐显渐隐
        quickSideBarTipsView.setVisibility(touching ? View.VISIBLE : View.INVISIBLE);
    }
}
