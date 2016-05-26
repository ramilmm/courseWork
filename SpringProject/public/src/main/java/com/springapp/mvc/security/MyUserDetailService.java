package com.springapp.mvc.security;

import mvc.common.UsersInfo;
import mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UsersInfo userInfo = userService.getByLogin(login);
        if (userInfo == null) throw new UsernameNotFoundException("User with name " + login + " not found");
        return new MyUserDetail(userInfo);
    }

}