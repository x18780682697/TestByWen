package wen.test.javaio;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import wen.test.BaseActivity;
import wen.test.utils.LogUtils;
import wen.testbywen.R;

public class TestJavaIoActivity extends BaseActivity {

    private final IIoCopyTester mAioCopyTester = new AioCopyTester();

    TextView        progressTv;
    ProgressBar     progressPb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_java_io);
        findViewById(R.id.btn_start_copy).setOnClickListener(mClickListener);
        progressTv = findViewById(R.id.tv_progress_desc);
        progressPb = findViewById(R.id.pb_progress_anim);
    }

   private final View.OnClickListener mClickListener = new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           switch (v.getId()){
               case R.id.btn_start_copy:
                   startCopyWithAioAsync();
                   break;
               default:break;
           }
       }

       private void startCopyWithAioAsync(){
           new Thread(new Runnable() {
               @Override
               public void run() {
                   startCopyWithAio();
               }
           }).start();
       }

       private void startCopyWithAio(){
           if (mAioCopyTester.isCoping()){
               return;
           }
           final String source = Environment.getExternalStorageDirectory()
                   .getAbsolutePath() + "/0files/AioCopyTestFile.dat";
           final String target = source + ".copied";
           mAioCopyTester.setListener(mCopyResultListener);
           mAioCopyTester.start(source, target);
       }

   };

    private final IIoCopyTester.ResultListener mCopyResultListener = new IIoCopyTester.ResultListener() {

        @Override
        public void onStart() {
            LogUtils.d(DEFAULT_TAG, "onStart");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressTv.setText("coping....");
                    progressPb.setVisibility(View.VISIBLE);
                }
            });
        }

        @Override
        public void onSuc() {
            LogUtils.d(DEFAULT_TAG, "onSuc");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressTv.setText("succeed....");
                    progressPb.setVisibility(View.GONE);
                }
            });
        }

        @Override
        public void onFail() {
            LogUtils.d(DEFAULT_TAG, "onFail");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressTv.setText("failed....");
                    progressPb.setVisibility(View.GONE);
                }
            });
        }
    };

}