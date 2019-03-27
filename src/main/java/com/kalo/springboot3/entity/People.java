package com.kalo.springboot3.entity;

/**
 * @author Kalo
 * @create 2019-03-07 15:12
 */
public class People {

    private Integer id;
    private String pname;
    private String sex;
    private String phone;

    public People() {
    }

    public People(Integer id, String name, String sex, String phone) {
        this.id = id;
        this.pname = name;
        this.sex = sex;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return pname;
    }

    public void setName(String name) {
        this.pname = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
