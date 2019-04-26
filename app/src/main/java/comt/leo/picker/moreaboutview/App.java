package comt.leo.picker.moreaboutview;

import android.app.Application;
import android.content.Context;

/**
 * Created by leo
 * on 2019/4/26.
 */
public class App extends Application {
    private static App context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
