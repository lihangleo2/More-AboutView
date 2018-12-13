package comt.leo.picker.moreaboutview.myView.porterduffview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2018/12/10.
 */
public class CircleImageLeoView extends ImageView {
    private static final int COLORDRAWABLE_DIMENSION = 2;
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private Paint mPaint;
    private Bitmap mBitmap;//获取设置图片的bitmap

    /*
     * 自定义属性画笔
     * */
    private Paint paintSelf;
    private int circleWith;//变宽 宽度
    private int circleColor;//变宽 颜色

    public CircleImageLeoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CircleImageLeoView);

        circleWith = typedArray.getDimensionPixelSize(R.styleable.CircleImageLeoView_stoke_width, 0);
        circleColor = typedArray.getColor(R.styleable.CircleImageLeoView_stoke_color, getResources().getColor(R.color.leoColor));
        initPaint();

    }

    private void initPaint() {


        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paintSelf = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintSelf.setStrokeWidth(circleWith);
        paintSelf.setStyle(Paint.Style.STROKE);
        paintSelf.setColor(getResources().getColor(R.color.leoColor));
        paintSelf.setStrokeCap(Paint.Cap.ROUND);
    }


    @Override
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        mBitmap = bm;
        postInvalidate();
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        mBitmap = getBitmapFromDrawable(drawable);
        postInvalidate();
    }

    @Override
    public void setImageResource(@DrawableRes int resId) {
        super.setImageResource(resId);
        mBitmap = getBitmapFromDrawable(getDrawable());
        postInvalidate();
    }

    @Override
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        mBitmap = getBitmapFromDrawable(getDrawable());
        postInvalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if (mBitmap != null) {
            drawTargetBitmap(canvas, scaleAndBig(mBitmap, getWidth(), getHeight()));
        }

        if (circleWith != 0) {//如果边宽 宽度为0 那么久不绘制
            int r = Math.min(getWidth(), getHeight());
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, r / 2-circleWith/2, paintSelf);
        }

    }


    //这里是对图片进行缩放，以缩放比例最大的一边为准。
    private Bitmap scaleAndBig(Bitmap b, float with, float height) {
        int bitmapWith = b.getWidth();
        int bitmapHeight = b.getHeight();
        float scale = Math.max(with / bitmapWith, height / bitmapHeight);
        Matrix matrix = new Matrix();
        matrix.setScale(scale, scale);
        Bitmap resizeBitmap = Bitmap.createBitmap(b, 0, 0, bitmapWith, bitmapHeight, matrix, true);
        return resizeBitmap;
    }


    //把bitmap处理后重新绘制到画布上
    private void drawTargetBitmap(Canvas canvas, Bitmap bitmap) {
        final int sc = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        //先绘制dst层
        final float x = getWidth() / 2;
        final float y = getHeight() / 2;
        //以最短一边的2分之1为，圆角图片的半径
        final float radius = Math.min(getWidth(), getHeight()) / 2;
        canvas.drawCircle(x, y, radius, mPaint);
        //设置混合模式
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //绘制src层
        int minLine = Math.min(bitmap.getWidth(), bitmap.getHeight());

        //绘制图片的正中心，以最短的一边为 矩形的2分之1边上。截取一个正方形(这里我说的直接，自己理解)
        final float f_x = getWidth() / 2 - minLine / 2;
        final float f_y = getHeight() / 2 - minLine / 2;
        canvas.drawBitmap(bitmap, f_x, f_y, mPaint);

        // 还原混合模式
        mPaint.setXfermode(null);


        // 还原画布
        canvas.restoreToCount(sc);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measuredHeight(heightMeasureSpec));
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


    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        try {
            Bitmap bitmap;

            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(COLORDRAWABLE_DIMENSION, COLORDRAWABLE_DIMENSION, BITMAP_CONFIG);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }

            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }


    /**
     * Dip to Px
     *
     * @param context
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
