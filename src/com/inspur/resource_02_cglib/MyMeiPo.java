package com.inspur.resource_02_cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * User: YANG
 * Date: 2019/5/20-13:21
 * Description: No Description
 */
public class MyMeiPo implements MethodInterceptor {

    private YangYang targetObject;

    public Object getInstance() {
        Object object = null;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(this);
        object = enhancer.create();
        return object;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("my meipo find love before ...");
        //一定是调用父类中的方法,这里 一定要 invokeSuper()
        methodProxy.invokeSuper(obj, objects);
        System.out.println("my meipo find love after  ...");
        return null;
    }

    public MyMeiPo(YangYang targetObject) {
        this.targetObject = targetObject;
    }
}
