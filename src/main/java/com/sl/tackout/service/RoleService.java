package com.sl.tackout.service;

import com.sl.tackout.pojo.RoleTable;

import java.util.List;

/**
 * Created by happy on 2019/8/28.
 */
public interface RoleService {
    public List<RoleTable> findThisUrRole(String userName);
    public boolean addMemberRole(String userName);
}
