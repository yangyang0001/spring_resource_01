package com.inspur.resource_09_prototype;

import java.util.Date;

/**
 * User: YANG
 * Date: 2019/5/20-23:24
 * Description: No Description
 */
public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        //浅Copy的模式,只对9中数据类型进行 赋值 8种基本类型 + String 类型
        Prototype prototype = new Prototype();
        prototype.setName("yang");
        prototype.setAge(18);
        prototype.getHobbies().add("足球");
        prototype.setBirthday(new Date());

        Prototype copy = (Prototype) prototype.clone();
        System.out.println(prototype.getBirthday() == copy.getBirthday());
        System.out.println(copy);

    }
}
