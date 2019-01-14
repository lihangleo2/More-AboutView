package comt.leo.picker.moreaboutview.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.adapter.ScrollViewpagerAdapter;
import comt.leo.picker.moreaboutview.dviewpager.ViewPagerUtils;
import comt.leo.picker.moreaboutview.dviewpager.ZoomOutPageTransformer;

/**
 * Created by leo
 * on 2019/1/11.
 */
public class ViewPagerSelfActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;
    private ScrollViewpagerAdapter viewpagerAdapter;
    private ArrayList<String> datalist = new ArrayList<>();

    private Handler mHandler;
    private Runnable mRunnable;
    private int currentViewPagerIndex = 0;

    private boolean isFigDown = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpagerself);
        viewPager = findViewById(R.id.viewPager);
        initListener();

        for (int i = 0; i < 6; i++) {
            datalist.add(i + "");
        }

        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                if (isFigDown) {
                    isFigDown = false;
                    //设置viewPager的滚动时间
                    ViewPagerUtils.controlViewPagerSpeed(ViewPagerSelfActivity.this, viewPager, 600);//设置你想要的时间
                }

                //递增
                viewPager.setVisibility(View.VISIBLE);
                currentViewPagerIndex++;
                viewPager.setCurrentItem(currentViewPagerIndex, true);
                //进行下一次
                mHandler.postDelayed(this, 3500);
            }
        };
        //设置viewPager的滚动时间
        ViewPagerUtils.controlViewPagerSpeed(ViewPagerSelfActivity.this, viewPager, 600);//设置你想要的时间
        //设置viewPager的滚动动画
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());


        viewpagerAdapter = new ScrollViewpagerAdapter(ViewPagerSelfActivity.this, this);
        viewpagerAdapter.setMathcList(datalist);
        viewPager.setAdapter(viewpagerAdapter);

        mHandler.postDelayed(mRunnable, 1500);
    }

    private void initListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentViewPagerIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (mRunnable != null) {
                        //判断手机有没有按下，用于之后恢复viewPager速度
                        isFigDown = true;
                        //设置viewPager的滚动时间
                        //此时手指拿下后，调整viewPager滑动速度。
                        ViewPagerUtils.controlViewPagerSpeed(ViewPagerSelfActivity.this, viewPager, 200);//设置你想要的时间
                        mHandler.removeCallbacks(mRunnable);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (mRunnable != null) {
                        mHandler.removeCallbacks(mRunnable);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (mRunnable != null) {
                        mHandler.postDelayed(mRunnable, 3500);
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
