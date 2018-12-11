package comt.leo.picker.moreaboutview.myView.BezierView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2018/12/11.
 * 二阶贝塞尔曲线 学习
 * 关键api：quadTo()和rQuadTo()
 */
public class BezierStudyView extends View {
    private int startX;//开始点x
    private int startY;//开始点y


    private int endX;//结束点x
    private int endY;//结束点y

    private int moveX;//控制点x。(可移动的)
    private int moveY;//控制点y

    private Paint paintPoint;//点的画笔
    private Paint paintText;//字体画笔

    private Paint paintLine;//连线的画笔

    /**
     * 终点就在下面
     */
    private Paint bezierPaint;//贝塞尔曲线画笔
    private Path mPath = new Path();//贝塞尔曲线的路径


    public BezierStudyView(Context context) {
        super(context);
    }

    public BezierStudyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //初始化画笔
        initPaint();

    }

    public BezierStudyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    private void initPaint() {
        paintPoint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintPoint.setColor(getResources().getColor(R.color.bezier_red));
        paintPoint.setStyle(Paint.Style.FILL);
        paintPoint.setStrokeWidth(20);

        paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintText.setColor(getResources().getColor(R.color.view_show));
        paintText.setStyle(Paint.Style.STROKE);
        paintText.setTextSize(40);

        paintLine = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintLine.setColor(getResources().getColor(R.color.bezier_line));
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setStrokeWidth(5);


        bezierPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bezierPaint.setColor(getResources().getColor(R.color.black));
        bezierPaint.setStyle(Paint.Style.STROKE);
        bezierPaint.setStrokeWidth(10);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        startX = w / 4;
        startY = h / 2;

        endX = w * 3 / 4;
        endY = h / 2;


        moveX = w / 2;//先初始化控制点
        moveY = h / 4;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPoint(startX, startY, paintPoint);//起始点
        canvas.drawText("起始点", startX, startY, paintText);
        canvas.drawPoint(endX, endY, paintPoint);//终点
        canvas.drawText("终点", endX, endY, paintText);

        canvas.drawPoint(moveX, moveY, paintPoint);
        canvas.drawText("控制点", moveX, moveY, paintText);

        canvas.drawLine(startX, startY, moveX, moveY, paintLine);//起始点 到 移动点
        canvas.drawLine(moveX, moveY, endX, endY, paintLine);//移动点 到 终点

        /*
         * 上面这些操作都是前期辅助工作 真正的在下面
         *  短短4行代码  绘制了贝塞尔曲线
         * */

        mPath.reset();//每次都情况path，因为随着移动点不断改变 path路径不断改变
        mPath.moveTo(startX, startY);
        mPath.quadTo(moveX, moveY, endX, endY);
        canvas.drawPath(mPath, bezierPaint);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                moveX = (int) event.getX();
                moveY = (int) event.getY();
                invalidate();
        }
        return true;

    }
}
