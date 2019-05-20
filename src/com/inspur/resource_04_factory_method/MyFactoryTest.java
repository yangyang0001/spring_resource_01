package com.inspur.resource_04_factory_method;

/**
 * User: YANG
 * Date: 2019/5/20-15:28
 * Description: No Description
 */
public class MyFactoryTest {

    public static void main(String[] args){

        //方法工厂模式
        MyFactory audiFactory = new AudiFactory();
        System.out.println(audiFactory.getCar());

        MyFactory bwmFactory = new BwmFactory();
        System.out.println(bwmFactory.getCar());

    }
}
