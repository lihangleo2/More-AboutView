package comt.leo.picker.moreaboutview.activity.attributeanim;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.WaveLineView;

/**
 * Created by leo
 * on 2019/1/9.
 */
public class MyAnimFourActivity extends AppCompatActivity {

    private WaveLineView waveLineView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animfour);
        waveLineView = findViewById(R.id.waveLineView);
        waveLineView.setInitialRadius(100);
        waveLineView.setStyle(Paint.Style.STROKE);
        waveLineView.setColor(getResources().getColor(R.color.wave_color));
        waveLineView.start();
    }
}
