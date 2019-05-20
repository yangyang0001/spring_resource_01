package com.inspur.resource_06_singleton;

/**
 * User: YANG
 * Date: 2019/5/20-17:08
 * Description: No Description
 * 最经典的单例模式!
 * 问题：
 *  1.调用Singleton的静态方法,SingletonHolder是否会初始化
 *      如果静态方法中引用了 SingletonHolder中的静态变量就会进行初始化,否则不初始化!
 */
public class Singleton {

    static {
        System.out.println("Singleton static block invoked ...");
    }

    private Singleton(){}

    private static class SingletonHolder{
        static {
            System.out.println("SingletonHolder static block invoked ...");
        }
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static void doSomething(){
        System.out.println("do something .....");
    }
}
