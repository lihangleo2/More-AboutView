package comt.leo.picker.moreaboutview.activity.systemviewself;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2019/1/10.
 */
public class SystemViewSelfActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systemview);
        findViewById(R.id.buttonPanel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SystemViewSelfActivity.this, RatingBarActivity.class));
            }
        });

        findViewById(R.id.buttonPane2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SystemViewSelfActivity.this, ProgressBarActivity.class));
            }
        });

        findViewById(R.id.buttonPane3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SystemViewSelfActivity.this, ToggleButtonActivity.class));
            }
        });

        findViewById(R.id.buttonPane4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SystemViewSelfActivity.this, SeekBarActivity.class));
            }
        });

    }
}
