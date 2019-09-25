package com.sl.tackout.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by happy on 2019/8/30.
 */
@Data
public class CouponTable implements Serializable{
    private int cid;//我的优惠券id
    private int cvalue;//我的优惠券面额
    private String ccreatTime;//优惠券领取时间
    private String cendTime;//优惠券过期时间
    private int cstate;//优惠券状态（0过期，1可用，2不可用）
    private int uid;

    public CouponTable() {
    }

    public CouponTable(int cid, int cvalue, String ccreatTime, String cendTime, int cstate, int uid) {

        this.cid = cid;
        this.cvalue = cvalue;
        this.ccreatTime = ccreatTime;
        this.cendTime = cendTime;
        this.cstate = cstate;
        this.uid = uid;
    }

    public int getCid() {

        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCvalue() {
        return cvalue;
    }

    public void setCvalue(int cvalue) {
        this.cvalue = cvalue;
    }

    public String getCcreatTime() {
        return ccreatTime;
    }

    public void setCcreatTime(String ccreatTime) {
        this.ccreatTime = ccreatTime;
    }

    public String getCendTime() {
        return cendTime;
    }

    public void setCendTime(String cendTime) {
        this.cendTime = cendTime;
    }

    public int getCstate() {
        return cstate;
    }

    public void setCstate(int cstate) {
        this.cstate = cstate;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "CouponTable{" +
                "cid=" + cid +
                ", cvalue=" + cvalue +
                ", ccreatTime='" + ccreatTime + '\'' +
                ", cendTime='" + cendTime + '\'' +
                ", cstate=" + cstate +
                ", uid=" + uid +
                '}';
    }
}
