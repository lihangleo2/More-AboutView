package comt.leo.picker.moreaboutview.myView.porterduffview;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2018/12/10.
 */
public class NormalView extends View {
    private Paint paint_circle;
    private Paint paint_rectf;
    public NormalView(Context context) {
        super(context);
    }

    public NormalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public NormalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        //设置画布背景色
        canvas.drawARGB(255, 139, 197, 186);


        int r = canvas.getWidth()/3;
        //绘制圆形
        canvas.drawCircle(r,r,r,paint_circle);

        //绘制矩形
        canvas.drawRect(r, r, r * 2.7f, r * 2.7f, paint_rectf);
    }
}
