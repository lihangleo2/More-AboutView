package comt.leo.picker.moreaboutview.activity.BezierAbout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.BezierView.BezierAnimView;

/**
 * Created by leo
 * on 2018/12/11.
 */
public class BezierAnimActivity extends AppCompatActivity {
    private BezierAnimView bezierAnimView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezieranim);
        bezierAnimView = findViewById(R.id.bezierAnimView);
        findViewById(R.id.buttonPanel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bezierAnimView.startAnim();
            }
        });
    }
}
