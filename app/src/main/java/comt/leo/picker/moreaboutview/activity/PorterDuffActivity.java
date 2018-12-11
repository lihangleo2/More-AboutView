package comt.leo.picker.moreaboutview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.activity.porterduffsons.ModeClearActivity;
import comt.leo.picker.moreaboutview.activity.porterduffsons.ModeClearBetterActivity;
import comt.leo.picker.moreaboutview.activity.porterduffsons.NormalActivity;
import comt.leo.picker.moreaboutview.activity.porterduffsons.SimpleCircleImageActivity;

/**
 * Created by leo
 * on 2018/12/10.
 * 参考文章csdn :  https://blog.csdn.net/iispring/article/details/50472485
 */
public class PorterDuffActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porterduff);

        findViewById(R.id.buttonPanel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PorterDuffActivity.this, NormalActivity.class));
            }
        });

        findViewById(R.id.buttonPane2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PorterDuffActivity.this, ModeClearActivity.class));
            }
        });

        findViewById(R.id.buttonPane3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PorterDuffActivity.this, ModeClearBetterActivity.class));
            }
        });


        findViewById(R.id.buttonPane4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PorterDuffActivity.this, SimpleCircleImageActivity.class));
            }
        });


    }
}
