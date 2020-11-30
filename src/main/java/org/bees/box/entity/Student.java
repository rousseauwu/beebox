package org.bees.box.entity;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Student implements Serializable {

    @NotNull(message = "name不能为空")
    private String name;
    private String sex;

    public Student() {
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
}
