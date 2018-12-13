package comt.leo.picker.moreaboutview.activity.CubeAbout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.activity.MainActivity;

/**
 * Created by leo
 * on 2018/12/12.
 */
public class AttrbuteWelComeActivity extends AppCompatActivity {
    ImageView iv;
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attrwelcome);

        tv = (TextView) findViewById(R.id.textView1);
        iv = (ImageView) findViewById(R.id.imageView1);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.tvdonghua);
        tv.startAnimation(animation);




        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub
                tv.setVisibility(View.VISIBLE);
                Animation an = AnimationUtils.loadAnimation(AttrbuteWelComeActivity.this, R.anim.ivdonghua);
                iv.startAnimation(an);
                an.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // TODO Auto-generated method stub
                        startActivity(new Intent(AttrbuteWelComeActivity.this, AttrbuteActivity.class));
                        finish();
                    }
                });
            }
        });

    }
}
