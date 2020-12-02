package wen.test.common;

import android.app.Application;

/**
 * Description
 *
 * @since 2020/12/2
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ContextProvider.sAppContext = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ContextProvider.sAppContext = null;
    }
}
