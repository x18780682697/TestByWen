package wen.test.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import wen.testbywen.MainActivity;
import wen.testbywen.R;

/**
 * overridePendingTransition方法使用注意事项：
 * https://blog.csdn.net/ID19870510/article/details/52886377
 */

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        overridePendingTransition(R.anim.enter, R.anim.still);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });

        Log.e("Main2Activity", "taskId: " + getTaskId());

    }

    @Override
    public void finish() {

        super.finish();

        overridePendingTransition(R.anim.still, R.anim.exit);

    }
}