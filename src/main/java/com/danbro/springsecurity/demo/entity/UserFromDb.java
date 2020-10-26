package com.danbro.springsecurity.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname User
 * @Description TODO
 * @Date 2020/10/26 16:31
 * @Author Danrbo
 */
@Data
@TableName("user")
public class UserFromDb {
    private Integer id;
    private String username;
    private String password;
}
