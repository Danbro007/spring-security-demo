package com.danbro.springsecurity.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.danbro.springsecurity.demo.entity.UserFromDb;
import com.danbro.springsecurity.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname MyUserdetailsService
 * @Description TODO UserDetailsService 的实现类，来实现用户名和密码登录。
 * @Date 2020/10/26 16:06
 * @Author Danrbo
 */
@Service("userDetailsService")
public class MyUserdetailsService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<UserFromDb> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username",username);
        UserFromDb userFromDb = userMapper.selectOne(userQueryWrapper);
        if (userFromDb == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User(userFromDb.getUsername(),new BCryptPasswordEncoder().encode(userFromDb.getPassword()),authorityList);
    }
}
