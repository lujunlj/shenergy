package com.sgnbs.energy.core.common.mapper;

import java.util.List;

public interface VoMapper<Vo,Dto> {
    Dto toDto(Vo vo);

    Vo toVo(Dto dto);

    List<Dto> toDto(List<Vo> voList);

    List <Vo> toVo(List<Dto> dtoList);
}
