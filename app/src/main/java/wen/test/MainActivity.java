package wen.test;

import android.app.ActivityOptions;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.Window;

import wen.test.animation.TestLaunchAnimActivity;
import wen.test.animation.TestLaunchAnim2Activity;
import wen.test.animation.TestLottieAnimActivity;
import wen.test.apkinstall.TestInstallApkActivity;
import wen.test.coloruse.TestAndroidColorClassActivity;
import wen.test.drawable.TestLimitDrawableAreaActivity;
import wen.test.javaio.TestJavaIoActivity;
import wen.test.keyevent.TestListenKeyEvent;
import wen.test.loaddex.TestDynamicLoadDexActivity;
import wen.test.navbar.TestNavigationBarControlActivity;
import wen.test.notification.TestNotificationSortActivity;
import wen.test.notification.TestShowNotificationActivity;
import wen.test.recycleview.TestItemDeleteAnimationActivity;
import wen.test.regex.TestRegexActivity;
import wen.test.statusbar.TestStatusBarActivity;
import wen.test.gituse.TestGitBranchActivity;
import wen.test.statusbar.TransparentStatusAndNavigationBarActivity;
import wen.test.textuse.CutTextIntoOneLineActivity;
import wen.testbywen.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_test_install_apk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TestInstallApkActivity.class));
            }
        });

        findViewById(R.id.btn_test_show_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TestNotificationSortActivity.class));
            }
        });

        findViewById(R.id.btn_test_regex).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TestRegexActivity.class));
            }
        });

        findViewById(R.id.btn_test_limit_drawable_area).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TestLimitDrawableAreaActivity.class));
            }
        });

        findViewById(R.id.btn_test_copy_file_with_aio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TestJavaIoActivity.class));
            }
        });

        findViewById(R.id.btn_test_listen_key_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TestListenKeyEvent.class));
            }
        });

        findViewById(R.id.btn_test_recycler_view_item_animation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TestItemDeleteAnimationActivity.class));
            }
        });

        // 测试Color类
        findViewById(R.id.btn_test_color_class).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TestAndroidColorClassActivity.class));
            }
        });

        // 测试导航栏
        findViewById(R.id.btn_test_nav_bar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TestNavigationBarControlActivity.class));
            }
        });

        // dex动态加载
        findViewById(R.id.btn_test_dynamic_load_dex).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TestDynamicLoadDexActivity.class));
            }
        });

        // 长文字缩略显示到一行
        findViewById(R.id.btn_test_cut_long_text_into_one_line).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), CutTextIntoOneLineActivity.class));
            }
        });

        // 透明状态栏和导航栏
        findViewById(R.id.btn_test_transparent_status_and_navigation_bar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TransparentStatusAndNavigationBarActivity.class));
            }
        });

        // 状态栏相关测试
        findViewById(R.id.btn_test_change_status_bar_visibility).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TestStatusBarActivity.class));
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
                startActivity(new Intent(v.getContext(), TestLaunchAnimActivity.class));
            }
        });

        // 测试启动动画2
        findViewById(R.id.btn_test_launch_animation_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TestLaunchAnim2Activity.class),
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

    @Override
    public void onClick(View v) {
        if (v == null){
            return;
        }
        int id  = v.getId();
        Class targetActivityClass = null;
        switch (id){
            case R.id.btn_test_lottie_anim:
                targetActivityClass = TestLottieAnimActivity.class;
                break;
            default:break;
        }
        if (targetActivityClass == null){
            return;
        }
        startActivity(new Intent(v.getContext(), targetActivityClass));
    }

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
