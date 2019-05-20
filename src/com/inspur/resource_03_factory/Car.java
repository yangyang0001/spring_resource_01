package com.inspur.resource_03_factory;

/**
 * User: YANG
 * Date: 2019/5/20-14:46
 * Description: No Description
 */
public abstract class Car {

    public String name;
    public String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
