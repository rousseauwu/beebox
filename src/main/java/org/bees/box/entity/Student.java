package org.bees.box.entity;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Student implements Serializable {

    @NotNull(message = "name不能为空")
    private String name;
    private String sex;
    private int age;

    public Student() {
    }

    public Student(int age) {
        this.age = age;
    }

    public Student(@NotNull(message = "name不能为空") String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
