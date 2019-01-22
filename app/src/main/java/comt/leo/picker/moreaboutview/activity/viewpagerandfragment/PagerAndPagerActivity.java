package comt.leo.picker.moreaboutview.activity.viewpagerandfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgePagerTitleView;

import java.util.ArrayList;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.activity.viewpagerandfragment.someabout.NomalFragment;
import comt.leo.picker.moreaboutview.activity.viewpagerandfragment.someabout.ViewPagerFragemnt;
import comt.leo.picker.moreaboutview.activity.viewpagerandfragment.someabout.ViewPagerFragmentAdapter;

public class PagerAndPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    MagicIndicator magicIndicator;
    private ViewPagerFragmentAdapter adapter;
    private ArrayList<Fragment> mDataList = new ArrayList<>();
    private CommonNavigator commonNavigator;

    /*
     * 以后就用这种方式传，以便后面数据的更改。
     * */
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, PagerAndPagerActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagerandpager);
        viewPager = findViewById(R.id.viewPagerQuestion);
        magicIndicator = findViewById(R.id.magic_indicator_question);
        ViewPagerFragemnt viewPagerFragemnt = ViewPagerFragemnt.newInstance();
        NomalFragment nomalFragment = NomalFragment.newInstance(1);
        NomalFragment nomalFragment2 = NomalFragment.newInstance(2);
        NomalFragment nomalFragment3 = NomalFragment.newInstance(3);
        mDataList.add(nomalFragment);
        mDataList.add(nomalFragment2);
        mDataList.add(nomalFragment3);
        mDataList.add(viewPagerFragemnt);

        adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), mDataList);
        viewPager.setAdapter(adapter);
        initMagicIndicator();
    }

    private void initMagicIndicator() {
        magicIndicator.setBackgroundColor(getResources().getColor(R.color.transparent));
        commonNavigator = new CommonNavigator(PagerAndPagerActivity.this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                final BadgePagerTitleView badgePagerTitleView = new BadgePagerTitleView(context);

                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText("页面-" + index);
                simplePagerTitleView.setNormalColor(getResources().getColor(R.color.blackbb));
                simplePagerTitleView.setSelectedColor(getResources().getColor(R.color.mine_color));
                simplePagerTitleView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(index);
                        //点击按钮的的时候取消 小红点(和AutoCancelBadge属性有点像)
//                        badgePagerTitleView.setBadgeView(null);
                    }
                });


                badgePagerTitleView.setInnerPagerTitleView(simplePagerTitleView);


                return badgePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setLineHeight(UIUtil.dip2px(context, 3));
                indicator.setLineWidth(UIUtil.dip2px(context, 10));
                indicator.setRoundRadius(UIUtil.dip2px(context, 3));
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
                indicator.setColors(getResources().getColor(R.color.mine_color));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }
}