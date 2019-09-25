package com.sl.tackout.service.impl;


import com.sl.tackout.pojo.Goods1;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

//导出Excel数据
@Service
public class ReadServiceimpl {
    public void exportExcel(List<Goods1> goodsList) {
        //创建HSSFWorkbook 对象  （Excel文档对象）
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //创建Excel表
        HSSFSheet sheet = hssfWorkbook.createSheet();
        //在当前表中创建行 第一行为表头
        HSSFRow titleRow = sheet.createRow(0);
        //编辑表头  给当前行创建单元格 使用setCelValue方法赋值
        titleRow.createCell(0).setCellValue("商品编号");
        titleRow.createCell(1).setCellValue("商品名称");
        titleRow.createCell(2).setCellValue("商品价格");
        titleRow.createCell(3).setCellValue("商品信息");
        titleRow.createCell(4).setCellValue("商品图片");
        for (Goods1 good : goodsList) {
            //获取当前最大的行
            int lastRowNum = sheet.getLastRowNum();
            //重新创建一行  存放
            HSSFRow dataRow = sheet.createRow(lastRowNum + 1);
            dataRow.createCell(0).setCellValue(good.getGid());
            dataRow.createCell(1).setCellValue(good.getGname() == null ? "" : good.getGname());
            dataRow.createCell(2).setCellValue(good.getGprice());
            dataRow.createCell(3).setCellValue(good.getGinfo() == null ? "" : good.getGinfo());
            dataRow.createCell(4).setCellValue(good.getGimg() == null ? "" : good.getGimg());
        }
        String fileName = "商品表.xls";

        try {
            //创建输出流及本地存储地址
            FileOutputStream fileOut = new FileOutputStream("D:\\" + fileName);
            //导出数据到本地，关闭流
            hssfWorkbook.write(fileOut);
            hssfWorkbook.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
