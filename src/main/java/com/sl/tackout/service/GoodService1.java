package com.sl.tackout.service;


import com.sl.tackout.pojo.Goods1;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface GoodService1 {
    public List<Goods1> loadAll();

    public boolean addGoods1(Goods1 goods1);

    public boolean deleteGoods1(int gid);

    public Goods1 loadById1(int gid);

    public boolean updateGoods1(Goods1 goods);

    public List<Goods1> loadAllShanXuan();

    public List<Goods1> loadAllShanXuan2();

    public List<Goods1> loadAllShanXuan3();

    public List<Goods1> loadAllShanXuan4();

    public List<Goods1> loadAllShanXuan5();

    public List<Goods1> moHuChaXunGoods(String sql);

    public boolean deleteplGoods(List<Integer> ids);
}
