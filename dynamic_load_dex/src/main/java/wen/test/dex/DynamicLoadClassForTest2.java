package wen.test.dex;

import wen.test.dex.interfaces.DynamicLoadClassInterface;

/**
 * 此类用于测试动态加载的类是否能正常加载dex中的其他类
 */
public final class DynamicLoadClassForTest2 implements DynamicLoadClassInterface {

    @Override
    public String getTestInfo(){
        return "DynamicLoadClassForTest2: 我被动态加载的类加载起来了";
    }

}
