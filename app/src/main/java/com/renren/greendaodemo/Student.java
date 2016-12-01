package com.renren.greendaodemo;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2016/12/1.
 *
 */

@Entity
public class Student {

    @Id
    public Long id;

    public String name;
    public String age;
    public String number;
    public String score;


    public String address;

    @Generated(hash = 513330921)
    public Student(Long id, String name, String age, String number, String score,
            String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.number = number;
        this.score = score;
        this.address = address;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getScore() {
        return this.score;
    }
    public void setScore(String score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", number='" + number + '\'' +
                ", score='" + score + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
