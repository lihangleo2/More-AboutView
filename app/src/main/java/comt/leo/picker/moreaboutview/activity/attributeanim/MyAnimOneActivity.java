package comt.leo.picker.moreaboutview.activity.attributeanim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2019/1/8.
 */
public class MyAnimOneActivity extends AppCompatActivity {
    private ImageView image_zuo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animone);
        image_zuo = findViewById(R.id.image_zuo);
        Animation leftTorightAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_left_toright);
        image_zuo.startAnimation(leftTorightAnimation);
    }
}
