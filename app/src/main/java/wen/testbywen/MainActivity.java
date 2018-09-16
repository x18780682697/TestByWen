package wen.testbywen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import wen.testbywen.aidl.Guard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), LocalService.class));
                startService(new Intent(getApplicationContext(), RemoteService.class));
                Toast.makeText(getApplicationContext(), "后台服务已经启动", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
