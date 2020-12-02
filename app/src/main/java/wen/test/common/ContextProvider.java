package wen.test.common;

import android.app.Activity;
import android.content.Context;

/**
 * Description
 *
 * @since 2020/12/2
 */
public class ContextProvider {

    public static Context sAppContext;
    public static Activity sActivityContext;

    public static Context getAppContext(){
        return sAppContext;
    }

    public static Activity getActivityContext(){
        return sActivityContext;
    }

}
