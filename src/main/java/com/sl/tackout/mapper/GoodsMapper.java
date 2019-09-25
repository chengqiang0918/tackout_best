package com.sl.tackout.mapper;
import com.sl.tackout.pojo.Goods;
import com.sl.tackout.pojo.UserTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    //查询所有商品
    public List<Goods> findAll();
    //查询多少行  用于分页
    public int findcount();

    //根据gid查询商品对象
    public Goods xiangqin(int gid);
    //模糊查询
    public List<Goods> chaxun(String name);
}
