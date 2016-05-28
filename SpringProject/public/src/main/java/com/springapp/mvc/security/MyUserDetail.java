package com.springapp.mvc.security;

import mvc.common.UsersInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetail implements UserDetails {

    /**
     * запись о пользователе из БД
     */
    private UsersInfo usersInfo;

    public MyUserDetail(UsersInfo userInfo) {
        this.usersInfo = userInfo;
    }

    /**
     * @return коллекция прав доступа пользователя
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(usersInfo.getRole()));
        return grantedAuthorities;
    }

    /**
     * hash пароля пользователя
     */
    @Override
    public String getPassword() {
        return usersInfo.getHash_pass();
    }

    /**
     * Логин (имя) пользователя
     */
    @Override
    public String getUsername() {
        return usersInfo.getLogin();
    }

    public String getName() { return usersInfo.getName(); }

    public String getRole() { return  usersInfo.getRole(); }
    /**
     * @return флаг, что срок действия аккаунта еще не истек, он активен
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return флаг, что пользователь не заблокирован администраторами сайта
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return флаг, что срок действия пароля еще не истек, он активен
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return флаг, что пользователь включен и подтвержден
     */
    @Override
    public boolean isEnabled() {
        return usersInfo.getActive();
    }

    public UsersInfo getUserInfo() {
        return usersInfo;
    }

    public void setUserInfo(UsersInfo userInfo) {
        this.usersInfo = userInfo;
    }
}