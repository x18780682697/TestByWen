package wen.test.statusbar;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import wen.testbywen.R;

/**
 * 更改状态栏可见性，方案参见google官方文档：
 * https://developer.android.google.cn/training/system-ui/status
 */
public class TestStatusBarActivity extends AppCompatActivity {

    private final static String TAG = TestStatusBarActivity.class.getSimpleName();
    private int mOriginSystemUiState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // 去titleBar和toolBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

        setContentView(R.layout.activity_main4);

        // 设置隐藏状态栏，优先级高于setSystemUiVisibility方式
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mOriginSystemUiState = getWindow().getDecorView().getSystemUiVisibility();

    }

    public void onClickShowStatusBar(View view) {
        changeVisibility(true);
    }

    public void onClickHideStatusBar(View view) {
        changeVisibility(false);
    }

    private void changeVisibility(boolean isShow){

        // 此方式优先于setSystemUiVisibility方式
        // 因此设置状态栏前需要先清除此方式设置的状态栏隐藏
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View decorView = getWindow().getDecorView();
        int uiOptions = isShow ? mOriginSystemUiState : View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

}
