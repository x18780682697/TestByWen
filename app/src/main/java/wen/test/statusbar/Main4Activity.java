package wen.test.statusbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import wen.testbywen.R;

/**
 * 更改状态栏可见性，方案参见google官方文档：
 * https://developer.android.google.cn/training/system-ui/status
 */
public class Main4Activity extends AppCompatActivity {

    private final static String TAG = Main4Activity.class.getSimpleName();
    private int mOriginSystemUiState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mOriginSystemUiState = getWindow().getDecorView().getSystemUiVisibility();

    }

    public void onClickShowStatusBar(View view) {
        changeVisibility(true);
    }

    public void onClickHideStatusBar(View view) {
        changeVisibility(false);
    }

    private void changeVisibility(boolean isShow){
        View decorView = getWindow().getDecorView();
        int uiOptions = isShow ? mOriginSystemUiState : View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

}
