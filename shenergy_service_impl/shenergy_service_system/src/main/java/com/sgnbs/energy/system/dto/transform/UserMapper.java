package com.sgnbs.energy.system.dto.transform;

import com.sgnbs.energy.api.system.entity.UserVO;
import com.sgnbs.energy.core.common.mapper.VoMapper;
import com.sgnbs.energy.system.dto.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends VoMapper<UserVO, User> {

}