package com.inspur.resource_10_serializable;

import java.io.*;

/**
 * User: YANG
 * Date: 2019/5/21-10:13
 * Description: No Description
 * 测试序列化和反序列化必须在不同的JVM中进行,否则测试失败！
 *      序列化的重点是:    1.必须要有不同的JVM间进行交互数据的一种形式!
 *      这里抽取出不同的方法,进行j间断测试!
 * 结论:  只有堆中的数据区才能被序列化,序列化的是对象的状态,非类的状态!
 *      1.静态变量不能被序列化
 *      2.父类如果没有实现Serializeable,内部的属性不能被序列化
 */
public class SerializableTest {

    public static void main(String[] args) {
//        Person person = new Person();
//        person.setName("yang");
//        person.setPassword("123456");
//        person.setAge(22);
//
//        System.out.println(person);
//
//        serializeObject(person);
        readSerializeObject();
    }


    public static void serializeObject(Object object){
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
//            bos = new ByteArrayOutputStream(1024);
//            oos = new ObjectOutputStream(bos);
            fos = new FileOutputStream("E:\\person.obj");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(object);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void readSerializeObject(){
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
//            bis = new ByteArrayInputStream(bos.toByteArray());
//            ois = new ObjectInputStream(bis);
            fis = new FileInputStream("E:\\person.obj");
            ois = new ObjectInputStream(fis);
            Person seriPerson = (Person) ois.readObject();
            System.out.println("seriPerson:" + seriPerson);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
