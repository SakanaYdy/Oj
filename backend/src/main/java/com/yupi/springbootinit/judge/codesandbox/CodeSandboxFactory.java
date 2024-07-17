package com.yupi.springbootinit.judge.codesandbox;

import com.yupi.springbootinit.judge.codesandbox.Impl.ExampleCodeSandbox;
import com.yupi.springbootinit.judge.codesandbox.Impl.RemoteCodeSandbox;
import com.yupi.springbootinit.judge.codesandbox.Impl.ThirdPartyCodeSandbox;

/**
 * 静态代码沙箱工厂
 */
public class CodeSandboxFactory {

    public static CodeSandbox newInstance(String type){
        if(type == null) return new ExampleCodeSandbox();
//        CodeSandBoxEnum.getEnumByValue()
        switch (type){
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }

}
