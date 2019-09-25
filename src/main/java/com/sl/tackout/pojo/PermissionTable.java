package com.sl.tackout.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by happy on 2019/8/21.
 */
@Data
public class PermissionTable implements Serializable {//权限表只针对用户
    private int perId;//权限id
    private String perName;//权限名称
    private String pmenuUrl;//权限地址

    @Override
    public String toString() {
        return "PermissionTable{" +
                "perId=" + perId +
                ", perName='" + perName + '\'' +
                ", pmenuUrl='" + pmenuUrl + '\'' +
                '}';
    }

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public String getPmenuUrl() {
        return pmenuUrl;
    }

    public void setPmenuUrl(String pmenuUrl) {
        this.pmenuUrl = pmenuUrl;
    }

    public PermissionTable(int perId, String perName, String pmenuUrl) {

        this.perId = perId;
        this.perName = perName;
        this.pmenuUrl = pmenuUrl;
    }

    public PermissionTable() {

    }
}
