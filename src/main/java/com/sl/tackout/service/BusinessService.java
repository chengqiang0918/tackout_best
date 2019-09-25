package com.sl.tackout.service;

import com.sl.tackout.pojo.BusinessTable;

/**
 * Created by happy on 2019/8/23.
 */
public interface BusinessService {
    public BusinessTable findBusinessByLoginName(String businessName);

    public int findMaxBtId();

    public boolean addBt(BusinessTable businessTable);

    public boolean findBtBynp(String btName,String btPwd);
}
