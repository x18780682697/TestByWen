package wen.test.apkinstall;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;

import androidx.core.content.FileProvider;

import java.io.File;
import java.util.List;

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

    public void installWithSystemInstaller(String filePath){
        LogUtils.d(TAG, "installWithSystemInstaller...");
        LogUtils.d(TAG, "installWithSystemInstaller...filePath: " + filePath);
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
        ComponentName systemInstaller = getSystemInstaller(intent);
        if (systemInstaller == null){
            LogUtils.d(TAG, "installWithSystemInstaller...not find valid system installer");
            return;
        }
        intent.setComponent(systemInstaller);
        sApp.startActivity(intent);
    }

    private ComponentName getSystemInstaller(Intent queryIntent){
        PackageManager pm = ContextProvider.getAppContext().getPackageManager();
        List<ResolveInfo> allApps = pm.queryIntentActivities(queryIntent, 0);
        ComponentName systemInstallerCom = null;
        for (ResolveInfo ri : allApps)
        {
            ActivityInfo activityInfo = ri.activityInfo;
            // 判定是否是系统安装器，如果是则立即使用系统安装器进行安装
            boolean isSystemInstaller = false;
            if (activityInfo.packageName.contains("packageinstaller"))
            {
                isSystemInstaller = true;
            }
            if (isSystemInstaller)
            {
                systemInstallerCom = new ComponentName(activityInfo.packageName, activityInfo.name);
                break;
            }
        }
        return systemInstallerCom;
    }

}
