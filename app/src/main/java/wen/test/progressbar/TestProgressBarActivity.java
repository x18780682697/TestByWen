package wen.test.progressbar;

import android.os.Bundle;
import android.widget.ProgressBar;

import wen.test.BaseActivity;
import wen.testbywen.R;

public class TestProgressBarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_progerss_bar);

        startCutDown();
    }

    private void startCutDown() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final ProgressBar pb = findViewById(R.id.pb_gradual);
                final int[] left = new int[]{100};
                while (left[0] >= 0)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                           pb.setProgress(100 - left[0]);
                        }
                    });
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    left[0] -= 1;
                }
            }
        }).start();
    }


}