package com.sl.tackout.service;

import com.sl.tackout.pojo.UserTable;

/**
 * Created by happy on 2019/8/21.
 */
public interface UserService {
    public UserTable findUserByLoginName(String userName);
    public int findMaxUserId();
    public boolean addUser(UserTable userTable);
    public boolean updateUserInfo(UserTable userTable);
    public boolean updateUserAddress(String userAddress,String userName);

}
