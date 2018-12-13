package comt.leo.picker.moreaboutview.activity.CubeAbout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comt.leo.picker.moreaboutview.R;


/**
 * Created by leo
 * on 2018/12/12.
 */
public class CubeMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubemenu);
        findViewById(R.id.buttonPanel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CubeMenuActivity.this, AttrbuteWelComeActivity.class));
            }
        });
    }
}
