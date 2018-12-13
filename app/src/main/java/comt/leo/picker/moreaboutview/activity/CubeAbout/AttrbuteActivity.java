package comt.leo.picker.moreaboutview.activity.CubeAbout;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.activity.MainActivity;

/**
 * Created by leo
 * on 2018/12/12.
 */
public class AttrbuteActivity extends AppCompatActivity {
    private ImageView image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attrbute);
        image = (ImageView) findViewById(R.id.image);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animator animator = AnimatorInflater.loadAnimator(AttrbuteActivity.this,R.anim.anim);
                animator.setTarget(image);
                animator.start();
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        super.onAnimationCancel(animation);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);


                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        super.onAnimationRepeat(animation);
                    }

                    @Override
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                    }

                    @Override
                    public void onAnimationPause(Animator animation) {
                        super.onAnimationPause(animation);
                    }

                    @Override
                    public void onAnimationResume(Animator animation) {
                        super.onAnimationResume(animation);
                    }
                });


            }
        });
    }
}
