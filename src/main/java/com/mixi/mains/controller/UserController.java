package com.mixi.mains.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.mixi.mains.model.User;
import com.mixi.mains.service.AnnotationUserService;
import com.mixi.mains.service.UserService;

@Controller
public class UserController {

  private Logger logger = Logger.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  @Autowired
  private AnnotationUserService userService2;

  /**
   * @Description 查询所有信息
   * @author taohanlin
   * @date 2016年8月11日 下午6:13:49
   * @action getUserInfo
   * @return List<User>
   */
  @RequestMapping("/getUserInfo")
  @ResponseBody
  public List<User> getUserInfo() {
    List<User> user = userService.getUserInfo();
    for (User user2 : user) {
      System.out.println(user2);
      logger.info(user2);
    }
    return user;
  }

  /**
   * @Description 返回到html界面
   * @author taohanlin
   * @date 2016年8月11日 下午6:35:22
   * @action JumpView
   * @return String
   */
  @RequestMapping(value = "/jumpView", method = RequestMethod.GET)
  public String JumpView(Model model, HttpServletRequest request) {
    User findUserById = userService2.findUserById(10);
    if (findUserById != null) {
      model.addAttribute("user", findUserById);
      return "view/user/passwordFrom";
    } else {
      findUserById=new User(5, "王八蛋", 16, "123456");
      model.addAttribute("user", findUserById);
      return "view/user/submit";
      // 重定向到接口： return "redirect:view/error";
      // return "view/error";
    }
  }

  /**
   * @Description 获取界面数据
   * @author taohanlin
   * @date 2016年8月16日 上午11:37:40
   * @action getData
   * @return String
   */
  @RequestMapping(value = "/getData", method = RequestMethod.POST)
  public String getData(HttpServletRequest request,Model model) {
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    Map<String, Object> map = Maps.newHashMap();
    map.put("name", name);
    map.put("password", password);
    model.addAttribute("map",map);
    return "view/success";
  }



}
