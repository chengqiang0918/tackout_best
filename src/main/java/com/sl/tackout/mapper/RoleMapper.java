package com.sl.tackout.mapper;

import com.sl.tackout.pojo.RoleTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by happy on 2019/8/28.
 */
@Mapper
public interface RoleMapper {
    //查看当前用户的角色是否有会员
    public List<RoleTable> findThisUrRole(String userName);
    //修改当前用户角色（购买会员）
    public int addMemberRole(String userName);
}
