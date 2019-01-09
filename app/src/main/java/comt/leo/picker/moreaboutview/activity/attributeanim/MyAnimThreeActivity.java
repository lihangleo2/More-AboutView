package comt.leo.picker.moreaboutview.activity.attributeanim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.WaveView;

/**
 * Created by leo
 * on 2019/1/9.
 */
public class MyAnimThreeActivity extends AppCompatActivity {

    private ImageView image_blue;
    private WaveView waveView;
    private Animation rotateNAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animthree);
        image_blue = findViewById(R.id.image_blue);
        waveView = findViewById(R.id.waveView);
        rotateNAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_face_s);
        image_blue.startAnimation(rotateNAnimation);

        waveView.setColor(getResources().getColor(R.color.wave_color));
        waveView.start();
    }
}
