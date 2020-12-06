package wen.test.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import wen.test.common.ContextProvider;
import wen.testbywen.R;

public class NotificationUtils {

    public final static String CHANNEL_HIGH = "high";
    public final static String CHANNEL_DEFAULT = "default";
    public final static String CHANNEL_LOW = "low";
    public final static String CHANNEL_MIN = "min";

    public static void createChannel(String channelId){
        int importance = Integer.MIN_VALUE;
        switch (channelId) {
            case CHANNEL_HIGH:
                importance = NotificationManager.IMPORTANCE_HIGH;
                break;
            case CHANNEL_DEFAULT:
                importance = NotificationManager.IMPORTANCE_DEFAULT;
                break;
            case CHANNEL_LOW:
                importance = NotificationManager.IMPORTANCE_LOW;
                break;
            case CHANNEL_MIN:
                importance = NotificationManager.IMPORTANCE_MIN;
                break;
            default:break;
        }
        if (importance == Integer.MIN_VALUE){
            throw new RuntimeException("invalid input");
        }else{
            NotificationChannel channel = new NotificationChannel(channelId, channelId, importance);
            getManager().createNotificationChannel(channel);
        }
    }

    public static Notification.Builder getBuilder(String channelId){
        Context context = ContextProvider.getAppContext();
        Notification.Builder builder;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            createChannel(channelId);
            builder = new Notification.Builder(context, channelId);
        }else{
            builder = new Notification.Builder(context);
        }
        builder.setContentTitle("test notification")
                .setSmallIcon(R.mipmap.ic_launcher);
        return builder;
    }

    public static NotificationManager getManager(){
        return (NotificationManager) ContextProvider.getAppContext()
                .getSystemService(Context.NOTIFICATION_SERVICE);
    }

}
