package com.inspur.resource_03_factory;

/**
 * User: YANG
 * Date: 2019/5/20-14:49
 * Description: No Description
 */
public class SimpleCarFactory {

    public Car getCar(String carName){
        Car car = null;
        String classPrefix = "com.inspur.resource_03_factory.";
        String lastCarName = classPrefix + carName.substring(0,1).toUpperCase() + carName.substring(1);
        try {
            Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(lastCarName);
            car = (Car) clazz.newInstance();
            if(carName.equalsIgnoreCase("audi")){
                car.setName("奥迪A8");
                car.setColor("肃穆黑色");
            } else if (carName.equalsIgnoreCase("bmw")){
                car.setName("宝马X6");
                car.setColor("棕色");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return car;
    }
}
