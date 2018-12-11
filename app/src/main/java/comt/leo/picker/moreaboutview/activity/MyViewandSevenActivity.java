package comt.leo.picker.moreaboutview.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.ColorMatrixView;

/**
 * Created by leo
 * on 2018/12/6.
 */
public class MyViewandSevenActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    //介绍看这个自定义控件的注释
    private ColorMatrixView colorMatrixView;

    private SeekBar seekBar1;//色调
    private SeekBar seekBar2;//饱和度
    private SeekBar seekBar3;//亮度

    private ImageView image;

    private Bitmap bitmap;

    private float hue;
    private float saturation;
    private float lum;
    private final float MID_VALUE = 100.0F;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_seven);
        colorMatrixView = findViewById(R.id.colorMatrixView);
        seekBar1 = findViewById(R.id.seekBar1);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar3 = findViewById(R.id.seekBar3);
        image = findViewById(R.id.image);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.otherwoman);

        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar3.setOnSeekBarChangeListener(this);
        seekBar1.setProgress(100);
        seekBar2.setProgress(100);
        seekBar3.setProgress(100);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        switch (seekBar.getId()) {
            case R.id.seekBar1:
                hue = (progress - MID_VALUE) * 1.0f / MID_VALUE * 180;
                Log.e("看看这个值", (progress - MID_VALUE) + "========" + hue);
                break;
            case R.id.seekBar2:
                saturation = progress * 1.0f / MID_VALUE;
                break;
            case R.id.seekBar3:
                lum = progress * 1.0F / MID_VALUE;
                break;
        }
        image.setImageBitmap(handleImageEffect(bitmap, hue, saturation, lum));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private Bitmap handleImageEffect(Bitmap bitmap, float hue, float saturation, float lum) {
        Bitmap b = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(b);
        Paint paint = new Paint();
        //色调
        ColorMatrix rotateMatrix = new ColorMatrix();
        rotateMatrix.setRotate(0, hue);//r  后面需要处理的值
        rotateMatrix.setRotate(1, hue);//g
        rotateMatrix.setRotate(2, hue);//b
        //饱和度
        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);//饱和度

        //亮度
        ColorMatrix scaleMatrix = new ColorMatrix();
        scaleMatrix.setScale(lum, lum, lum, 1);//rgba  最后个是偏移量


        ColorMatrix imgMatrix = new ColorMatrix();
        imgMatrix.postConcat(rotateMatrix);
        imgMatrix.postConcat(saturationMatrix);
        imgMatrix.postConcat(scaleMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imgMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return b;
    }


}
