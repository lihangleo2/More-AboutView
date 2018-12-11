package comt.leo.picker.moreaboutview.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.TickView;

/**
 * Created by leo
 * on 2018/12/11.
 */
public class MyTickActivity extends AppCompatActivity {

    private TickView tickView;
    private ImageView image;

    private static final int ANIM_TIME = 2000;
    private static final float SCALE_END = 1.2F;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytick);
        tickView = (TickView) findViewById(R.id.tickView);
        image = (ImageView) findViewById(R.id.image);
        tickView.setListener(new TickView.ClickAndAnim() {
            @Override
            public void onClickListener() {
                tickView.start();
            }

            @Override
            public void onAnimFish() {
                startAnim();
            }
        });
    }


    private void startAnim() {

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(image, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(image, "scaleY", 1f, SCALE_END);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIM_TIME).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter()
        {

            @Override
            public void onAnimationEnd(Animator animation)
            {


            }
        });
    }
}
