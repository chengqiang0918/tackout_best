package com.sl.tackout.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by happy on 2019/8/29.
 */
@Data
public class Foods implements Serializable {
    private int fid;//食物id
    private String fname;//食物名称
    private int fnum;//食物数量
    private double funit_price;//食物单价

    public Foods() {
    }

    public Foods(int fid, String fname, int fnum, double funit_price) {

        this.fid = fid;
        this.fname = fname;
        this.fnum = fnum;
        this.funit_price = funit_price;
    }

    public int getFid() {

        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getFnum() {
        return fnum;
    }

    public void setFnum(int fnum) {
        this.fnum = fnum;
    }

    public double getFunit_price() {
        return funit_price;
    }

    public void setFunit_price(double funit_price) {
        this.funit_price = funit_price;
    }

    @Override
    public String toString() {
        return "Foods{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                ", fnum=" + fnum +
                ", funit_price=" + funit_price +
                '}';
    }
}
