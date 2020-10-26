package com.danbro.springsecurity.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.danbro.springsecurity.demo.entity.UserFromDb;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 2020/10/26 16:40
 * @Author Danrbo
 */
@Repository
public interface UserMapper extends BaseMapper<UserFromDb> {
}
