package com.sgnbs.energy.system.service;

import com.sgnbs.energy.api.system.entity.UserVO;
import com.sgnbs.energy.core.common.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IDEA
 * author: lujun
 * Date:2019/9/27
 * Time:15:30
 */
@Api(tags = "用户接口服务")
@RequestMapping("/user")
public interface UserService  {

    /**
     * 用户注册接口
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "用电用户注册信息接口")
    @ApiImplicitParam(paramType = "body", name = "user", dataType = "UserVO", required = true, value = "用电用户")
    BaseResponse<Object> register(@RequestBody UserVO user);


}
