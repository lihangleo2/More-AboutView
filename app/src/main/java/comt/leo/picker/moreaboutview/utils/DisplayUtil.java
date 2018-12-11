package comt.leo.picker.moreaboutview.utils;

import android.content.Context;

/**
 * Created by lihang on 2017/11/22.
 */

public class DisplayUtil {
    public static int dp2px(Context context, float dpValue) {
        if (context == null) return (int) (dpValue * 1.5f + 0.5f);
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
