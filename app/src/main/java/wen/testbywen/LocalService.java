package wen.testbywen;

import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

public class LocalService extends Service {

    private final static String TAG = "@@LocalService";
    private MyBinder mBinder;

    @Override
    public IBinder onBind(Intent intent) {
        if (mBinder == null)
            mBinder = new MyBinder();

        return mBinder;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.bindService(new Intent(LocalService.this, RemoteService.class),
                connection, Context.BIND_ABOVE_CLIENT);

        @SuppressWarnings("deprecation") Notification notification = new Notification(R.mipmap.ic_launcher,
                "安全服务启动中", System.currentTimeMillis());
//        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent,
//                0);
//        notification.setLatestEventInfo(this, "安全服务", "安全服务...", pendingIntent);
        startForeground(startId, notification);

        return START_STICKY;
    }

    private class MyBinder extends wen.testbywen.aidl.Guard.Stub {

        @Override
        public void doSomething() {
            Log.i("TAG", "绑定成功!");
            Intent localService = new Intent(LocalService.this,
                    RemoteService.class);
            LocalService.this.startService(localService);
            LocalService.this
                    .bindService(new Intent(LocalService.this,
                                    RemoteService.class), connection,
                            Context.BIND_ABOVE_CLIENT);
        }

    }

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("TAG", "RemoteService被杀死了");
            Intent localService = new Intent(LocalService.this,
                    RemoteService.class);
            LocalService.this.startService(localService);
            LocalService.this
                    .bindService(new Intent(LocalService.this,
                                    RemoteService.class), connection,
                            Context.BIND_ABOVE_CLIENT);
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("TAG", "RemoteService链接成功!");
            Log.d(TAG, "onServiceConnected: service is " + service.toString());
            if (mBinder != null){
                mBinder.doSomething();
                Log.d(TAG, "onServiceConnected: mBinder is " + mBinder.toString());
            }else{
                Log.d(TAG, "onServiceConnected: mBinder is null");
            }
        }
    };

}
