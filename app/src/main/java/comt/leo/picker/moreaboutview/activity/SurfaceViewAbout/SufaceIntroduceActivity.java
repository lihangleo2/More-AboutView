package comt.leo.picker.moreaboutview.activity.SurfaceViewAbout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.SurfaceViewAbouts.SurfaceViewL;

/**
 * Created by leo
 * on 2018/12/12.
 * SufaceView简单介绍:
 * 1、有单独的绘图表面，可以单独在一个线程进行绘制，不占用主线程资源
 * 2、在一些频繁刷新，执行逻辑的自定义View中可以使用SufaceView
 * 3、有2个子类： GLSufaceView 和VideoView
 *
 * SufaceView 和 View 的主要区别
 *  ①、View主要适用于主动更新的情况下，而SurfaceView主要适用于被动更新，例如频繁地刷新
 *  ②、View在主线程中对画面进行刷新，而SurfaceView通常会通过一个子线程来进行页面的刷新
 *  ③、View在绘图时没有使用双缓冲机制，而SufaceView在底层实现机制中就已经实现了双缓冲机制
 *
 *  如果自定义View需要频繁刷新，或者刷新时数据处理量比较大，就 可以考虑使用SurfaceView来取代View了
 *
 * 参考文章：https://www.jianshu.com/p/15060fc9ef18
 *
 * //利用SufaceView实现简单画图板//
 */
public class SufaceIntroduceActivity extends AppCompatActivity {
    private SurfaceViewL surfaceviewl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sufaceintroduce);
        surfaceviewl = findViewById(R.id.surfaceviewl);
    }
}
