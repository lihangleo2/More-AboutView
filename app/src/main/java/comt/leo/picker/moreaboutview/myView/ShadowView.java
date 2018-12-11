package comt.leo.picker.moreaboutview.myView;

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
 * on 2018/12/6.
 * <p>
 * 经常可以看到相机页  只有中间部分是透明的，其他部分是阴影的
 * 看完代码 你会觉得非常简单
 */
public class ShadowView extends View {
    private Paint paint;


    public ShadowView(Context context) {
        this(context,null);
    }

    public ShadowView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ShadowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //DST_OUT:只在源文件和目标文件不相交的地方绘制
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //禁用硬件加速
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);//如果设置了setXfermode不生效的话，禁止硬件加速
        canvas.drawColor(getResources().getColor(R.color.view_show));
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 150, paint);
    }



}
