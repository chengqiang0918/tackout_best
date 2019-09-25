package com.sl.tackout.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by happy on 2019/8/21.
 */
@Data
public class BusinessTable implements Serializable {
    private int businessId;//商家id
    private String businessName;//商家名称
    private String businessPwd;//商家密码
    private String businessAddress;//商家地址
    private String businessPhone;//商家电话
    private int businessState;//商家状态（0表示商家已注销，1表示正常营业，2表示商家已休息）
    private String businessInfo;//商家信息（简介）
    private String businessImg;//商家图片
    private String shopName;//商家店名

    public BusinessTable() {
    }

    public BusinessTable(int businessId, String businessName, String businessPwd, String businessAddress, String businessPhone, int businessState, String businessInfo, String businessImg, String shopName) {

        this.businessId = businessId;//商家id
        this.businessName = businessName;//商家账号
        this.businessPwd = businessPwd;//商家密码
        this.businessAddress = businessAddress;//商家地址
        this.businessPhone = businessPhone;//商家手机号
        this.businessState = businessState;//商家状态（0表示已下线，1表示正在营业，2表示已休息）
        this.businessInfo = businessInfo;//商家信息
        this.businessImg = businessImg;//商家图片
        this.shopName = shopName;//商家店铺名称
    }

    public int getBusinessId() {

        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessPwd() {
        return businessPwd;
    }

    public void setBusinessPwd(String businessPwd) {
        this.businessPwd = businessPwd;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public int getBusinessState() {
        return businessState;
    }

    public void setBusinessState(int businessState) {
        this.businessState = businessState;
    }

    public String getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(String businessInfo) {
        this.businessInfo = businessInfo;
    }

    public String getBusinessImg() {
        return businessImg;
    }

    public void setBusinessImg(String businessImg) {
        this.businessImg = businessImg;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return "BusinessTable{" +
                "businessId=" + businessId +
                ", businessName='" + businessName + '\'' +
                ", businessPwd='" + businessPwd + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                ", businessPhone='" + businessPhone + '\'' +
                ", businessState=" + businessState +
                ", businessInfo='" + businessInfo + '\'' +
                ", businessImg='" + businessImg + '\'' +
                ", shopName='" + shopName + '\'' +
                '}';
    }
}
