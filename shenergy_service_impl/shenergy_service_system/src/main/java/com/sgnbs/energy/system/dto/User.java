package com.sgnbs.energy.system.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;
import org.beetl.sql.core.annotatoin.UpdateTime;

import java.sql.Date;


@Data                                       // 提供getter setter toString 等方法
@FieldDefaults(level = AccessLevel.PRIVATE) // 属性默认都是private
@Table(name = "sys_user")                     // 实体类与表映射
public class User {

    //@AssignID 传入id的生成策略以自动生成序列，beetl默认提供了一个snowflake算法
    @AssignID("uuid")
    String id;
    int age;
    String name;

    @UpdateTime
    Date updateTime;

}