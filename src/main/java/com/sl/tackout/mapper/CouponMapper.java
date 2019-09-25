package com.sl.tackout.mapper;

import com.sl.tackout.pojo.CouponTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by happy on 2019/8/30.
 */
@Mapper
public interface CouponMapper {
    //查优惠券最大id
    public int findMaxCid();
    //添加用户的优惠券
    public int addUserCoupon(CouponTable couponTable);

    //查找当前用户的所有优惠券
    public List<CouponTable> findAllUrCoupon(String userName);
}
