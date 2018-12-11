package comt.leo.picker.moreaboutview.myView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2018/12/4.
 */
public class MyView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint paintArc = new Paint(Paint.ANTI_ALIAS_FLAG);

    private ValueAnimator animator_arc;//属性动画的一种
    private int angle;

    public MyView(Context context) {
        super(context);
        initPaint();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint.setColor(getResources().getColor(R.color.leoColor));
        paintArc.setColor(getResources().getColor(R.color.leoBlackColor));
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measuredHeight(heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //这里onMeasure后已经得出了 控件实际大小了。可以用这种方式获取
        float width = getWidth();
        float height = getHeight();

//        canvas.drawRect(0, 0, width, height, paint);//绘制普通矩形

        RectF rectF = new RectF(0, 0, width, height);
        canvas.drawRoundRect(rectF, height / 2, height / 2, paint); //绘制圆角矩形，2 3参数是圆角半径，如果正好是高度的一般，那么正好是圆
        canvas.drawArc(rectF, 0, angle, true, paintArc);
    }


    /**
     * 测量宽
     * 这里看是什么模式，如果不是精准模式，那么久是wrap，则给个固定大小
     *
     * @param widthMeasureSpec
     */
    private int measureWidth(int widthMeasureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {//这是wrap的模式，给一个固定大小
            result = 400;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    /**
     * 测量高
     *
     * @param heightMeasureSpec
     */
    private int measuredHeight(int heightMeasureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 400;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    public void startAnim() {
        //插值器动画
        animator_arc = ValueAnimator.ofInt(0, 360);
        animator_arc.setDuration(1500);
        animator_arc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                angle = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });

        if (!animator_arc.isRunning()) {
            animator_arc.start();
        }
    }

    public void startAnimAndInterprlator() {
        animator_arc = ValueAnimator.ofInt(0, 360);
        animator_arc.setDuration(1500);
        animator_arc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                angle = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        animator_arc.setInterpolator(new BounceInterpolator());
        if (!animator_arc.isRunning()) {
            //插值器动画
            animator_arc.start();
        }
    }


}
