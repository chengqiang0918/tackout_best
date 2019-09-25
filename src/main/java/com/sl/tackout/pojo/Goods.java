package com.sl.tackout.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by happy on 2019/8/24.
 */
@Data
public class Goods implements Serializable {
    private int gid;//商品id
    private String gname;//商品名称
    private double gprice;//商品价格
    private String ginfo;//商品信息
    private String gtype;//商品类型
    private String gimg;//商品图片
    private int gremainder;//商品余量

}
