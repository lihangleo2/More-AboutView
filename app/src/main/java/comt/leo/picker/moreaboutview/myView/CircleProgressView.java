package comt.leo.picker.moreaboutview.myView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2018/12/4.
 */
public class CircleProgressView extends View {

    private Paint mBgPaint;//背景弧线paint
    private int circleWith;//进度条宽度
    private Paint mProgressPaint;//进度条paint
    private int progressColor;

    private int max;//当前最大值
    private int progress;//当前进度值
    private float circleAngle;//进度条转化成 我们要旋转的角度
    private int animTime;//动画持续时间

    private ValueAnimator animator;//给进度条加上动画


    public CircleProgressView(Context context) {
        super(context);
        initPaint();
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
        initPaint();
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
        initPaint();
    }

    //获取自定义属性
    private void init(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CircleProgressView);
        circleWith = dip2px(getContext(), typedArray.getDimension(R.styleable.CircleProgressView_circleWith, 7));
        progressColor = typedArray.getColor(R.styleable.CircleProgressView_progressColor, getResources().getColor(R.color.leoColor));
        max = typedArray.getInteger(R.styleable.CircleProgressView_max, 100);
        progress = typedArray.getInteger(R.styleable.CircleProgressView_progress, 0);
        animTime = typedArray.getInteger(R.styleable.CircleProgressView_animTime, 1500);
    }

    private void initPaint() {
        //背景圆弧
        mBgPaint = new Paint();
        mBgPaint.setAntiAlias(true);
        mBgPaint.setStrokeWidth(circleWith);
        mBgPaint.setStyle(Paint.Style.STROKE);
        mBgPaint.setColor(Color.parseColor("#eaecf0"));
        mBgPaint.setStrokeCap(Paint.Cap.ROUND);

        //进度圆弧
        mProgressPaint = new Paint();
        mProgressPaint.setAntiAlias(true);
        mProgressPaint.setStyle(Paint.Style.STROKE);
        mProgressPaint.setStrokeWidth(circleWith);
        mProgressPaint.setColor(progressColor);
        mProgressPaint.setStrokeCap(Paint.Cap.ROUND);


        int changeAngle = progress * 360 / max > 360 ? 360 : progress * 360 / max;
        //插值器动画
        animator = ValueAnimator.ofInt((int) 0, changeAngle);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setDuration(animTime);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                circleAngle = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });

        if (!animator.isRunning()) {
            animator.start();
        }


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
        RectF rectF = new RectF(circleWith, circleWith, width - circleWith, height - circleWith);

        //注意点  不能使用中心
        canvas.drawArc(rectF, 0, 360, false, mBgPaint);
        //想要改变圆环初始点的话，可以在这里改变 startAngle
        canvas.drawArc(rectF, -90, circleAngle, false, mProgressPaint);
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


    /**
     * Dip to Px
     *
     * @param context
     * @param dipValue
     * @return
     */
    public int dip2px(Context context, float dipValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    public void setProgress(int currentProgress) {
        this.progress = currentProgress;
        float tempAngle = circleAngle;
        int changeAngle = progress * 360 / max > 360 ? 360 : progress * 360 / max;
        //插值器动画
        animator = ValueAnimator.ofInt((int) tempAngle, changeAngle);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setDuration(animTime);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                circleAngle = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });

        if (!animator.isRunning()) {
            animator.start();
        }
    }


}
