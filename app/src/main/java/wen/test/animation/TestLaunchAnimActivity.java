package wen.test.animation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import wen.testbywen.R;

/**
 * overridePendingTransition方法使用注意事项：
 * https://blog.csdn.net/ID19870510/article/details/52886377
 */

public class TestLaunchAnimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        overridePendingTransition(R.anim.enter, R.anim.still);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_launch_anim);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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

}