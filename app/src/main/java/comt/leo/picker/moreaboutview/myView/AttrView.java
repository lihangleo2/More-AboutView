package comt.leo.picker.moreaboutview.myView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2018/12/5.
 * <p>
 * 由于上面一个说了 圆角矩形。那么这里，就自定义这个圆角矩形 属性
 * <p>
 * 1、首先在values里创建attrs文件夹，在其定义属性。
 * 2、在构造方法中将 AttributeSet 带入，得到属性
 */
public class AttrView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float circleAngle;
    private ValueAnimator animator_arc;//属性动画的一种


    public AttrView(Context context) {
        super(context);
    }

    public AttrView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        init(attrs);
    }

    public AttrView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
        init(attrs);

    }


    //获取自定义属性
    private void init(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.RoundView);
        circleAngle = typedArray.getDimension(R.styleable.RoundView_roundCorner, 0);
    }


    private void initPaint() {
        paint.setColor(getResources().getColor(R.color.leoColor));
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measuredHeight(heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = getWidth();
        float height = getHeight();

        RectF rectF = new RectF(0, 0, width, height);

        /*
         * 如果 圆角的半径已经超过控件一半，那么以控件一半为半径。
         * */

        if (circleAngle > height / 2) {
            circleAngle = height / 2;
        }
        canvas.drawRoundRect(rectF, circleAngle, circleAngle, paint); //绘制圆角矩形，2 3参数是圆角半径，如果正好是高度的一般，那么正好是圆

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

    public void setRoundCorner(int circleAngle) {
        this.circleAngle = circleAngle;
        postInvalidate();
    }


    public void serRoundCornerAnim(int circleAngleComing){
        //插值器动画
        animator_arc = ValueAnimator.ofInt((int) circleAngle, circleAngleComing);
        animator_arc.setDuration(1000);
        animator_arc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                circleAngle = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });

        if (!animator_arc.isRunning()) {
            animator_arc.start();
        }
    }


}
