package com.sl.tackout.mapper;

import com.sl.tackout.pojo.OrderTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by happy on 2019/8/30.
 */
@Mapper
public interface OrderMapper {
    //查看当前用户的订单
    public List<OrderTable> findUserOrder(String userName);
}
