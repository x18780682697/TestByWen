package wen.test.textuse;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import wen.test.BaseActivity;
import wen.testbywen.R;

public class ShowHtmlInTextViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_html_in_text_view);

        TextView tv = findViewById(R.id.tv_test);
        // 换行来自HTML中的<p>和</p>标签，无需换行则需要去掉这俩标签
        tv.setText(Html.fromHtml("<p><strong>BLACK CHRISTMAS</strong>! Tears And Deaths Rocks Nollywood</p>"));

    }

}