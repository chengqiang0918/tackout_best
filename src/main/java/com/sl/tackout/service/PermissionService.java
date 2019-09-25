package com.sl.tackout.service;

import com.sl.tackout.pojo.PermissionTable;

import java.util.List;

/**
 * Created by happy on 2019/8/22.
 */
public interface PermissionService {
    public List<PermissionTable> findAllPermissionByUna(String userName);
}
