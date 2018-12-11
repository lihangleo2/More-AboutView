package comt.leo.picker.moreaboutview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.CircleProgressView;

/**
 * Created by leo
 * on 2018/12/7.
 */
public class CircleProgressActivity extends AppCompatActivity {
    private CircleProgressView circleProgressView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress);
        circleProgressView = findViewById(R.id.circleProgressView);
        findViewById(R.id.buttonPanel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circleProgressView.setProgress(10);
            }
        });


        findViewById(R.id.buttonPane2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circleProgressView.setProgress(30);
            }
        });

        findViewById(R.id.buttonPane3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circleProgressView.setProgress(50);
            }
        });

        findViewById(R.id.buttonPane4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circleProgressView.setProgress(100);
            }
        });
    }
}
