package comt.leo.picker.moreaboutview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.MyView;

/**
 * Created by leo
 * on 2018/12/4.
 */
public class MyViewandTwoActivity extends AppCompatActivity {
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_twoa);
        /*
         * 这里xml设置了中社会了精确模式  设置了400px
         * */
        myView = findViewById(R.id.myView);
        findViewById(R.id.buttonPanel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.startAnim();
            }
        });

        findViewById(R.id.buttonPane2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.startAnimAndInterprlator();
            }
        });
    }
}
