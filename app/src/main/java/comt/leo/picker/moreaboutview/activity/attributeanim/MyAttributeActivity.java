package comt.leo.picker.moreaboutview.activity.attributeanim;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2019/1/8.
 * 项目中用到的属性动画相关
 */
public class MyAttributeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myattribute);
        findViewById(R.id.buttonPanel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyAttributeActivity.this, MyAnimOneActivity.class));
            }
        });

        findViewById(R.id.buttonPane2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyAttributeActivity.this, MyAnimTwoActivity.class));
            }
        });

        findViewById(R.id.buttonPane3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyAttributeActivity.this, MyAnimThreeActivity.class));
            }
        });

        findViewById(R.id.buttonPane4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyAttributeActivity.this, MyAnimFourActivity.class));
            }
        });
    }
}
