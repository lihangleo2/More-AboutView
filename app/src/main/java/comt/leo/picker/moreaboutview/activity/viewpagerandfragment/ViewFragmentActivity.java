package comt.leo.picker.moreaboutview.activity.viewpagerandfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2019/1/16.
 */
public class ViewFragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfragment);
        findViewById(R.id.buttonPanel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewFragmentActivity.this, MagicIndicatorActivity.class));
            }
        });

        findViewById(R.id.buttonPane2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewFragmentActivity.this, PagerAndPagerActivity.class));
            }
        });
    }
}
