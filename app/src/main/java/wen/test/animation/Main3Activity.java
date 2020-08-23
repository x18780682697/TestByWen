package wen.test.animation;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.Window;

import wen.testbywen.R;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);

        // Main 打开 Main3, Main3的入场动画
        Transition enterAnim = new Fade().setDuration(5000);
        getWindow().setEnterTransition(enterAnim);
        // Main3 返回 Main，Main3的退场动画
        Transition returnAnim = new Slide(Gravity.RIGHT).setDuration(3000);
        getWindow().setReturnTransition(returnAnim);

        setContentView(R.layout.activity_main3);

    }

}