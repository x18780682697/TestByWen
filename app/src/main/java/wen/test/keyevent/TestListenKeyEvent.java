package wen.test.keyevent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import wen.test.BaseActivity;
import wen.testbywen.R;

public class TestListenKeyEvent extends BaseActivity {

    TextView                        mKeyNameTv;
    HomeAndRecentKeyListener        mKeyListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_listen_key_event);

        mKeyNameTv = findViewById(R.id.tv_key_name);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerKeyListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unRegisterKeyListener();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onPress("back");
    }

    private void registerKeyListener(){
        if (mKeyListener == null){
            mKeyListener = new HomeAndRecentKeyListener();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        registerReceiver(mKeyListener, filter);
    }

    private void unRegisterKeyListener(){
        unregisterReceiver(mKeyListener);
    }

    private void onPress(String keyName){
        toast(keyName);
        if (mKeyNameTv == null){
            return;
        }
        mKeyNameTv.setText(keyName);
    }

    private class HomeAndRecentKeyListener extends BroadcastReceiver{

        public static final String SYSTEM_DIALOG_REASON_KEY         = "reason";
        public static final String SYSTEM_DIALOG_REASON_HOME_KEY    = "homekey";

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null){
                return;
            }
            if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
                String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
                if (reason != null && reason.equals(SYSTEM_DIALOG_REASON_HOME_KEY)) {
                   onPress("home");
                }
            }
        }

    }

}
