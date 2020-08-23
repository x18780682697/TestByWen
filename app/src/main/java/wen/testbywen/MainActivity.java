package wen.testbywen;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Window;

import wen.test.animation.Main2Activity;
import wen.test.animation.Main3Activity;
import wen.test.statusbar.Main4Activity;
import wen.test.git.TestGitBranchActivity;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        overridePendingTransition(R.anim.enter, R.anim.still);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // 状态栏相关测试
        findViewById(R.id.btn_test_change_status_bar_visibility).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Main4Activity.class));
            }
        });

        // 测试Git分支
        findViewById(R.id.btn_test_git_branch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TestGitBranchActivity.class));
            }
        });

        // 测试启动动画
        findViewById(R.id.btn_test_launch_animation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Main2Activity.class));
            }
        });

        // 测试启动动画2
        findViewById(R.id.btn_test_launch_animation_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Main3Activity.class),
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                                v, "shared_view").toBundle());
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
