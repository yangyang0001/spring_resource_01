package com.inspur.resource_04_factory_method;

import com.inspur.resource_03_factory.Audi;
import com.inspur.resource_03_factory.Car;

/**
 * User: YANG
 * Date: 2019/5/20-15:24
 * Description: No Description
 */
public class AudiFactory implements MyFactory {
    @Override
    public Car getCar() {
        Car car = new Audi();
        car.setName("奥迪A8");
        car.setColor("肃穆黑色");
        return car;
    }
}
