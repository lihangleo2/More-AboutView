package comt.leo.picker.moreaboutview.toast;

/**
 * Created by Leo on 2018/9/4.
 * 自定义Toast
 */

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import comt.leo.picker.moreaboutview.App;
import comt.leo.picker.moreaboutview.R;


public class MyToast {
    /**
     * 展示toast==LENGTH_SHORT
     *
     * @param msg
     */
    public static void show(String msg) {
        show(msg, Toast.LENGTH_SHORT);
    }

    /**
     * 展示toast==LENGTH_LONG
     *
     * @param msg
     */
    public static void showLong(String msg) {
        show(msg, Toast.LENGTH_LONG);
    }

    public static void show(String massage, int show_length) {
        Context context = App.getContext();
        //使用布局加载器，将编写的toast_layout布局加载进来
        View view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
        //获取ImageView
        //获取TextView
        TextView title = (TextView) view.findViewById(R.id.toast_tv);
        //设置显示的内容
        title.setText(massage);
        final Toast toast = new Toast(context);
        //设置Toast要显示的位置，水平居中并在底部，X轴偏移0个单位，Y轴偏移70个单位，
        toast.setGravity(Gravity.CENTER, 0, 0);
        //设置显示时间
        toast.setView(view);
        toast.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                toast.cancel();
            }
        }, show_length);

    }
}

