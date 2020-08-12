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
import android.widget.Toast;

import java.io.IOException;

import wen.testbywen.aidl.Guard;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

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

        findViewById(R.id.btn_test_set_wallpaper).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    WallpaperManager wpm = (WallpaperManager) getSystemService(
                            Context.WALLPAPER_SERVICE);

                    if (wpm != null) {
//                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test_pic);
                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test_pic_2);
                        if (bitmap == null){
                            Log.i(TAG, "bitmap is null");
                            return;
                        }
//                        wpm.setBitmap(bitmap);
                        wpm.setBitmap(bitmap, null, true, WallpaperManager.FLAG_SYSTEM);
                        Log.i(TAG, "wallpaper not null");
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Failed to set wallpaper: " + e);
                }
            }
        });

    }
}
