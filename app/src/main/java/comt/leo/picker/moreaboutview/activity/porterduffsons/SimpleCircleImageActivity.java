package comt.leo.picker.moreaboutview.activity.porterduffsons;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.porterduffview.CircleImageLeoView;

/**
 * Created by leo
 * on 2018/12/10.
 */
public class SimpleCircleImageActivity extends AppCompatActivity {
    private CircleImageLeoView circleView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplecircle);
        circleView2 = findViewById(R.id.circleView2);
        circleView2.setImageResource(R.mipmap.otherwoman);

    }

}
