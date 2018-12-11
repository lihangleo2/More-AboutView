package comt.leo.picker.moreaboutview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.MyTextView;

/**
 * Created by leo
 * on 2018/12/5.
 */
public class MyViewandFourActivity extends AppCompatActivity {
    private MyTextView myTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_step_four);
        myTextView = findViewById(R.id.myTextView);
        findViewById(R.id.buttonPanel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTextView.startAnim();
            }
        });

    }
}
