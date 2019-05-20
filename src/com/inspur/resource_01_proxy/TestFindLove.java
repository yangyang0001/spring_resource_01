package com.inspur.resource_01_proxy;

import java.lang.reflect.Proxy;

/**
 * User: YANG
 * Date: 2019/5/20-10:54
 * Description: No Description
 */
public class TestFindLove {

    public static void main(String[] args){
        MeiPo meiPo = new MeiPo(new Yang());
        Class<?>[] interfaces = {PersonInterface.class};
        PersonInterface personInterface = (PersonInterface) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), interfaces, meiPo);
        personInterface.findLove();
    }
}
