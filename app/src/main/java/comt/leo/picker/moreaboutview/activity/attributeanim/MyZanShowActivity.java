package comt.leo.picker.moreaboutview.activity.attributeanim;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2019/1/9.
 */
public class MyZanShowActivity extends AppCompatActivity {
    private ImageView ivCollection;
    private ImageView iv_Zan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zanshow);
        ivCollection = findViewById(R.id.ivCollection);
        iv_Zan = findViewById(R.id.iv_Zan);
        ivCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationDrawable animationDrawable = (AnimationDrawable) ivCollection.getDrawable();
                animationDrawable.start();
            }
        });

        iv_Zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) iv_Zan.getTag();
                if (tag.equals("0")) {
                    iv_Zan.setImageResource(R.drawable.zan_click_userdetail);
                    AnimationDrawable animationDrawable = (AnimationDrawable) iv_Zan.getDrawable();
                    animationDrawable.start();
                    iv_Zan.setTag("1");

                } else {

                    iv_Zan.setImageResource(R.mipmap.iv_hart_1);
                    iv_Zan.setTag("0");

                }
            }
        });

    }
}
