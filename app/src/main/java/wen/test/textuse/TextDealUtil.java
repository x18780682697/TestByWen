package wen.test.textuse;

import android.util.Log;
import android.widget.TextView;

import wen.test.utils.LogUtils;

public class TextDealUtil {

    private static final String TAG = TextDealUtil.class.getSimpleName();

    /**
     * 裁剪文件名到一行
     * 文件名形如“我是1个文件名的.doc”江北将被为“我是1个（...）(名的.doc)”
     * ...表示splitStr, 名的.doc表示leftTextNum
     */
    public static String cutFileNameIntoOneLine(TextView textView, java.lang.String targetText, String splitStr, int leftTextNum){
        String resultText = targetText;
        // 无需裁剪，直接展示
        if (couldDisplayInOneLine(textView, targetText)){
            LogUtils.d(TAG, "not need to cut!");
            return resultText;
        }
        // 1行显示不下，但是字符太少，不能满足leftTextNum的要求，直接缩略
        if (targetText.length() < leftTextNum){
            LogUtils.e(TAG, "none enough text to display!");
            textView.setSingleLine();
            return resultText;
        }
        String cutFileNameSuffix = splitStr + targetText.substring(targetText.length() - leftTextNum);
        // 至少保证后缀外还能显示2个字符,否则直接缩略
        if (!couldDisplayInOneLine(textView, cutFileNameSuffix + "tt")){
            LogUtils.e(TAG, "none enough view space to display!");
            textView.setSingleLine();
            return resultText;
        }
        // 二分法查找裁剪位置
        int start = 0, end = targetText.length() - 1 -leftTextNum;
        int middle = (start + end) / 2;
        resultText = targetText.substring(0, middle) + cutFileNameSuffix;
        while (start < end && middle != start && middle != end){
            if (couldDisplayInOneLine(textView, resultText)){
                start = middle;
            }else{
                end = middle - 1;
            }
            middle = (start + end) / 2;
            resultText = targetText.substring(0, middle) + cutFileNameSuffix;
        }
//			Log.e(TAG, "textView width: " + textView.getWidth());
//			Log.e(TAG, "cut text width: " + measureTextWidthInTextView(textView, resultText));
        return resultText;
    }

    private static boolean couldDisplayInOneLine(TextView textView, String targetText){
        return measureTextWidthInTextView(textView, targetText) <= textView.getWidth();
    }

    private static int measureTextWidthInTextView(TextView textView, String targetText){
        return (int) textView.getPaint().measureText(targetText);
    }

}
