package wen.test.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import wen.test.utils.LogUtils;

public class StaticRegisterReceiver extends BroadcastReceiver {

    private final static String TAG = StaticRegisterReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        LogUtils.d(TAG, "onReceive..." + intent.getAction());

    }

}