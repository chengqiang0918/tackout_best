package com.sl.tackout.service;

import com.sl.tackout.pojo.CouponTable;

import java.util.List;

/**
 * Created by happy on 2019/8/30.
 */
public interface CouponService {

    public boolean addUserCoupon(CouponTable couponTable);
    public int findMaxCid();
    public List<CouponTable> findAllUrCoupon(String userName);
}
