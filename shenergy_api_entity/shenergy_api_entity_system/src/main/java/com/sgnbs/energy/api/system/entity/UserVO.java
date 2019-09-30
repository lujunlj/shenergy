package com.sgnbs.energy.api.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

/**
 * Created with IDEA
 * author: lujun
 * Date:2019/9/29
 * Time:10:02
 */
@Data
//@ApiModel(value = "用户VO",description = "用户信息")
public class UserVO {

//    @ApiModelProperty(name="id",dataType = "String")
    public String id;
//    @ApiModelProperty(name="年龄",dataType = "Integer",required = true)
    public int age;
//    @ApiModelProperty(name="姓名",dataType = "String",required = true)
    public String name;
//    @ApiModelProperty(name="更新时间",dataType = "Date",required = false)
    public Date updateTime;
}
