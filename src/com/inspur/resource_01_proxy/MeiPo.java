package com.inspur.resource_01_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * User: YANG
 * Date: 2019/5/20-10:56
 * Description: No Description
 */
public class MeiPo implements InvocationHandler {

    private Object targetObject;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("meipo find love before ....");
        method.invoke(targetObject, args);
        System.out.println("meipo find love after  ....");
        return null;
    }

    public MeiPo(Object targetObject) {
        this.targetObject = targetObject;
    }
}
