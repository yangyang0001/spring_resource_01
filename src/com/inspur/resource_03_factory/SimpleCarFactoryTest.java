package com.inspur.resource_03_factory;

/**
 * User: YANG
 * Date: 2019/5/20-14:57
 * Description: No Description
 */
public class SimpleCarFactoryTest {

    public static void main(String[] args){
        SimpleCarFactory simpleCarFactory = new SimpleCarFactory();
        Car car = simpleCarFactory.getCar("bmw");
        System.out.println(car);
    }
}
