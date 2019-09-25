package com.sl.tackout.service.impl;

import com.sl.tackout.mapper.RoleMapper;
import com.sl.tackout.pojo.RoleTable;
import com.sl.tackout.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by happy on 2019/8/28.
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleTable> findThisUrRole(String userName) {
        List listUrRole = roleMapper.findThisUrRole(userName);
        return listUrRole;
    }

    @Override
    public boolean addMemberRole(String userName) {
            int count = roleMapper.addMemberRole(userName);
            return count>0?true:false;
    }
}
