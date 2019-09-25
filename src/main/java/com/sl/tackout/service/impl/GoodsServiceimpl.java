package com.sl.tackout.service.impl;

import com.github.pagehelper.PageHelper;
import com.sl.tackout.mapper.GoodsMapper;
import com.sl.tackout.pojo.Goods;
import com.sl.tackout.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceimpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAll(int page, int rows) {
        PageHelper.startPage(page,rows);
        return goodsMapper.findAll();
    }

    @Override
    public int findcount(int cows) {
        int count=goodsMapper.findcount();
        return count%cows==0?count/cows:count/cows+1 ;
    }
    @Override
    public Goods xiangqin(int gid) {
        return goodsMapper.xiangqin(gid);
    }

    @Override
    public List<Goods> chaxun(String name) {
        return goodsMapper.chaxun(name);
    }


}
