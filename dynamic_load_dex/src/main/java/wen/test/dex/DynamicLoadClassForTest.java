package wen.test.dex;

import wen.test.dex.interfaces.DynamicLoadClassInterface;

public final class DynamicLoadClassForTest implements DynamicLoadClassInterface {

    @Override
    public String getTestInfo(){
        return "DynamicLoadClassForTest: 动态加载成功" + "\n"
                + new DynamicLoadClassForTest2().getTestInfo();
    }

}
