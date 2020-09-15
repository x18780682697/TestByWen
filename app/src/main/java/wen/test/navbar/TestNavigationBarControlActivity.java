package wen.test.navbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import wen.test.BaseActivity;
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
        Window window = getWindow();
        View decorView = window.getDecorView();
        int newUiVisibility = decorView.getSystemUiVisibility();
        newUiVisibility |= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        newUiVisibility |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(newUiVisibility);
        window.setNavigationBarColor(Color.TRANSPARENT);
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
            default:break;
        }
    }
}
