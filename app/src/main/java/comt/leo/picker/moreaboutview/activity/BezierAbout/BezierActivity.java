package comt.leo.picker.moreaboutview.activity.BezierAbout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2018/12/11.
 *
 * 有关这篇的学习  参考: https://www.jianshu.com/p/55c721887568
 */
public class BezierActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier);
        findViewById(R.id.buttonPanel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BezierActivity.this,SimpleSecondOrderActivity.class));
            }
        });

        findViewById(R.id.buttonPane2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BezierActivity.this,ThirdOrderActivity.class));
            }
        });

        findViewById(R.id.buttonPane3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BezierActivity.this,BezierAnimActivity.class));
            }
        });
    }
}
