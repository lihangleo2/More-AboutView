package comt.leo.picker.moreaboutview.myView.porterduffview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2018/12/10.
 */
public class ModeClearView extends View {
    private Paint paint_circle;
    private Paint paint_rectf;

    public ModeClearView(Context context) {
        super(context);
    }

    public ModeClearView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public ModeClearView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint_circle = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint_circle.setColor(getResources().getColor(R.color.porterDuff_yellow));

        paint_rectf = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint_rectf.setColor(getResources().getColor(R.color.porterDuff_blue));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //禁用硬件加速
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);//如果设置了setXfermode不生效的话，禁止硬件加速

        //设置画布背景色
        canvas.drawARGB(255, 139, 197, 186);


        int r = canvas.getWidth() / 3;
        //绘制圆形
        canvas.drawCircle(r, r, r, paint_circle);

        //使用clear 绘制蓝色矩形
        paint_rectf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawRect(r, r, r * 2.7f, r * 2.7f, paint_rectf);

        //最后将画笔去除Xfermode
        paint_rectf.setXfermode(null);

        /*
        * 跑出来的结果是白色
        * 是因为 dst我们使用了 clear,既绘制一个透明矩形。因为我们activity背景是白色。呈现了白色
        * */

    }
}
