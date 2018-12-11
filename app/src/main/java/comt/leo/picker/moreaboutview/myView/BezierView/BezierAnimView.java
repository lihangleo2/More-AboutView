package comt.leo.picker.moreaboutview.myView.BezierView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Toast;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.evaluator.BezierEvaluator;

/**
 * Created by leo
 * on 2018/12/11.
 * 二阶 贝塞尔 动画抛物线
 */
public class BezierAnimView extends View {
    private int startX;//开始点x
    private int startY;//开始点y


    private int endX;//结束点x
    private int endY;//结束点y

    private int contralX;//控制点x。(可移动的)
    private int contralY;//控制点y

    private int moveX;//要开启动画小球的点
    private int moveY;

    private Paint paintPoint;//点的画笔


    /**
     * 终点就在下面
     */
    private Paint bezierPaint;//贝塞尔曲线画笔
    private Path mPath = new Path();//贝塞尔曲线的路径

    private ValueAnimator bigValueAnimator;//小球运行完之后 让其有种被装进去的感觉
    private int pointRadius = 30;

    public BezierAnimView(Context context) {
        super(context);
    }

    public BezierAnimView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //初始化画笔
        initPaint();

    }

    public BezierAnimView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    private void initPaint() {
        paintPoint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintPoint.setColor(getResources().getColor(R.color.bezier_red));
        paintPoint.setStyle(Paint.Style.FILL);
        paintPoint.setStrokeWidth(20);


        bezierPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bezierPaint.setColor(getResources().getColor(R.color.black));
        bezierPaint.setStyle(Paint.Style.STROKE);
        bezierPaint.setStrokeWidth(10);

        bigValueAnimator = ValueAnimator.ofInt(30, 45, 30);
        bigValueAnimator.setDuration(300);
        bigValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                pointRadius = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        startX = w / 4;
        startY = h / 4;

        moveX = startX;
        moveY = startY;

        endX = w * 3 / 4;
        endY = h / 4 + w / 2;


        contralX = w * 3 / 4;//先初始化控制点
        contralY = h / 4;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawPoint(startX, startY, paintPoint);//起始点
//        canvas.drawPoint(endX, endY, paintPoint);//终点
//        canvas.drawPoint(moveX, moveY, paintPoint);

        //起始球
        canvas.drawCircle(startX, startY, 30, paintPoint);
        canvas.drawCircle(endX, endY, 30, paintPoint);

        canvas.drawCircle(moveX, moveY, pointRadius, paintPoint);//动画的小球

        /*
         * 上面这些操作都是前期辅助工作 真正的在下面
         *  短短4行代码  绘制了贝塞尔曲线
         * */

        mPath.reset();//每次都情况path，因为随着移动点不断改变 path路径不断改变
        mPath.moveTo(startX, startY);
        mPath.quadTo(contralX, contralY, endX, endY);
        canvas.drawPath(mPath, bezierPaint);

    }

    public void startAnim() {
        BezierEvaluator bezierEvaluator = new BezierEvaluator(new PointF(contralX, contralY));
        ValueAnimator anim = ValueAnimator.ofObject(bezierEvaluator,
                new PointF(startX, startY),
                new PointF(endX, endY));
        anim.setDuration(600);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PointF point = (PointF) valueAnimator.getAnimatedValue();
                moveX = (int) point.x;
                moveY = (int) point.y;
                postInvalidate();
            }
        });

        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                bigValueAnimator.start();
                Toast.makeText(getContext(), "动画结束了！", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        anim.setInterpolator(new AccelerateInterpolator());
        anim.start();
    }


}
