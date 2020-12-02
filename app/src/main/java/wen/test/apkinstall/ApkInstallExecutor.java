package wen.test.apkinstall;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import androidx.core.content.FileProvider;

import java.io.File;

import wen.test.common.ContextProvider;
import wen.test.utils.LogUtils;

/**
 * Description
 *
 * @since 2020/12/2
 */
public class ApkInstallExecutor {

    public final static String TAG = ApkInstallExecutor.class.getSimpleName();
    public final static ApkInstallExecutor sInstance = new ApkInstallExecutor();

    private ApkInstallExecutor(){}

    public static ApkInstallExecutor getInstance(){
        return sInstance;
    }

    public void install(String filePath){
        LogUtils.d(TAG, "install...");
        LogUtils.d(TAG, "install...filePath: " + filePath);
        File apkFile = new File(filePath);
        Context sApp = ContextProvider.getActivityContext();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(sApp, sApp.getPackageName() + ".fileprovider", apkFile);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        }
        if (sApp.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            sApp.startActivity(intent);
        }
    }

}
