package wen.test.animation;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import wen.test.BaseActivity;
import wen.testbywen.R;

public class TestLottieAnimActivity extends BaseActivity {

    LottieAnimationView mAnimView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_lottie_anim);
        mAnimView = findViewById(R.id.view_test_lottie_anim);
//        mAnimView.setImageAssetsFolder();
    }

}
