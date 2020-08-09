package wen.testbywen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import wen.testbywen.aidl.Guard;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.iv_test_animation);
    }

    public void onClickTest(View view) {

    }

    public void onClickHide(View view) {

        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setFillAfter(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 0, 1, 0,
                0.5f * mImageView.getWidth(), 0.5f * mImageView.getHeight());
        scaleAnimation.setDuration(3000);
        scaleAnimation.setFillAfter(true);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(3000);
        animationSet.setFillAfter(true);
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);

        mImageView.clearAnimation();
        mImageView.startAnimation(animationSet);

    }

    public void onClickShow(View view) {

        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setFillAfter(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1,
                0.5f * mImageView.getWidth(), 0.5f * mImageView.getHeight());
        scaleAnimation.setDuration(3000);
        scaleAnimation.setFillAfter(true);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(3000);
        animationSet.setFillAfter(true);
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);

        mImageView.clearAnimation();
        mImageView.startAnimation(animationSet);

    }

}
