package wen.test.notification.delete;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import wen.test.utils.LogUtils;

public class NotificationDeleteReceiver extends BroadcastReceiver {

    private final static String TAG = NotificationDeleteReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        LogUtils.d(TAG, "onReceive...");
        LogUtils.d(TAG, "onReceive...action: " + intent.getAction());

    }
}