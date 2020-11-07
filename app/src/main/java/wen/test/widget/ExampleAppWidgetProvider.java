package wen.test.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import wen.testbywen.R;

public class ExampleAppWidgetProvider extends AppWidgetProvider
{

    private static final String TAG = "ExampleAppWidget";

    // 启动ExampleAppWidgetService服务对应的action
    private final Intent EXAMPLE_SERVICE_INTENT =
            new Intent("android.appwidget.action.EXAMPLE_APP_WIDGET_SERVICE");
    // 更新 widget 的广播对应的action
    private final String ACTION_UPDATE_ALL = "com.skywang.widget.UPDATE_ALL";
    // 保存 widget 的id的HashSet，每新建一个 widget 都会为该 widget 分配一个 id。
    private static Set idsSet = new HashSet();

    // onUpdate() 在更新 widget 时，被执行，
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.d(TAG, "onUpdate(): appWidgetIds.length="+appWidgetIds.length);

        // 每次 widget 被创建时，对应的将widget的id添加到set中
        for (int appWidgetId : appWidgetIds) {
            idsSet.add(Integer.valueOf(appWidgetId));
        }
        updateAllAppWidgets(context, AppWidgetManager.getInstance(context), idsSet);
    }

    // 更新所有的 widget
    private void updateAllAppWidgets(Context context, AppWidgetManager appWidgetManager, Set set) {
        Log.d(TAG, "updateAllAppWidgets(): size="+set.size());
        // widget 的id
        int appID;
        // 迭代器，用于遍历所有保存的widget的id
        Iterator it = set.iterator();
        while (it.hasNext()) {
            appID = ((Integer)it.next()).intValue();
            // 获取 example_appwidget.xml 对应的RemoteViews
            RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.example_appwidget);
//            remoteView.setTextViewText(R.id.tv_gongli, CalendarUtil.getAllInfoHtml(Calendar.getInstance()));
//            remoteView.setOnClickPendingIntent(R.id.tv_gongli, getPendingIntent(context, R.id.tv_gongli));
            remoteView.setTextViewText(R.id.tv_test, "text has updated");
            // 更新 widget
            appWidgetManager.updateAppWidget(appID, remoteView);
        }
    }

}
