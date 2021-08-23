package com.it.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2021/8/22
 */
@Entity // 标记该pojo和数据库建立映射关系
@Table(name = "tb_user") // 标记要连接的数据表
public class User implements Serializable {

    @Id // 标记为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 标记使用主键自增策略
    private Integer id;//主键id
    @Column(name = "username") // 如果数据表列名与实体类属性名一致，可以不写name="username"
    private String username;//用户名
    @Column
    private String password;//密码
    @Column
    private String name;//姓名
    @Column
    private Integer age;//年龄
    @Column
    private Integer sex;//性别 1男性，2女性
    @Column
    private Date birthday; //出生日期
    @Column
    private Date created; //创建时间
    @Column
    private Date updated; //更新时间
    @Column
    private String note;//备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
