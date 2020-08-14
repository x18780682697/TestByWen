package wen.testbywen;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import java.io.IOException;

import wen.test.animation.Main2Activity;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        overridePendingTransition(R.anim.enter, R.anim.still);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // 测试启动动画
        findViewById(R.id.btn_test_launch_animation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Main2Activity.class));
            }
        });

        // 设置状态栏图标为白色
        findViewById(R.id.btn_test_set_status_bar_icon_white).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLightStatusBar(getWindow(), false);
            }
        });

        // 设置状态栏图标为黑色
        findViewById(R.id.btn_test_set_status_bar_icon_black).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLightStatusBar(getWindow(), true);
            }
        });

    }

//    @Override
//    public void finish() {
//
//        super.finish();
//
////        overridePendingTransition(R.anim.still, R.anim.exit);
//
//    }

    public void setLightStatusBar(Window window, boolean lightStatusBar) {
        // 设置浅色状态栏时的界面显示
        View decor = window.getDecorView();
        int ui = decor.getSystemUiVisibility();
        if (lightStatusBar) {
            ui |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        } else {
            ui &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        }
        decor.setSystemUiVisibility(ui);
    }

}
