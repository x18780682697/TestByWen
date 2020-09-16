package wen.test.navbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import wen.test.BaseActivity;
import wen.test.utils.LogUtils;
import wen.testbywen.R;

public class TestNavigationBarControlActivity extends BaseActivity implements View.OnClickListener {

    private int mOriginNavBarColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_navigation_bar_controll);

        findViewById(R.id.btn_test_recovery_nav_bar).setOnClickListener(this);
        findViewById(R.id.btn_test_set_nav_bar_color_red).setOnClickListener(this);
        findViewById(R.id.btn_test_set_nav_bar_transparent).setOnClickListener(this);
        findViewById(R.id.btn_test_get_nav_bar_height).setOnClickListener(this);
        mOriginNavBarColor = Color.GREEN;
        setNavBarColor(mOriginNavBarColor);
    }

    private void setOrigin(){
        setNavBarColor(mOriginNavBarColor);
    }

    private void setRed(){
        setNavBarColor(Color.RED);
    }

    private void setNavBarColor(int color){
        getWindow().setNavigationBarColor(color);
    }

    private void setTransParent(){
        // 布局适配导航栏，不延伸到导航栏
        findViewById(R.id.root_view).setFitsSystemWindows(true);
        Window window = getWindow();
        View decorView = window.getDecorView();
        int newUiVisibility = decorView.getSystemUiVisibility();
        newUiVisibility &= ~View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        newUiVisibility |= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        newUiVisibility |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        newUiVisibility &= ~View.SYSTEM_UI_FLAG_LOW_PROFILE;
        decorView.setSystemUiVisibility(newUiVisibility);
        window.setNavigationBarColor(Color.TRANSPARENT);
    }

    private void setHide(){
        // 布局适配导航栏，不延伸到导航栏
        findViewById(R.id.root_view).setFitsSystemWindows(true);
        Window window = getWindow();
        View decorView = window.getDecorView();
        int newUiVisibility = decorView.getSystemUiVisibility();
        newUiVisibility |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        newUiVisibility |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        newUiVisibility |= View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(newUiVisibility);
    }

    @SuppressLint("SetTextI18n")
    private void showNavBarHeight(){
        TextView tv = findViewById(R.id.tv_test_show_nav_bar_height);
        tv.setText(getNavBarHeight(this) + "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test_recovery_nav_bar:
                setOrigin();
                break;
            case R.id.btn_test_set_nav_bar_color_red:
                setRed();
                break;
            case R.id.btn_test_set_nav_bar_transparent:
                setTransParent();
                break;
            case R.id.btn_test_get_nav_bar_height:
                showNavBarHeight();
                break;
            case R.id.btn_test_set_nav_bar_hide:
                setHide();
                break;
            default:break;
        }
    }

    private int getNavBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height","dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        LogUtils.e("@@@zw", "nav bar height " + height);
        return height;
    }

}
