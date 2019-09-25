package com.sl.tackout.mapper;

import com.sl.tackout.pojo.PermissionTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by happy on 2019/8/22.
 */
@Mapper
public interface PermissionMapper {
    //查看当前用户的所有权限
    public List<PermissionTable> findAllPermissionByUna(String userName);
}
