package com.inspur.resource_05_factory_abstract;

import com.inspur.resource_03_factory.Car;

/**
 * User: YANG
 * Date: 2019/5/20-16:37
 * Description: No Description
 */
public class DefaultFactory extends AbstractFactory {

    private AbstractFactory abstractFactory = new AudiFactory();

    @Override
    public Car getCar() {
        return abstractFactory.getCar();
    }
}
