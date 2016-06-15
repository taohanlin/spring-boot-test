package com.mixi.mains.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.common.collect.Lists;
import com.mixi.mains.model.User;
import com.mixi.mains.service.UserService;
import com.mixi.mains.utils.ExcelUtils;

@Controller
public class ExcelController {

  private static Logger LOG = Logger.getLogger(ExcelController.class);

  @Autowired
  private UserService userService;

  /**
   * @Description 导出
   * @author taohanlin
   * @date 2016年6月3日 下午5:40:21
   * @action ImportDemo+
   * @return String
   */
  @RequestMapping("/download")
  @ResponseBody
  public String DownloadDemo() {
    List<User> userInfo = userService.getUserInfo();
    String url = "D:/good";
    String fileName = "user.xls";
    try {
      ExcelUtils.excelOut(userInfo, url, fileName);
    } catch (Exception e) {
      LOG.error("出现错误~");
      return "导出错误~";
    }
    return "导出成功~";
  }

  /**
   * @Description 导入 
   * @author taohanlin
   * @date 2016年6月3日 下午6:16:04
   * @action ImportDemo
   * @return Object
   */
  @RequestMapping("/import")
  @ResponseBody
  public Object ImportDemo(){
    List<User> excelIn=Lists.newArrayList();
    try {
      excelIn  = ExcelUtils.excelIn(User.class, "D:/good/user.xls");
      if (excelIn.isEmpty()) {
        return "无数据";
      }
      for (User user : excelIn) {
        System.out.println(user);
      }
    } catch (Exception e) {
      return "导入失败";
    }
    return excelIn;
    
  }
}
