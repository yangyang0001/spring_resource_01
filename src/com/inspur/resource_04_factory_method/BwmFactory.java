package com.inspur.resource_04_factory_method;

import com.inspur.resource_03_factory.Bmw;
import com.inspur.resource_03_factory.Car;

/**
 * User: YANG
 * Date: 2019/5/20-15:25
 * Description: No Description
 */
public class BwmFactory implements MyFactory {
    @Override
    public Car getCar() {
        Car car = new Bmw();
        car.setName("宝马X6");
        car.setColor("棕色");
        return car;
    }
}
