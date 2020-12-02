package wen.test.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

import wen.test.BaseActivity;
import wen.testbywen.R;

public class TestShowNotificationActivity extends BaseActivity {

    private final static String CHANNEL = "test channel";
    private final static String GROUP = "test group";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_notification);
    }

    public void onclickShowOne(View view) {
        showOneNotification(CHANNEL, 1, GROUP, "notification content " + 1);
    }

    public void onclickShowMany(View view) {
        final int startId = 10;
        // 每隔一定时间发出1条通知，一共发出5条
        for (int diff = 0; diff < 5; diff++){
            final int finalDiff = diff;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    showOneNotification(CHANNEL, startId + finalDiff, GROUP, "notification content " + startId);
                }
            };
            getWindow().getDecorView().postDelayed(task, 100 * diff);
        }
    }

    private void showOneNotification(String channel, int id, String group, String content){
        Context context = getApplicationContext();
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            manager.createNotificationChannel(new NotificationChannel(channel, channel, NotificationManager.IMPORTANCE_DEFAULT));
            builder = new Notification.Builder(context, channel);
        }else{
            builder = new Notification.Builder(context);
        }

        RemoteViews view = new RemoteViews(getPackageName(), R.layout.activity_notification_custom);
        builder.setContent(view);

//        builder.setContentTitle("test notification title");
//                builder.setContentText(content);

        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(Notification.PRIORITY_MAX)
                .setWhen(System.currentTimeMillis());
        try {
            manager.notify(id, null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}