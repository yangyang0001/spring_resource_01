package com.inspur.resource_09_prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: YANG
 * Date: 2019/5/20-23:21
 * Description: No Description
 */
public class Prototype implements Cloneable,Serializable {

    private static final long serialVersionUID = -1660493244717085183L;

    private String name;
    private int age;
    private List<String> hobbies = new ArrayList<String>();
    private Date birthday;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();//这种就是浅copy

        //这种序列化的方式就是深Copy的方式!
        Object object = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bos = new ByteArrayOutputStream(1024);
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);

            object = ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            try {
                if(bos != null){
                    bos.close();
                }
                if(oos != null){
                    oos.close();
                }
                if(bis != null){
                    bis.close();
                }
                if(ois != null){
                    ois.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return object;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                ", birthday=" + birthday +
                '}';
    }
}
