package wen.test.coloruse;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import wen.test.BaseActivity;
import wen.testbywen.R;

public class TestAndroidColorClassActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_android_color_class);


        findViewById(R.id.btn_test_change_alpha_of_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int baseColor = Color.parseColor("#237237");

                EditText editText = findViewById(R.id.et_alpha);
                float originAlpha = Float.parseFloat(editText.getText().toString());
                int alpha = (int) (0xFF * originAlpha);
                int red = Color.red(baseColor);
                int green = Color.green(baseColor);
                int blue = Color.blue(baseColor);
                int mixedColor = Color.argb(alpha, red, green, blue);

                findViewById(R.id.btn_test_color_content).setBackgroundColor(mixedColor);
            }
        });

    }
}
