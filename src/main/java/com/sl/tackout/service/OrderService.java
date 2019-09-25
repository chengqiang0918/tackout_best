package com.sl.tackout.service;

import com.sl.tackout.pojo.OrderTable;

import java.util.List;

/**
 * Created by happy on 2019/8/30.
 */
public interface OrderService {
    public List<OrderTable> findUserOrder(String userName);
}
