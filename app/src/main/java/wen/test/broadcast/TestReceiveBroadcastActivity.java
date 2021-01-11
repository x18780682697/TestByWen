package wen.test.broadcast;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.view.View;

import wen.test.BaseActivity;
import wen.testbywen.R;

public class TestReceiveBroadcastActivity extends BaseActivity {

    private BroadcastReceiver mDynamicBroadcast = new DynamicRegisterReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_receive_broadcast);

        onClickRegister(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        onClickUnregister(null);
    }

    public void onClickRegister(View view) {
        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        intentFilter.addDataScheme("package");

        registerReceiver(mDynamicBroadcast, intentFilter);
    }

    public void onClickUnregister(View view) {
        unregisterReceiver(mDynamicBroadcast);
    }
}