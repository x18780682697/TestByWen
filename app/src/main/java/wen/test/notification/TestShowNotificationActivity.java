package wen.test.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import wen.test.BaseActivity;
import wen.test.notification.delete.NotificationDeleteReceiver;
import wen.testbywen.R;

public class TestShowNotificationActivity extends BaseActivity {

    private final static String CHANNEL = "test channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_notification);
    }

    public void onclickShowOne(View view) {
        showOneNotification(1, "notification content " + 1);
    }

    public void onclickShowOneWithListenDelete(View view)
    {
        int id = 1;
        showOneNotification(id, "notification with listen delete", createDeleteIntent(id));
    }

    public void onclickShowMany(View view) {
        final int startId = 10;
        // 每隔一定时间发出1条通知，一共发出5条
        for (int diff = 0; diff < 5; diff++){
            final int finalDiff = diff;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    showOneNotification(startId + finalDiff, "notification content " + startId);
                }
            };
            getWindow().getDecorView().postDelayed(task, 100 * diff);
        }
    }

    private void showOneNotification(int id, String content){
        showOneNotification(id, content, null);
    }

    private void showOneNotification(int id, String content, PendingIntent deleteIntent){
        Context context = getApplicationContext();
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            manager.createNotificationChannel(new NotificationChannel(CHANNEL, CHANNEL, NotificationManager.IMPORTANCE_DEFAULT));
            builder = new Notification.Builder(context, CHANNEL);
        }else{
            builder = new Notification.Builder(context);
        }

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("test notification title");
        builder.setContentText(content);

        if (deleteIntent != null)
        {
            builder.setDeleteIntent(deleteIntent);
        }

        Notification notification = builder.build();

        try {
            manager.notify(id, notification);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private PendingIntent createDeleteIntent(int id){
        Intent intent = new Intent();
        intent.setAction("com.test.notification.delete");
        intent.setPackage(getPackageName());
        intent.setComponent(new ComponentName(getApplicationContext(), NotificationDeleteReceiver.class));
        return PendingIntent.getBroadcast(getApplicationContext(), id, intent, PendingIntent.FLAG_ONE_SHOT);
    }

}