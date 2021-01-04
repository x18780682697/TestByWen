package wen.test.notification;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.RemoteViews;

import wen.test.utils.LogUtils;
import wen.testbywen.R;

public class CancelImprovedSortNotificationService extends Service {
    public CancelImprovedSortNotificationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.e("@@zw", "...");
        startForeground(111, buildTmpEmptyNotification());
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                LogUtils.e("@@zw", "...stopForeground");
                stopForeground(true);
                stopSelf();
            }
        }, 1000);
        return super.onStartCommand(intent, flags, startId);
    }

    private Notification buildTmpEmptyNotification()
    {
        RemoteViews mContentView;
        mContentView = new RemoteViews(getApplicationContext().getPackageName(), R.layout.layout_tmp_notification);
        Notification.Builder builder = NotificationUtils.getBuilder(NotificationUtils.CHANNEL_DEFAULT);
        builder.setContent(mContentView);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        return builder.build();
    }

}