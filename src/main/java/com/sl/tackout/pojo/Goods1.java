package com.sl.tackout.pojo;

import lombok.Data;

@Data
public class Goods1 {
    private Integer gid;

    private String gname;

    private Double gprice;

    private String ginfo;

    private String gimg;
    private int bid;

    public Goods1() {
    }

    public Goods1(Integer gid, String gname, Double gprice, String ginfo, String gimg, int bid) {
        this.gid = gid;
        this.gname = gname;
        this.gprice = gprice;
        this.ginfo = ginfo;
        this.gimg = gimg;
        this.bid = bid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }

    public String getGinfo() {
        return ginfo;
    }

    public void setGinfo(String ginfo) {
        this.ginfo = ginfo;
    }

    public String getGimg() {
        return gimg;
    }

    public void setGimg(String gimg) {
        this.gimg = gimg;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

}
