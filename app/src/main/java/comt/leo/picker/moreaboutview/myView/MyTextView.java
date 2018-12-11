package comt.leo.picker.moreaboutview.myView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v7.widget.WithHint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2018/12/4.
 */
public class MyTextView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);//底层圈画笔
    private Paint paintText = new Paint(Paint.ANTI_ALIAS_FLAG);//文字画笔
    private Paint paintOut = new Paint(Paint.ANTI_ALIAS_FLAG);//外层圈画笔


    private Paint paintArc = new Paint(Paint.ANTI_ALIAS_FLAG);//扇形弧形画笔


    private ValueAnimator animator_arc;//属性动画的一种

    public MyTextView(Context context) {
        super(context);
        initPaint();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint.setColor(getResources().getColor(R.color.grey));

        paintText.setColor(getResources().getColor(R.color.black));
        paintText.setTextSize(40f);

        paintOut.setColor(getResources().getColor(R.color.white));
        paintArc.setColor(getResources().getColor(R.color.leoColor));


    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measuredHeight(heightMeasureSpec));
    }


    private String testStr = "我爱中华人名共和国，自定义控件基础篇";  //要展示的text
    private int endIndex = testStr.length();//结束 末尾的index
    private int circleAngle = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //这里onMeasure后已经得出了 控件实际大小了。可以用这种方式获取
        float width = getWidth();
        float height = getHeight();
        canvas.drawCircle(width / 2, height / 2, width / 2 - 40f - 20, paint);

        RectF rectF = new RectF(40f + 20, 40f + 20, width - 40f - 20, height - 40f - 20);
        canvas.drawArc(rectF, 0, circleAngle, true, paintArc);

        canvas.drawCircle(width / 2, height / 2, width / 2 - 40f - 35, paintOut);


        Path path = new Path();  //绘制文字的 路劲
        path.addCircle(width / 2, height / 2, (width / 2 - 40f), Path.Direction.CW);//最后一个参数是  沿逆时针方向绘制。顺时针方向
        canvas.drawTextOnPath(testStr.substring(0, endIndex), path, 0, 0, paintText);
    }


    public void startAnim() {
        //插值器动画
        animator_arc = ValueAnimator.ofInt(0, testStr.length());
        animator_arc.setDuration(5000);
        animator_arc.setInterpolator(new LinearInterpolator());
        animator_arc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                endIndex = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
                circleAngle = 360 * endIndex / testStr.length();
            }
        });

        if (!animator_arc.isRunning()) {
            animator_arc.start();
        }
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


}
