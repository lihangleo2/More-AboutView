package comt.leo.picker.moreaboutview.activity;

import android.os.Bundle;
import android.support.annotation.NavigationRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.AttrView;

/**
 * Created by leo
 * on 2018/12/5.
 */
public class MyViewandThreeActivity extends AppCompatActivity implements View.OnClickListener {
    private AttrView attrView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_three);
        findViewById(R.id.buttonPanel).setOnClickListener(this);
        findViewById(R.id.buttonPane2).setOnClickListener(this);
        findViewById(R.id.buttonPane3).setOnClickListener(this);
        findViewById(R.id.buttonPane4).setOnClickListener(this);
        findViewById(R.id.buttonPane5).setOnClickListener(this);

        findViewById(R.id.buttonPane6).setOnClickListener(this);
        findViewById(R.id.buttonPane9).setOnClickListener(this);
        findViewById(R.id.buttonPane10).setOnClickListener(this);
        attrView = findViewById(R.id.attrView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonPanel:
                attrView.setRoundCorner(10);
                break;

            case R.id.buttonPane2:
                attrView.setRoundCorner(30);
                break;

            case R.id.buttonPane3:
                attrView.setRoundCorner(50);
                break;

            case R.id.buttonPane4:
                attrView.setRoundCorner(100);
                break;
            case R.id.buttonPane5:
                attrView.setRoundCorner(200);
                break;



            /*
             * 下面是动画改变圆角
             * */

            case R.id.buttonPane6:
                attrView.serRoundCornerAnim(10);
                break;

            case R.id.buttonPane9:
                attrView.serRoundCornerAnim(100);
                break;
            case R.id.buttonPane10:
                attrView.serRoundCornerAnim(200);
                break;


        }
    }
}
