package wen.test.thirdcall;

import android.content.Intent;
import android.os.Bundle;

import wen.test.BaseActivity;
import wen.test.utils.LogUtils;
import wen.testbywen.R;

public class TestThirdCallActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_third_call);

        Intent intent = getIntent();
        LogUtils.e(DEFAULT_TAG, "intent content is: " + intent.toString());

    }
}
