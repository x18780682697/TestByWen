package wen.test.navbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import wen.testbywen.R;

public class TestNavigationBarControlActivity extends AppCompatActivity implements View.OnClickListener {

    private int mOriginNavBarColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_navigation_bar_controll);

        findViewById(R.id.btn_test_set_nav_bar_color_origin).setOnClickListener(this);
        findViewById(R.id.btn_test_set_nav_bar_color_red).setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test_set_nav_bar_color_origin:
                setOrigin();
                break;
            case R.id.btn_test_set_nav_bar_color_red:
                setRed();
                break;
            default:break;
        }
    }
}
