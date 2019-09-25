package com.sl.tackout.service;
import com.sl.tackout.pojo.Goods;

import java.util.List;

public interface GoodsService {
    public List<Goods> findAll(int page, int rows);
    public int findcount(int cows);
    public Goods xiangqin(int gid);
    public List<Goods> chaxun(String name);
}
