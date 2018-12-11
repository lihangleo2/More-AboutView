package comt.leo.picker.moreaboutview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.moxun.tagcloudlib.view.TagCloudView;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.adapter.LeoTagsAdapter;

/**
 * Created by leo
 * on 2018/12/7.
 * <p>
 * 集成：
 * 1、导入tagcloundlib,并加入项目中
 * 2、在项目 build 加入
 * classpath 'com.github.dcendents:android-maven-gradle-plugin:1.4' （如果是低版本studio 试试 1.3）
 * classpath 'com.jfrog.bintray.gradle:gradle-bintray-plugin:1.0'
 * <p>
 * 集成成功，试试效果吧~
 *
 *此项目github地址：https://github.com/misakuo/3dTagCloudAndroid
 *博主对此项目修改了2点：
 * ①、在松手后，列表滚动会有明显卡顿效果
 * ②、在手指快速滑动时候，松手后 会一直保持高速滚动 不会停止
 * （博主对源码进行了修改，可以研究下源码）
 */
public class MyViewandSixActivity extends AppCompatActivity {
    private TagCloudView fragmentTagcloud;
    private Button buttonPanel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_six);
        intiView();
    }

    private void intiView() {
        fragmentTagcloud = findViewById(R.id.fragment_tagcloud);
        buttonPanel = findViewById(R.id.buttonPanel);

        LeoTagsAdapter adapter = new LeoTagsAdapter(new String[30]);
        fragmentTagcloud.setAdapter(adapter);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_main_pop_);
        fragmentTagcloud.setAnimation(animation);
        animation.start();

        buttonPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MyViewandSixActivity.this, R.anim.scale_main_pop_);
                fragmentTagcloud.setAnimation(animation);
                animation.start();
            }
        });
    }
}
