package com.sl.tackout.service.impl;

import com.sl.tackout.mapper.PermissionMapper;
import com.sl.tackout.pojo.PermissionTable;
import com.sl.tackout.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by happy on 2019/8/22.
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<PermissionTable> findAllPermissionByUna(String userName) {
        List<PermissionTable> allPermissionByUna = permissionMapper.findAllPermissionByUna(userName);
        return allPermissionByUna;
    }
}
