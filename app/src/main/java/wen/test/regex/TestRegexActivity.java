package wen.test.regex;

import android.os.Bundle;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import wen.test.BaseActivity;
import wen.test.utils.LogUtils;
import wen.testbywen.R;

public class TestRegexActivity extends BaseActivity {

    private final static String TAG = TestRegexActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_regex);
    }

    public void onClick(View view) {
        String testStr = "aaaaaaaaaa<city>default city</city>bbbbbbbbbbbbb" +
                "cccccccccccccc<model>default model</model>dddddddddddddd" +
                "eeeeeeeeeeeeeeeee<number>default number</number>ffffffffffffffff" +
                "gggggggggggggggggggg<nickname>default nickname</nickname>hhhhhhhhhhhhhhhhhhhh";
        replace(testStr);
    }

    public String replace(String neededReplaceStr)
    {
        LogUtils.d(TAG, "replace...");
        LogUtils.d(TAG, "replace...neededReplaceStr: " + neededReplaceStr);
        Pattern pattern = Pattern.compile("<(.*?)>(.*?)</(.*?)>");
        Matcher matcher = pattern.matcher(neededReplaceStr);
        String replacedStr = neededReplaceStr;
        if (matcher.find())
        {
            String target = matcher.group();
            LogUtils.d(TAG, "replace..." + target);
        }
        LogUtils.d(TAG, "replace...replacedStr: " + replacedStr);
        return replacedStr;
    }

}