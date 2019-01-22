package comt.leo.picker.moreaboutview.activity.viewpagerandfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

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
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgeAnchor;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgePagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgeRule;

import java.util.ArrayList;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.adapter.ViewPagerFragmentMoreAdapter;

/**
 * Created by leo
 * on 2019/1/9.
 * <p>
 * app build 添加依赖：implementation 'com.github.hackware1993:MagicIndicator:1.5.0'
 * <p>
 * 项目build:
 * <p>
 * maven {
 * url "https://jitpack.io"
 * }
 */
public class MagicIndicatorActivity extends AppCompatActivity {

    private ViewPager viewPager;
    MagicIndicator magicIndicator;
    private ViewPagerFragmentMoreAdapter adapter;
    private ArrayList<String> mDataList = new ArrayList<>();
    private CommonNavigator commonNavigator;

    ImageView badgeImageView;//第一个红点

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magicindicator);
        viewPager = findViewById(R.id.viewPagerQuestion);
        magicIndicator = findViewById(R.id.magic_indicator_question);

        for (int i = 0; i < 10; i++) {
            mDataList.add("页面_" + i);
        }

        adapter = new ViewPagerFragmentMoreAdapter(getSupportFragmentManager(), mDataList);
        viewPager.setAdapter(adapter);

        badgeImageView = (ImageView) LayoutInflater.from(MagicIndicatorActivity.this).inflate(R.layout.simple_red_dot_badge_layout, null);

        initMagicIndicator();
    }

    private void initMagicIndicator() {
        magicIndicator.setBackgroundColor(getResources().getColor(R.color.transparent));
        commonNavigator = new CommonNavigator(MagicIndicatorActivity.this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                final BadgePagerTitleView badgePagerTitleView = new BadgePagerTitleView(context);

                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mDataList.get(index));
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

        //添加小红点相关
        ((BadgePagerTitleView) commonNavigator.getPagerTitleView(3)).setBadgeView(badgeImageView);
        ((BadgePagerTitleView) commonNavigator.getPagerTitleView(3)).setXBadgeRule(new BadgeRule(BadgeAnchor.CONTENT_RIGHT, -UIUtil.dip2px(MagicIndicatorActivity.this, 6)));
        ((BadgePagerTitleView) commonNavigator.getPagerTitleView(3)).setYBadgeRule(new BadgeRule(BadgeAnchor.CONTENT_TOP, 0));

        //这个设置 选中tab时小红点要不要取消
        ((BadgePagerTitleView) commonNavigator.getPagerTitleView(3)).setAutoCancelBadge(true);
    }
}
