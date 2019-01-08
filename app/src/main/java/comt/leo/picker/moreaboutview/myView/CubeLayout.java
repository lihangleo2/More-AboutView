package comt.leo.picker.moreaboutview.myView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BaseInterpolator;
import android.widget.FrameLayout;

import comt.leo.picker.moreaboutview.animabout.CubeLeftInAnimation;
import comt.leo.picker.moreaboutview.animabout.CubeLeftOutAnimation;
import comt.leo.picker.moreaboutview.animabout.CubeRightInAnimation;
import comt.leo.picker.moreaboutview.animabout.CubeRightOutAnimation;

/**
 * Created by leo on 19/1/7.
 */
public class CubeLayout extends FrameLayout {

    private BaseInterpolator mInterpolator = new AccelerateDecelerateInterpolator();

    public CubeLayout(Context context) {
        this(context, null);
    }

    public CubeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CubeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private View foregroundView;
    private View backgroundView;


    private CubeRightInAnimation cubeRightInAnimation;
    private CubeRightOutAnimation cubeRightOutAnimation;
    private CubeLeftOutAnimation cubeLeftOutAnimation;
    private CubeLeftInAnimation cubeLeftInAnimation;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        foregroundView = getChildAt(0);
        backgroundView = getChildAt(1);

        cubeLeftOutAnimation = new CubeLeftOutAnimation();
        cubeLeftOutAnimation.setDuration(1000);
        cubeLeftOutAnimation.setFillAfter(true);

        cubeLeftInAnimation = new CubeLeftInAnimation();
        cubeLeftInAnimation.setDuration(1000);
        cubeLeftInAnimation.setFillAfter(true);


        cubeRightInAnimation = new CubeRightInAnimation();
        cubeRightInAnimation.setDuration(1000);
        cubeRightInAnimation.setFillAfter(true);

        cubeRightOutAnimation = new CubeRightOutAnimation();
        cubeRightOutAnimation.setDuration(1000);
        cubeRightOutAnimation.setFillAfter(true);


    }


    private float downX;
    private float downY;

    private float currentX;
    private float currentY;
    private int index = 1000;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //获取手指在屏幕上的坐标
//        float x = event.getX();
//        float y = event.getY();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN://按下
                downX = event.getX();
                downY = event.getY();

                Log.e("看看x轴的变化", "按下的x轴坐标=====" + downX);
                break;
            case MotionEvent.ACTION_MOVE://移动

                break;
            case MotionEvent.ACTION_UP://松开
                currentX = event.getX();
                currentY = event.getY();

                Log.e("看看x轴的变化", "松开的x轴坐标=====" + currentX);
                if (downX - currentX > 0) {
                    index++;

                    if (index % 2 == 1){
                        foregroundView.startAnimation(cubeLeftOutAnimation);
                        backgroundView.startAnimation(cubeRightInAnimation);
                    }else {
                        backgroundView.startAnimation(cubeLeftOutAnimation);
                        foregroundView.startAnimation(cubeRightInAnimation);
                    }


                }else {

                    if (index % 2 == 1){
                        foregroundView.startAnimation(cubeRightOutAnimation);
                        backgroundView.startAnimation(cubeLeftInAnimation);
                    }else {
                        backgroundView.startAnimation(cubeRightOutAnimation);
                        foregroundView.startAnimation(cubeLeftInAnimation);
                    }

                    index--;
                }
                break;
        }
        return true;
    }
}

