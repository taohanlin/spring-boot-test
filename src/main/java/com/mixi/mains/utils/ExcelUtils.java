package com.mixi.mains.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * @Description: excel导入、导出工具类
 * @author taohanlin
 * @date 2016年6月3日 上午11:22:15
 */
public class ExcelUtils {


  /**
   * @Description 导出
   * @author taohanlin
   * @date 2016年6月3日 上午11:24:07
   * @action excelOut
   * @return void
   */
  public static void excelOut(List<?> ary, String dirPath, String fileName) {
    WritableWorkbook workbook = null;
    File path = new File(dirPath);
    // 判断路径是否存在，不存在则创建
    if (!path.exists()) {
      path.mkdirs();
    }
    File file = new File(dirPath + "/" + fileName);
    // 判断文件是否存在
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    // 创建为excel文件
    try {
      // 创建一个工作薄，就是整个Excel文档，
      workbook = Workbook.createWorkbook(file);
      //Workbook.getWorkbook(new File("D:/good/2.xls")
      
      // 生成名为“第一页”的工作表，参数0表示这是第一页
      WritableSheet sheet = workbook.createSheet("sheet1", 0);
      List<String> str=Lists.newArrayList();
      str.add("用户ID");str.add("姓名");str.add("年龄");str.add("密码");
      //添加表头
      for (int i = 0; i < str.size(); i++) {
        sheet.addCell(new Label(i,0,str.get(i)));
      }
      //添加表体
     // sheet.getSettings().setVerticalFreeze(1);
      for (int i = 0; i < ary.size(); i++) {
        Object obj = ary.get(i);
        Class<? extends Object> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (int j = 0; j < fields.length; j++) {
          Field field = fields[j];
          field.setAccessible(true);
          if (field.getType().getName().equals("double")) {
            sheet.addCell(new Label(j, i+1, String.valueOf(field.getDouble(obj))));
          } else if (field.getType().getName().equals("int")) {
            sheet.addCell(new Label(j, i+1, String.valueOf(field.getInt(obj))));
          } else {
            sheet.addCell(new Label(j, i+1, String.valueOf(field.get(obj))));
          }
        }

      }
      workbook.write();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        workbook.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * @Description 导入
   * @author taohanlin
   * @date 2016年6月3日 上午11:52:30
   * @action excelIn
   * @return ArrayList
   */
  public static List excelIn(Class cls, String filepath) {
    List ary = new ArrayList();
    Workbook workbook = null;
    try {
      workbook = Workbook.getWorkbook(new File(filepath));
      Sheet sheet = workbook.getSheet(0);
      for (int i = 0; i < sheet.getRows(); i++) {

        Object obj = cls.newInstance();
        Field[] fields = cls.getDeclaredFields();
        for (int j = 0; j < fields.length; j++) {
          Field field = fields[j];
          Cell cell = sheet.getCell(j, i);
          field.setAccessible(true);
          if (field.getType().getName().equals("int")) {
            field.setInt(obj, Integer.parseInt((cell.getContents())));
          } else if (field.getType().getName().equals("double")) {
            field.setDouble(obj, Double.parseDouble(cell.getContents()));
          } else {
            field.set(obj, String.valueOf(cell.getContents()));
          }
        }
        ary.add(obj);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      workbook.close();
    }
    return ary;
  }

}
