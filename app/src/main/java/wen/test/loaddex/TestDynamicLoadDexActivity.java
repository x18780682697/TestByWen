package wen.test.loaddex;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dalvik.system.DexClassLoader;
//import wen.test.dex.interfaces.DynamicLoadClassInterface;
import wen.testbywen.R;

public class TestDynamicLoadDexActivity extends AppCompatActivity {

    final String                    TAG = TestDynamicLoadDexActivity.class.getSimpleName();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dynamic_load_dex);

//        try {
//            DynamicLoadClassInterface dynamicLoadClassInterface = tryLoadDex();
//            TextView tv = findViewById(R.id.tv_test);
//            tv.setText("以下是从dex动态获取的数据: \n" + dynamicLoadClassInterface.getTestInfo());
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }

//    private DynamicLoadClassInterface tryLoadDex() {
//        String dexInstallDir = Environment.getExternalStorageDirectory().getPath() + "/0files";
//        String dexPath = dexInstallDir + "/classes.dex";
//        DexClassLoader dexClassLoader = new DexClassLoader(dexPath, dexPath, dexInstallDir,
//                getApplicationContext().getClassLoader());
//        Class<?> testClass = null;
//        try {
//            testClass = dexClassLoader.loadClass("wen.test.dex.DynamicLoadClassForTest");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (testClass != null) {
//                return (DynamicLoadClassInterface)testClass.newInstance();
//            }
//        } catch (IllegalAccessException | InstantiationException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
