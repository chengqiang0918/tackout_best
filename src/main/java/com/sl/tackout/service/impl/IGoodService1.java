package com.sl.tackout.service.impl;

import com.sl.tackout.mapper.GoodMapper1;
import com.sl.tackout.pojo.Goods1;
import com.sl.tackout.service.GoodService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IGoodService1 implements GoodService1 {
    @Autowired
    private GoodMapper1 goodMapper1;
    @Override
    public List<Goods1> loadAll() {
        return goodMapper1.loadAll();
    }

    @Override
    public boolean addGoods1(Goods1 goods1) {
        int count=goodMapper1.addGoods1(goods1);
        return count>0?true:false;
    }

    @Override
    public boolean deleteGoods1(int gid) {
       int count= goodMapper1.deleteGoods1(gid);
        return count>0?true:false;
    }

    @Override
    public Goods1 loadById1(int gid) {
        Goods1 goods1=goodMapper1.loadById1(gid);
        return goods1;
    }

    @Override
    public boolean updateGoods1(Goods1 goods) {
        int count=goodMapper1.updateGoods1(goods);
        return count>0?true:false;
    }

    @Override
    public List<Goods1> loadAllShanXuan() {
        return goodMapper1.loadAllShanXuan();
    }

    @Override
    public List<Goods1> loadAllShanXuan2() {
        return goodMapper1.loadAllShanXuan2();
    }

    @Override
    public List<Goods1> loadAllShanXuan3() {
        return goodMapper1.loadAllShanXuan3();
    }

    @Override
    public List<Goods1> loadAllShanXuan4() {
        return goodMapper1.loadAllShanXuan4();
    }

    @Override
    public List<Goods1> loadAllShanXuan5() {
        return goodMapper1.loadAllShanXuan5();
    }

    @Override
    public List<Goods1> moHuChaXunGoods(String sql) {
        List<Goods1> mohugoods = goodMapper1.muHuChaXunGoods(sql);
        return mohugoods;
    }

    @Override
    public boolean deleteplGoods(List<Integer> ids) {
        int count=goodMapper1.deleteplGoods(ids);
        System.out.println(count);
        return count>0?true:false;

    }


}
