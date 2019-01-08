package comt.leo.picker.moreaboutview.myView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

import comt.leo.picker.moreaboutview.animabout.Rotate3dAnimationUpdate;
import comt.leo.picker.moreaboutview.utils.DisplayUtil;


/**
 * Created by leo
 * on 2019/1/7.
 */
public class SizeTwoView extends FrameLayout {
    private View frontView;//前面布局
    private View backView;//后面布局

    private Rotate3dAnimationUpdate animationToBack;//由前向后的动画
    private Rotate3dAnimationUpdate animationToFront;//由后向前的动画


    public SizeTwoView(Context context) {
        this(context, null);
    }

    public SizeTwoView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public SizeTwoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        backView = getChildAt(0);
        frontView = getChildAt(1);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //这里的240 是控件大小
        final float centerX = DisplayUtil.dp2px(getContext(), 240) / 2.0f;
        final float centerY = DisplayUtil.dp2px(getContext(), 240) / 2.0f;

        //括号内参数分别为（上下文，开始角度，结束角度，x轴中心点，y轴中心点，深度，是否扭曲）
        animationToBack = new Rotate3dAnimationUpdate(getContext(), 0, 90, centerX, centerY, 0f, true);
        animationToBack.setDuration(600);                         //设置动画时长
        animationToBack.setFillAfter(true);                        //保持旋转后效果
        animationToBack.setInterpolator(new LinearInterpolator());    //设置插值器

        animationToFront = new Rotate3dAnimationUpdate(getContext(), -90, 0, centerX, centerY, 0f, true);
        animationToFront.setDuration(600);
        animationToFront.setFillAfter(true);
        animationToFront.setInterpolator(new LinearInterpolator());


        animationToBack.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                if (flagNum % 2 == 0) {
                    //如果等于0 说明前面的view 到了后面
                    frontView.setVisibility(View.GONE);
                    backView.setVisibility(View.VISIBLE);
                    backView.startAnimation(animationToFront);
                } else {
                    //如果等于1 说明前面的view 还是前面
                    backView.setVisibility(View.GONE);
                    frontView.setVisibility(View.VISIBLE);
                    frontView.startAnimation(animationToFront);
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        animationToFront.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isPlaying = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private int flagNum = 1;//当前标识 用于判断哪个进行翻转
    private boolean isPlaying = false; //用于判断动画结束啊，点击按钮才进行翻转

    public void frontToBack() {
        /*
         * 翻转效果：由前向后 转动
         * */
        if (!isPlaying) {
            isPlaying = true;
            flagNum++;
            if (flagNum % 2 == 0) {
                //如果等于0 说明前面的view 到了后面
                frontView.startAnimation(animationToBack);
            } else {
                //如果等于1 说明前面的view 还是前面
                backView.startAnimation(animationToBack);
            }
        }
    }

}
