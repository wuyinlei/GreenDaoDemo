package com.renren.greendaodemo;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Administrator on 2016/12/1.
 *
 */

@Entity
public class StudentOne {

    @Id
    public Long id;

    public String name;
    public String age;
    public String number;
    public String score;
    @Generated(hash = 1197494893)
    public StudentOne(Long id, String name, String age, String number,
            String score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.number = number;
        this.score = score;
    }
    @Generated(hash = 1104814048)
    public StudentOne() {
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

}
