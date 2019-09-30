package com.sgnbs.energy.system.service.impl;

import com.sgnbs.energy.api.system.entity.UserVO;
import com.sgnbs.energy.core.common.base.BaseApiService;
import com.sgnbs.energy.core.common.base.BaseResponse;
import com.sgnbs.energy.system.dto.User;
import com.sgnbs.energy.system.dto.transform.UserMapper;
import com.sgnbs.energy.system.service.UserService;
import com.sgnbs.energy.system.service.dao.UserDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IDEA
 * author: lujun
 * Date:2019/9/29
 * Time:10:00
 */
@RestController
@Service
public class UserServiceImpl extends BaseApiService<Object> implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper beeAnimalDVMapper;

    @Override
    public BaseResponse<Object> register(UserVO user) {
        User beeAnimalDTO = beeAnimalDVMapper.toDto(user);
        List<User> beeAnimalDTOS =  userDao.execute("select * from sys_user");
        List<User> beeAnimalDTOS2 = userDao.getSQLManager().select("user.select", User.class,beeAnimalDTO);
        userDao.insert(beeAnimalDTO);
        List<User> beeAnimalDTOS3 = userDao.selectByName(beeAnimalDTO.getName());
        return success(user);
    }
}
