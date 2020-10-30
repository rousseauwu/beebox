package org.bees.box.entity;


import javax.validation.constraints.NotNull;

public class Student {

    @NotNull(message = "name不能为空")
    private String name;
    private String sex;

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
