package com.team.houes.houesbacka.service.impl;

import com.team.houes.houesbacka.entity.Users;
import com.team.houes.houesbacka.entity.UsersExample;
import com.team.houes.houesbacka.mapper.UsersMapper;
import com.team.houes.houesbacka.service.UsersService;
import com.team.houes.houesbacka.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UsersServiceimpl
 * @Description
 * @Author HU
 * @Date 2020/2/25 21:37
 */
@Service
public class UsersServiceimpl implements UsersService {

    @Autowired(required = false)
    private UsersMapper usersMapper;
    @Override
    public int userRegg(Users users) {
        //使用md5工具类对密码进行加密后存储到数据库
        //使用步骤:1.导入md5工具类
        // 2.调用md5工具类的方法进行加密
      users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users Login(String username,String password ) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria=usersExample.createCriteria();
        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> list=usersMapper.selectByExample(usersExample);
        if(list!=null && list.size()==1){
            return list.get(0);
        }else {
            return null;
        }
    }
}
