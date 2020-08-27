package wen.test.textuse;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import wen.testbywen.R;

public class CutTextIntoOneLineActivity extends AppCompatActivity {

    final String TAG = CutTextIntoOneLineActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut_text_into_one_line);

        final TextView textView = (TextView) findViewById(R.id.tv_test);
        Log.e(TAG, "text width: " + textView.getPaint().measureText(textView.getText().toString()));

        textView.post(new Runnable() {
            @Override
            public void run() {
                LinearLayout testCaseContainer = findViewById(R.id.ll_test_cut_result);

                String[] testCaseArray = {
                        "12648948439384utsjdfaksdjfhasdf9fwerwedfkjasdhfkasjdhfkajsdhfaskdjhfaskdfjasdjfkl;asdjfasqk.acb",
                        "1264kdfsdjfasqk.acb",
                        "126484utsjdfaksdjfhasdf9fwerwedfkjdfasdfasdfasdfasdhfkasjdhfk8cb.dcox",
                        "12中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人",
                };

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(0, 0, 0, 0);

                for (String testCase: testCaseArray){
                    TextView originTv = new TextView(getApplicationContext());
                    originTv.setText("before cut: ");
                    testCaseContainer.addView(originTv, layoutParams);

                    TextView originTextTv = new TextView(getApplicationContext());
                    originTextTv.setText(testCase);
                    testCaseContainer.addView(originTextTv, layoutParams);

                    TextView cutTv = new TextView(getApplicationContext());
                    cutTv.setText("after cut: ");
                    testCaseContainer.addView(cutTv, layoutParams);

                    TextView cutTextTv = new TextView(getApplicationContext());
                    cutTextTv.setPaddingRelative(0, 0, 0, 0);
                    cutTextTv.setBackgroundResource(android.R.color.transparent);
                    cutTextTv.setText(TextDealUtil.cutFileNameIntoOneLine(textView, testCase, "...", 5));
                    testCaseContainer.addView(cutTextTv, layoutParams);

                    View splitView = new View(getApplicationContext());
                    testCaseContainer.addView(splitView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));
                }

            }
        });

    }



}
