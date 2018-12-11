package comt.leo.picker.moreaboutview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.BaseView;
import comt.leo.picker.moreaboutview.myView.MyView;

/**
 * Created by leo
 * on 2018/12/4.
 */
public class MyViewandOnewActivity extends AppCompatActivity {
    private BaseView baseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one);
        /*
         * 注意 在xml布局种，长宽用的是  wrap_content
         * 那么 在自定义view中不是精确模式 那么久会走我们给定的大小400px
         * */
        baseView = findViewById(R.id.baseView);
    }
}
