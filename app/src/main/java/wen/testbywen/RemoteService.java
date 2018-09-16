package wen.testbywen;


import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import wen.testbywen.aidl.Guard;

public class RemoteService extends Service {

    private MyBinder mBinder;
    //private final static int GRAY_SERVICE_ID = 1002;

    @Override
    public IBinder onBind(Intent intent) {
        if (mBinder == null)
            mBinder = new MyBinder();
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 在RemoteService运行后,我们对LocalService进行绑定。 把优先级提升为前台优先级
        this.bindService(new Intent(RemoteService.this, LocalService.class),
                connection, Context.BIND_ABOVE_CLIENT);

        @SuppressWarnings("deprecation") Notification notification = new Notification(R.mipmap.ic_launcher,
                "安全服务启动中", System.currentTimeMillis());
//        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent,
//                0);
//        notification.setLatestEventInfo(this, "安全服务", "安全服务...", pendingIntent);
        startForeground(startId, notification);
        return START_STICKY;
    }

    private class MyBinder extends Guard.Stub {

        @Override
        public void doSomething() {
            Log.i("TAG", "绑定成功!");
        }

    }

    private ServiceConnection connection = new ServiceConnection() {

        /**
         * 在终止后调用,我们在杀死服务的时候就会引起意外终止,就会调用onServiceDisconnected
         * 则我们就得里面启动被杀死的服务,然后进行绑定
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("TAG", "LocalService被杀死了");
            Intent remoteService = new Intent(RemoteService.this,
                    LocalService.class);
            RemoteService.this.startService(remoteService);
            RemoteService.this.bindService(new Intent(RemoteService.this,
                    LocalService.class), connection, Context.BIND_ABOVE_CLIENT);
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("TAG", "LocalService链接成功!");
            if (mBinder != null)
                mBinder.doSomething();
        }
    };

}
