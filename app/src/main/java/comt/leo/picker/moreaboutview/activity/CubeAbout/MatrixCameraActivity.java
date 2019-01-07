package comt.leo.picker.moreaboutview.activity.CubeAbout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.activity.MainActivity;
import comt.leo.picker.moreaboutview.animabout.Rotate3dAnimationUpdate;

/**
 * Created by leo
 * on 2019/1/7.
 */
public class MatrixCameraActivity extends AppCompatActivity {

    private Button buttonPanel;
    private ImageView image_;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrixcamera);
        image_ = findViewById(R.id.image_);
        buttonPanel = findViewById(R.id.buttonPanel);

        buttonPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 计算中心点（这里是使用view的中心作为旋转的中心点）
                final float centerX = image_.getWidth() / 2.0f;
                final float centerY = image_.getHeight() / 2.0f;

                //括号内参数分别为（上下文，开始角度，结束角度，x轴中心点，y轴中心点，深度，是否扭曲）
                final Rotate3dAnimationUpdate rotation = new Rotate3dAnimationUpdate(MatrixCameraActivity.this, 0, 180, centerX, centerY, 0f, true);

                rotation.setDuration(1500);                         //设置动画时长
                rotation.setFillAfter(true);                        //保持旋转后效果
                rotation.setInterpolator(new LinearInterpolator());	//设置插值器
                image_.startAnimation(rotation);

            }
        });
    }
}
