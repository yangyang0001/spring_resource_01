package com.inspur.resource_01_proxy;

import java.lang.reflect.Proxy;

/**
 * User: YANG
 * Date: 2019/5/19-22:16
 * Description: No Description
 */
public class TestFindLove {

    public static void main(String[] args){
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        MeiPo meiPo = new MeiPo(new Yang());
        PersonInterface personInterface =
                (PersonInterface) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), Yang.class.getInterfaces(), meiPo);
        personInterface.findLove();
    }
}
