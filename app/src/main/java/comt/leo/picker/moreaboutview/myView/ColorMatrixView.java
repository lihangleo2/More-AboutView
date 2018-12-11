package comt.leo.picker.moreaboutview.myView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.View;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2018/12/4.
 */
public class ColorMatrixView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ColorMatrixView(Context context) {

        super(context);
        initPaint();

    }

    public ColorMatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public ColorMatrixView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
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
        /**
         * 1、setColorFilter(ColorFilter filter)设置颜色过滤器
         *  有三个子类：
         *      ①、PorterDuffColorFilter(@ColorInt int color, @NonNull PorterDuff.Mode mode)，
         *      一个指定单一颜色和特定模式的过滤器
         *      参数1：int color 颜色
         *      参数2：PorterDuff.Mode mode 模式
         */
//        PorterDuffColorFilter filter = new PorterDuffColorFilter(Color.BLUE, PorterDuff.Mode.OVERLAY);
//        paint.setColorFilter(filter);
        /**
         *      ②、LightingColorFilter(int mul, int add)，
         *      一个可以模拟简单光照影响的色彩过滤器
         *      参数1：mul 全称是colorMultiply意为色彩倍增
         *      参数2：add 全称是colorAdd意为色彩添加
         * */

//        LightingColorFilter filter = new LightingColorFilter(Color.WHITE, Color.GREEN);
//        paint.setColorFilter(filter);

        /**
         *      ③、ColorMatrixColorFilter(ColorMatrix matrix)
         *      一个通过 4 * 5 色彩矩阵计算进行变换颜色的过滤器
         *      参数：【色彩矩阵】ColorMatrix
         * */

//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                1, 0, 0, 0, 50,//R 值决定新的颜色值中的R —— 红色
//                0, 1, 0, 0, 50,//G  值决定新的颜色值中的G —— 绿色
//                0, 0, 1, 0, 0,//B   值决定新的颜色值中的B —— 蓝色
//                0, 0, 0, 1, 0});//A 值决定新的颜色值中的A —— 透明度
//        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(colorMatrix);
//        paint.setColorFilter(filter);

        /**
         * ColorMatrix 色彩矩阵
         *      色调 ， 物体传播的颜色
         *      饱和度 ，颜色的纯度，从0(灰)到100%(饱和)来进行描述
         *      亮度 ， 颜色的相对明暗程度
         *
         *
         *          ①setRotate(int axis, float degrees) 设置色调
         *          axis 颜色编号 0,1,2
         *          degrees 需要处理的值
         */

        //色调
//        ColorMatrix rotateMatrix = new ColorMatrix();
//        rotateMatrix.setRotate(0, 1);//红
//        rotateMatrix.setRotate(1, 1);//绿
//        rotateMatrix.setRotate(2, 1);//蓝
//        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(rotateMatrix);
//        paint.setColorFilter(filter);


        /**
         *         ②etSaturation(float sat) 设置饱和度
         *          float sat 饱和度值 ；0位灰色图像， 1为原图
         */
        //饱和度
//        ColorMatrix saturationMatrix = new ColorMatrix();
//        saturationMatrix.setSaturation(5.0f);
//        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(saturationMatrix);
//        paint.setColorFilter(filter);

        /**
         *          ③setScale(float rScale, float gScale, float bScale, float aScale)设置亮度
         *
         *          当rScale,gScale,bScale代表的三原色相同时，就会显示白色。利用这个原理进行亮度的改变 。0代表全黑 1原图
         * */

//        //亮度
//        ColorMatrix scaleMatrix = new ColorMatrix();
//        scaleMatrix.setScale(50,50,50,1);
//        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(scaleMatrix);
//        paint.setColorFilter(filter);


        //这里onMeasure后已经得出了 控件实际大小了。可以用这种方式获取
        float width = getWidth();
        float height = getHeight();

        canvas.drawCircle(width / 2, height / 2, width / 2, paint);
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
