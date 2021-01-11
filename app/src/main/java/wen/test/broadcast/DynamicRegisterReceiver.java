package wen.test.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import wen.test.utils.LogUtils;

public class DynamicRegisterReceiver extends BroadcastReceiver {

    private final static String TAG = DynamicRegisterReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        Toast.makeText(context, action, Toast.LENGTH_LONG).show();
        LogUtils.d(TAG, "onReceive..." + action);

    }

}