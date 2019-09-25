package com.sl.tackout.service.impl;

import com.sl.tackout.mapper.CouponMapper;
import com.sl.tackout.pojo.CouponTable;
import com.sl.tackout.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by happy on 2019/8/30.
 */
@Service
public class CouponServiceImpl implements CouponService{
    @Autowired
    private CouponMapper couponMapper;
    @Override
    public boolean addUserCoupon(CouponTable couponTable) {
        int count = couponMapper.addUserCoupon(couponTable);
        return count>0?true:false;
    }

    @Override
    public int findMaxCid() {
        int maxCid = couponMapper.findMaxCid();
        return maxCid;
    }

    @Override
    public List<CouponTable> findAllUrCoupon(String userName) {
        List<CouponTable> allUrCoupon = couponMapper.findAllUrCoupon(userName);
        return allUrCoupon;
    }
}
