package com.sl.tackout.mapper;

import com.sl.tackout.pojo.BusinessTable;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by happy on 2019/8/21.
 */
@Mapper
public interface BusinessMapper {
    //通过商户登录名查找商户信息
    public BusinessTable findBusinessByLoginName(String businessName);

    //获取最大id
    public int findMaxBtId();

    //添加注册的用户
    public int addBt(BusinessTable businessTable);

    //通过用户名和密码查询是否有此用户
    public BusinessTable findBtBynp(String btName,String btPwd);
}
