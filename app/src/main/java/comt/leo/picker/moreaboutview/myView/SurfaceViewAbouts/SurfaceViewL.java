package comt.leo.picker.moreaboutview.myView.SurfaceViewAbouts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2018/12/12.
 */
public class SurfaceViewL extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private SurfaceHolder mSurfaceHoler;
    //画布
    private Canvas mCanvas;
    //子线程标识，用于不断的进行刷新和重绘
    private boolean isDrawing;

    //画笔
    private Paint paint;
    private Path path;

    private float mLastX, mLastY;//上次点击的坐标

    public SurfaceViewL(Context context) {
        super(context);
    }

    public SurfaceViewL(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public SurfaceViewL(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mSurfaceHoler = getHolder();
        mSurfaceHoler.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        //保持屏幕长亮
        this.setKeepScreenOn(true);


        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(getResources().getColor(R.color.leoColor));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        path = new Path();


    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        drawing();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        isDrawing = false;//销毁的时候 暂停
    }

    @Override
    public void run() {
        while (isDrawing) {
            drawing();
            Log.e("我看看是否一致在走","======");
        }
    }


    private void drawing() {
        try {
            //获取当前的canvas 注意之前的内容都会保留，想要清除调用 drawColor()
            mCanvas = mSurfaceHoler.lockCanvas();
            //这里进行内容的绘制
            if (mCanvas != null) {
                mCanvas.drawColor(Color.WHITE);
                mCanvas.drawPath(path, paint);

            }
        } finally {
            if (mCanvas != null) {
                mSurfaceHoler.unlockCanvasAndPost(mCanvas);//这里进行画布内容的提交
            }
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                /*
                * 创建的时候开启线程并不断刷新
                * 这里将开启线程放在了手指按下的时刻  并不是时时都在更新
                * */
                isDrawing = true;
                new Thread(this).start();


                mLastX = x;
                mLastY = y;
                path.moveTo(mLastX, mLastY);
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x - mLastX);
                float dy = Math.abs(y - mLastY);
                if (dx >= 3 || dy >= 3) {
                    path.quadTo(mLastX, mLastY, (mLastX + x) / 2, (mLastY + y) / 2);
                }
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                isDrawing = false;
                break;
        }
        return true;
    }


}
