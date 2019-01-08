package comt.leo.picker.moreaboutview.activity.CubeAbout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.SizeTwoView;

/**
 * Created by leo
 * on 2019/1/8.
 */
public class MatrixCameraTwoSizeActivity extends AppCompatActivity {
    private SizeTwoView sizeTwoView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myview);
        sizeTwoView = findViewById(R.id.sizeTwoView);
        findViewById(R.id.text_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sizeTwoView.frontToBack();
            }
        });
        findViewById(R.id.text_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sizeTwoView.frontToBack();
            }
        });
    }
}
