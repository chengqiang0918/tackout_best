package com.sl.tackout.service.impl;

import com.sl.tackout.mapper.OrderMapper;
import com.sl.tackout.pojo.OrderTable;
import com.sl.tackout.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by happy on 2019/8/30.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;


    @Override
    public List<OrderTable> findUserOrder(String userName) {
        List<OrderTable> orderTableList = orderMapper.findUserOrder(userName);
        return orderTableList;
    }
}
