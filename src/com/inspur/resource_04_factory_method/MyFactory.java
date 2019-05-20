package com.inspur.resource_04_factory_method;

import com.inspur.resource_03_factory.Car;

/**
 * 工厂的接口定义了 所有工厂的标准
 */
public interface MyFactory {

    //符合汽车上路的标准
    public Car getCar();

}
