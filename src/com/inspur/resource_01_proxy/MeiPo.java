package com.inspur.resource_01_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * User: YANG
 * Date: 2019/5/19-22:15
 * Description: No Description
 */
public class MeiPo implements InvocationHandler {

    private PersonInterface targetPerson;

    public MeiPo(PersonInterface targetPerson) {
        this.targetPerson = targetPerson;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("meipo do something before ....");

        method.invoke(targetPerson, args);

        System.out.println("meipo do something after  ....");
        return null;
    }
}
