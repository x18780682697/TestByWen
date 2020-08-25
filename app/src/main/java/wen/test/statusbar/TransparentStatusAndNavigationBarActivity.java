package wen.test.statusbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import wen.testbywen.R;

public class TransparentStatusAndNavigationBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 透明状态栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 透明导航栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        getWindow().setStatusBarColor(blackColor);
//        getWindow().setNavigationBarColor(blackColor);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent_status_and_navigation_bar);
    }

    public void onClickShowTransparentBar(View view) {
        changeStatusBarAndNavigationBar(true);
    }

    public void onClickShowNormalBar(View view) {
        changeStatusBarAndNavigationBar(false);
    }

    private void changeStatusBarAndNavigationBar(boolean isTransparent){
        if (isTransparent){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }else{
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

}
