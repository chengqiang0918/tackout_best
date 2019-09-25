package com.sl.tackout.service.impl;

import com.sl.tackout.mapper.UserMapper;
import com.sl.tackout.pojo.UserTable;
import com.sl.tackout.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by happy on 2019/8/21.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserTable findUserByLoginName(String userName) {
        UserTable userByLoginName = userMapper.findUserByLoginName(userName);
        return userByLoginName;
    }

    @Override
    public int findMaxUserId() {
        int maxUserId = userMapper.findMaxUserId();
        return maxUserId;
    }

    @Override
    public boolean addUser(UserTable userTable) {
        int count = userMapper.addUser(userTable);
        return count>0?true:false;
    }

    @Override
    public boolean updateUserInfo(UserTable userTable) {
        int count = userMapper.updateUserInfo(userTable);
        return count>0?true:false;
    }

    @Override
    public boolean updateUserAddress(String userAddress, String userName) {
        int count = userMapper.updateUserAddress(userAddress, userName);
        return count>0?true:false;
    }



}
