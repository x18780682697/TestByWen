package wen.test.apkinstall;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import wen.test.BaseActivity;
import wen.testbywen.R;

public class TestInstallApkActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_install_apk);
    }

    public void onClickReqSystemInstall(View view) {
        ApkInstallExecutor.getInstance().installWithSystemInstaller(getTestApkFilePath());
    }

    private String getTestApkFilePath(){
        return Environment.getExternalStorageDirectory().getPath() + "/0files/test.apk";
    }

}