package com.sl.tackout.mapper;

import com.sl.tackout.pojo.Goods1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodMapper1 {
    public List<Goods1> loadAll();
    public int addGoods1(Goods1 goods1);
    public int deleteGoods1(int gid);
    public Goods1 loadById1(int gid);
    public int updateGoods1(Goods1 goods);
    public List<Goods1> loadAllShanXuan();
    public List<Goods1> loadAllShanXuan2();
    public List<Goods1> loadAllShanXuan3();
    public List<Goods1> loadAllShanXuan4();
    public List<Goods1> loadAllShanXuan5();
    public List<Goods1> muHuChaXunGoods(String sql);
    public int deleteplGoods(List<Integer> ids);
}
