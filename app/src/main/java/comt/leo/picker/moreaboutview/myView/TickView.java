package comt.leo.picker.moreaboutview.myView;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.utils.DisplayUtil;


/**
 * Created by lihang on 2017/11/22.
 */

public class TickView extends View {

    private AnimatorSet animatorSet = new AnimatorSet();

    private Paint paint;//画圆弧的画笔
    private Paint oKpaint;//画勾的画笔

    private Paint circlePaint;//白色的圆
    private int radius = 80;


    private RectF mRectF = new RectF();
    //控件中心的X,Y坐标
    private int centerX;
    private int centerY;

    //绘制勾的路径
    private Path path = new Path();

    //绘制李字路径
    private Path pathLeo = new Path();

    private PathMeasure pathMeasure;
    private DashPathEffect effect;


    /**
     * 设置画圆动画
     */
    private ValueAnimator animator_circle;
    private int currentProgress;

    private boolean isStart;
    private int whiteRadius = -1;
    private ValueAnimator animator_white;

    private int scaceRadius = 100;
    private ValueAnimator animator_scace;


    private ValueAnimator animator_line;
    private boolean startLine;


    private ClickAndAnim listener;

    public ClickAndAnim getListener() {
        return listener;
    }

    public void setListener(ClickAndAnim listener) {
        this.listener = listener;
    }


    public TickView(Context context) {
        this(context, null);
    }

    public TickView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
        initAnim();
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClickListener();
                }
            }
        });


        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (listener != null) {
                    listener.onAnimFish();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


    }


    //初始化动画
    private void initAnim() {

        animator_circle = ValueAnimator.ofInt(0, 360);
        animator_circle.setDuration(600);
        animator_circle.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                paint.setColor(getResources().getColor(R.color.pink));
                currentProgress = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });


        animator_white = ValueAnimator.ofInt(radius - 5, 0);
        animator_white.setDuration(400);
        animator_white.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                whiteRadius = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });


        animator_scace = ValueAnimator.ofInt(radius, radius + 50, radius);
        animator_scace.setDuration(600);
        animator_scace.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                scaceRadius = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });


        animator_line = ValueAnimator.ofFloat(1, 0);
        animator_line.setDuration(1000);
        animator_line.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                startLine = true;
                float value = (Float) animation.getAnimatedValue();

                effect = new DashPathEffect(new float[]{pathMeasure.getLength(), pathMeasure.getLength()}, value * pathMeasure.getLength());
                oKpaint.setPathEffect(effect);
                postInvalidate();

            }
        });

    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dp2px(2));
        paint.setColor(getResources().getColor(R.color.grey));


        oKpaint = new Paint();
        oKpaint.setAntiAlias(true);
        oKpaint.setStyle(Paint.Style.STROKE);
        oKpaint.setStrokeWidth(dp2px(2));
        oKpaint.setColor(getResources().getColor(R.color.grey));


        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setStrokeWidth(dp2px(2));
        circlePaint.setColor(Color.WHITE);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //设置圆圈的外切矩形

        centerX = getMeasuredWidth() / 2;
        centerY = getMeasuredHeight() / 2;
        mRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);

        path.moveTo(getMeasuredHeight() / 8 * 3, getMeasuredHeight() / 2);
        path.lineTo(getMeasuredHeight() / 2, getMeasuredHeight() / 5 * 3);
        path.lineTo(getMeasuredHeight() / 3 * 2, getMeasuredHeight() / 5 * 2);


        pathLeo.moveTo(getMeasuredWidth() / 2 - 55, getMeasuredHeight() / 2 - 50);
        pathLeo.lineTo(getMeasuredWidth() / 2 + 55, getMeasuredHeight() / 2 - 50);

        pathLeo.moveTo(getMeasuredWidth() / 2, getMeasuredHeight() / 2 - 80);
        pathLeo.lineTo(getMeasuredWidth() / 2, getMeasuredHeight() / 2 - 10);


        pathLeo.moveTo(getMeasuredWidth() / 2, getMeasuredHeight() / 2 - 50);
        pathLeo.lineTo(getMeasuredWidth() / 2 - 70, getMeasuredHeight() / 2);

        pathLeo.moveTo(getMeasuredWidth() / 2, getMeasuredHeight() / 2 - 50);
        pathLeo.lineTo(getMeasuredWidth() / 2 + 70, getMeasuredHeight() / 2);


        pathLeo.moveTo(getMeasuredWidth() / 2 - 35, getMeasuredHeight() / 2 - 10);
        pathLeo.lineTo(getMeasuredWidth() / 2 + 35, getMeasuredHeight() / 2 - 10);
        pathLeo.lineTo(getMeasuredWidth() / 2, getMeasuredHeight() / 2 + 20);
        pathLeo.lineTo(getMeasuredWidth() / 2, getMeasuredHeight() / 2 + 70);
        pathLeo.lineTo(getMeasuredWidth() / 2 - 25, getMeasuredHeight() / 2 + 60);

        pathLeo.moveTo(getMeasuredWidth() / 2 - 50, getMeasuredHeight() / 2 + 30);
        pathLeo.lineTo(getMeasuredWidth() / 2 + 50, getMeasuredHeight() / 2 + 30);


        pathMeasure = new PathMeasure(pathLeo, true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (!isStart) {
            oKpaint.setColor(getResources().getColor(R.color.grey));

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(dp2px(2));
            paint.setColor(getResources().getColor(R.color.grey));
            canvas.drawArc(mRectF, 90, 360, false, paint);
            canvas.drawPath(path, oKpaint);

        } else {
            canvas.drawArc(mRectF, 90, currentProgress, false, paint);

            if (currentProgress == 360) {
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
            }
            circlePaint.setColor(Color.WHITE);
            canvas.drawCircle(centerX, centerY, whiteRadius, circlePaint);
            if (whiteRadius == 0) {
                Log.e("应该走了的啊", scaceRadius + "");
                circlePaint.setColor(getResources().getColor(R.color.pink));
                canvas.drawCircle(centerX, centerY, scaceRadius, circlePaint);
            }

            if (startLine) {
                oKpaint.setColor(Color.BLACK);
                canvas.drawPath(pathLeo, oKpaint);
            }

        }


    }

    //dp值转换成px值
    private int dp2px(float dpValue) {
        return DisplayUtil.dp2px(getContext(), dpValue);
    }


    public void start() {
//        animatorSet.play(animator_circle).before(animator_white).before(animator_scace);
        if (isStart) {

            isStart = false;
            postInvalidate();

        } else {
            currentProgress = 0;
            whiteRadius = -1;
            scaceRadius = 100;
            effect = new DashPathEffect(new float[]{pathMeasure.getLength(), pathMeasure.getLength()}, 1 * pathMeasure.getLength());
            oKpaint.setPathEffect(effect);

            isStart = true;
            animatorSet.play(animator_white).after(animator_circle).before(animator_scace).before(animator_line);
            animatorSet.start();
        }
    }


    public interface ClickAndAnim {

        void onClickListener();

        void onAnimFish();
    }


}
