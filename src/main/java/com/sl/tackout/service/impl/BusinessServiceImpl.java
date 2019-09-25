package com.sl.tackout.service.impl;

import com.sl.tackout.mapper.BusinessMapper;
import com.sl.tackout.pojo.BusinessTable;
import com.sl.tackout.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by happy on 2019/8/23.
 */
@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;
    @Override
    public BusinessTable findBusinessByLoginName(String businessName) {
        BusinessTable business = businessMapper.findBusinessByLoginName(businessName);

        return business;
    }

    @Override
    public int findMaxBtId() {
        int maxBtId = businessMapper.findMaxBtId();
        return maxBtId;
    }

    @Override
    public boolean addBt(BusinessTable businessTable) {
        int count = businessMapper.addBt(businessTable);
        return count>0?true:false;
    }

    @Override
    public boolean findBtBynp(String btName, String btPwd) {
        BusinessTable bt = businessMapper.findBtBynp(btName, btPwd);
        return bt!=null?true:false;
    }
}
