package wen.test.statusbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import wen.test.BaseActivity;
import wen.testbywen.R;

public class TransparentStatusAndNavigationBarActivity extends BaseActivity {

    int originStatusColor, originNavigationColor;
    int originVisibility;

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
        originStatusColor = getWindow().getStatusBarColor();
        originNavigationColor = getWindow().getNavigationBarColor();
        originVisibility = getWindow().getDecorView().getVisibility();

    }

    public void onClickShowTransparentBar(View view) {
        changeStatusBarAndNavigationBar(getWindow(), true);
    }

    public void onClickShowNormalBar(View view) {
        changeStatusBarAndNavigationBar(getWindow(),false);
    }

    private void changeStatusBarAndNavigationBar(Window window, boolean isTransparent){
        View decorView = window.getDecorView();
        if (isTransparent){

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            int newVisibility = decorView.getVisibility();
            newVisibility |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            newVisibility |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            newVisibility |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            newVisibility |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(newVisibility);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);

        }else{

            decorView.setSystemUiVisibility(originVisibility);
            window.setStatusBarColor(originStatusColor);
            window.setNavigationBarColor(originNavigationColor);

        }
    }

}
