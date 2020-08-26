package wen.test.textuse;

import android.util.Log;
import android.widget.TextView;

public class TextDealUtil {

    private static final String TAG = TextDealUtil.class.getSimpleName();

    /**
     * 裁剪文件名到一行
     * 文件名形如“我是1个文件名的.doc”江北缩略为“我是1个文...doc”
     *
     * 参考资料：
     * https://blog.csdn.net/u012230055/article/details/98766690
     * 无效方法：
     * 1.https://blog.csdn.net/f409031mn/article/details/88778108
     * 2.https://blog.csdn.net/qq_30552993/article/details/51789199
     */
    public static String cutFileNameIntoOneLine(TextView textView, String targetText, String cutFileNameSuffix){
        String resultText = targetText;
        // 无需裁剪
        if (couldDisplayInOneLine(textView, targetText)){
            return resultText;
        }
        // 二分法查找裁剪位置
        int start = 0, end = targetText.length() - 1;
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
        Log.e(TAG, "textView width: " + textView.getWidth());
        Log.e(TAG, "cut text width: " + measureTextWidthInTextView(textView, resultText));
        return resultText;
    }

    private static boolean couldDisplayInOneLine(TextView textView, String targetText){
        return measureTextWidthInTextView(textView, targetText) <= textView.getWidth();
    }

    private static int measureTextWidthInTextView(TextView textView, String targetText){
        return (int) textView.getPaint().measureText(targetText);
    }

}
