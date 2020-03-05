package com.team.houes.houesbacka.service;

import com.team.houes.houesbacka.entity.Users;

public interface UsersService {
    public int userRegg(Users users);

    //实现登入的方法
    public Users Login(String username,String password);

}
