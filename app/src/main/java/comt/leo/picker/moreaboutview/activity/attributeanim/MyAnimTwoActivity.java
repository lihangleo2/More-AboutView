package comt.leo.picker.moreaboutview.activity.attributeanim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.utils.UIUtil;

/**
 * Created by leo
 * on 2019/1/8.
 * <p>
 * 搜索动画只在 图片区域内。
 */
public class MyAnimTwoActivity extends AppCompatActivity {
    private ImageView image;
    private ImageView image_red;
    private ImageView image_blue;
    private RelativeLayout relative;
    private RelativeLayout relative_search;


    private Animation rotateSAnimation;
    private Animation rotateNAnimation;

    private int canGoWith;
    private int canGoHeight;


    private int transw;
    private int transh;

    private int tempW;
    private int tempH;

    private AnimatorSet animSet;
    private Random random;

    private ObjectAnimator transX;
    private ObjectAnimator transY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animtwo);
        image = findViewById(R.id.image);
        image_red = findViewById(R.id.image_red);
        image_blue = findViewById(R.id.image_blue);
        relative = findViewById(R.id.relative);
        relative_search = findViewById(R.id.relative_search);


        rotateSAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_s);
        image_red.startAnimation(rotateSAnimation);

        rotateNAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_n);
        image_blue.startAnimation(rotateNAnimation);

        /*
         * 算出搜索圆圈自身大小，减去自身大小，保证圆圈不出界。
         * */
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        relative_search.measure(w, h);
        int viewHeight = relative_search.getMeasuredHeight();
        int viewWidth = relative_search.getMeasuredWidth();

        //图片是fitcenter横屏满屏，得到宽度算出高度。设置relative的区域。即是随机搜索区域
        int with = UIUtil.getWidth(MyAnimTwoActivity.this);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.otherwoman, null);
        int height = with * bitmap.getHeight() / bitmap.getWidth();
        RelativeLayout.LayoutParams reParams = (RelativeLayout.LayoutParams) relative.getLayoutParams();
        reParams.height = height;


        canGoWith = UIUtil.getWidth(MyAnimTwoActivity.this) - viewWidth;
        canGoHeight = height - viewHeight;


        random = new Random();
        transw = random.nextInt(canGoWith);
        transh = random.nextInt(canGoHeight);

        //下次要移动的点。
        tempW = transw;
        tempH = transh;
        transX = ObjectAnimator.ofFloat(relative_search, "translationX", 0f, transw);
        transY = ObjectAnimator.ofFloat(relative_search, "translationY", 0f, transh);


        animSet = new AnimatorSet();
        animSet.play(transX).with(transY);
        animSet.setDuration(200);
        animSet.start();

        animSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

                transw = random.nextInt(canGoWith);
                transh = random.nextInt(canGoHeight);

                transX = ObjectAnimator.ofFloat(relative_search, "translationX", tempW, transw);
                transY = ObjectAnimator.ofFloat(relative_search, "translationY", tempH, transh);
                animSet.setStartDelay(1000);
                animSet.play(transX).with(transY);
                animSet.setDuration(200);
                animSet.start();

                //暂时保存好上个点的记录，用于下次动画
                tempW = transw;
                tempH = transh;
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}
