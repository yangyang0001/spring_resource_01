package com.inspur.resource_05_factory_abstract;

/**
 * User: YANG
 * Date: 2019/5/20-16:43
 * Description: No Description
 */
public class AbstractFactoryTest {
    public static void main(String[] args){
        DefaultFactory defaultFactory = new DefaultFactory();
        System.out.println(defaultFactory.getCar("bmw"));
    }
}
