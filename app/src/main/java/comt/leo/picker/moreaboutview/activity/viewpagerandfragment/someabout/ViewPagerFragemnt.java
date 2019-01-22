package comt.leo.picker.moreaboutview.activity.viewpagerandfragment.someabout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * Created by leo
 * on 2019/1/16.
 */
public class ViewPagerFragemnt extends Fragment {
    private ViewPager viewPager;
    MagicIndicator magicIndicator;
    private ViewPagerFragmentAdapter adapter;
    private ArrayList<Fragment> mDataList = new ArrayList<>();
    private CommonNavigator commonNavigator;


    public static ViewPagerFragemnt newInstance() {
        ViewPagerFragemnt fragment = new ViewPagerFragemnt();
        return fragment;
    }

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_other, null);
            viewPager = view.findViewById(R.id.viewPagerQuestionOther);
            magicIndicator = view.findViewById(R.id.magic_indicator_questionOther);

            NomalSonFragment nomalFragment = NomalSonFragment.newInstance(1);
            NomalSonFragment nomalFragment2 = NomalSonFragment.newInstance(2);
            NomalSonFragment nomalFragment3 = NomalSonFragment.newInstance(3);
            mDataList.add(nomalFragment);
            mDataList.add(nomalFragment2);
            mDataList.add(nomalFragment3);

            adapter = new ViewPagerFragmentAdapter(getActivity().getSupportFragmentManager(), mDataList);
            viewPager.setAdapter(adapter);
            initMagicIndicator();
        }
        return view;
    }


    private void initMagicIndicator() {
        magicIndicator.setBackgroundColor(getResources().getColor(R.color.transparent));
        commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                final BadgePagerTitleView badgePagerTitleView = new BadgePagerTitleView(context);

                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText("子页面-" + index);
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
