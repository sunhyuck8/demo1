package com.bhome.demo.dao;

import com.bhome.demo.dto.AppleMapperDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppleDAO {
    AppleMapperDTO selectApple();
}
