package com.sgnbs.energy.system.service.dao;

import com.sgnbs.energy.system.dto.User;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

/**
 * Created with IDEA
 * author: lujun
 * Date:2019/9/29
 * Time:9:57
 */
public interface UserDao extends BaseMapper<User> {
    List<User> selectByName(String name);
}
