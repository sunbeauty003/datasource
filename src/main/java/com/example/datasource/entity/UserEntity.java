package com.example.datasource.entity;

import com.example.datasource.annotation.DataSource;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Data
@Table(name="user")
@Entity
@Proxy(lazy = false)
public class UserEntity {

    @Id  //标识为主键
    @GeneratedValue(generator="system-uuid")  //生成值所采用的生成器名称
    @GenericGenerator(name = "system-uuid", strategy = "uuid")  //代表是一个生成器，生成规则为uuid
    @Column(name = "id",columnDefinition = "char(36) comment 'id'")
    private String id;
    /**
     * 用户名
     */
    @Column(name="`username`",columnDefinition = "varchar(100) DEFAULT NULL COMMENT '姓名'")
    private String username;

    /**
     * 密码
     */
    @Column(name="`password`",columnDefinition = "varchar(100) DEFAULT NULL COMMENT '密码'")
    private String password;

    /**
     * 年龄
     */
    @Column(name="`age`",columnDefinition = "int(11) DEFAULT 0 COMMENT '年龄'")
    private Integer age;

    /**
     * 性别 1=男 2=女 其他=保密
     */
    @Column(name="`sex`",columnDefinition = "int(2) DEFAULT 0 COMMENT '性别'")
    private Integer sex;
}
