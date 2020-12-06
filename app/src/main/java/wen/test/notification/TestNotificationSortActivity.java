package wen.test.notification;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;

import wen.test.BaseActivity;
import wen.testbywen.R;

public class TestNotificationSortActivity extends BaseActivity implements View.OnClickListener {

    public final static long FIXED_TIME = System.currentTimeMillis() - 1000 * 60 * 60 * 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_notification_sort);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        Notification.Builder builder = NotificationUtils.getBuilder(NotificationUtils.CHANNEL_DEFAULT);
        builder.setWhen(FIXED_TIME);
        switch (viewId){
            case R.id.default_notification:{
                builder.setContentText("default");
                showNotification(viewId, builder.build());
            }
            break;
            case R.id.important_colorized_notification:{
                builder = NotificationUtils.getBuilder(NotificationUtils.CHANNEL_DEFAULT);
                builder.setContentText("colorized");
                builder.setColorized(true);
                builder.setColor(getColor(android.R.color.holo_red_dark));
                Notification notification = builder.build();
                notification.flags |= Notification.FLAG_FOREGROUND_SERVICE;
                showNotification(viewId, notification);
            }
            break;
            case R.id.high_chn_notification:{
                builder = NotificationUtils.getBuilder(NotificationUtils.CHANNEL_HIGH);
                builder.setContentText("high channel");
                builder.setWhen(FIXED_TIME);
                Notification notification = builder.build();
                showNotification(viewId, notification);
            }
            break;
            case R.id.default_chn_notification:{
                builder = NotificationUtils.getBuilder(NotificationUtils.CHANNEL_DEFAULT);
                builder.setContentText("default channel");
                builder.setWhen(FIXED_TIME);
                Notification notification = builder.build();
                showNotification(viewId, notification);
            }
            break;
            case R.id.low_chn_notification:{
                builder = NotificationUtils.getBuilder(NotificationUtils.CHANNEL_LOW);
                builder.setContentText("low channel");
                builder.setWhen(FIXED_TIME);
                Notification notification = builder.build();
                showNotification(viewId, notification);
            }
            break;
            case R.id.high_pri_notification:{
                builder = NotificationUtils.getBuilder(NotificationUtils.CHANNEL_DEFAULT);
                builder.setContentText("high priority");
                builder.setWhen(FIXED_TIME);
                builder.setPriority(Notification.PRIORITY_HIGH);
                Notification notification = builder.build();
                showNotification(viewId, notification);
            }
            break;
            case R.id.default_pri_notification:{
                builder = NotificationUtils.getBuilder(NotificationUtils.CHANNEL_DEFAULT);
                builder.setContentText("default priority");
                builder.setWhen(FIXED_TIME);
                builder.setPriority(Notification.PRIORITY_DEFAULT);
                Notification notification = builder.build();
                showNotification(viewId, notification);
            }
            break;
            case R.id.low_pri_notification:{
                builder = NotificationUtils.getBuilder(NotificationUtils.CHANNEL_DEFAULT);
                builder.setContentText("low priority");
                builder.setWhen(FIXED_TIME);
                builder.setPriority(Notification.PRIORITY_LOW);
                Notification notification = builder.build();
                showNotification(viewId, notification);
            }
            break;
            case R.id.early_one_hour_notification:{
                builder.setContentText("早1个小时的通知");
                builder.setWhen(FIXED_TIME - 1000 * 60 * 60);
                Notification notification = builder.build();
                showNotification(viewId, notification);
            }
            break;
            case R.id.late_one_hour_notification:{
                builder.setContentText("晚1个小时的通知");
                builder.setWhen(FIXED_TIME + 1000 * 60 * 60);
                Notification notification = builder.build();
                showNotification(viewId, notification);
            }
            break;
            default:break;
        }
    }

    private void showNotification(int notificationId, Notification notification){
        NotificationUtils.getManager().notify(notificationId, notification);
    }

}