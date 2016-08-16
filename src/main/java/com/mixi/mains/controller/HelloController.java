package com.mixi.mains.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mixi.mains.model.User;
import com.mixi.mains.service.AnnotationUserService;

/**
 * @Description: 注解sql查询
 * @author taohanlin
 * @date 2016年8月3日 上午10:40:40
 */
@Controller
public class HelloController {
  private Logger LOG = Logger.getLogger(HelloController.class);

  @Autowired
  private AnnotationUserService userService;



  /**
   * @Description 根据userId查询用户信息
   * @author taohanlin
   * @date 2016年8月3日 下午6:18:14
   * @action findUserById
   * @return Object
   */
  @RequestMapping("/findUserById")
  @ResponseBody
  public Object findUserById(Integer userId) {
    User findUserById = userService.findUserById(userId);
    if (findUserById == null) {
      return "该id查询为空";
    }
    return findUserById.toString();
  }

  /**
   * @Description 注解查
   * @author taohanlin
   * @date 2016年8月3日 下午5:16:45
   * @action getUserByName
   * @return User
   */
  @RequestMapping("/getUserByName")
  @ResponseBody
  public User getUserByName(
      @RequestParam(value = "name", required = false, defaultValue = "zhangsan") String name,
      Model model) {
    LOG.info(model);
    model.addAttribute("name", name);
    User userAnnotation = userService.getUserAnnotation(name);
    LOG.info(userAnnotation);
    System.out.println(userAnnotation.getName() + " == " + userAnnotation.getPassword());
    return userAnnotation;
  }

  /**
   * @Description 注解增
   * @author taohanlin
   * @date 2016年8月3日 下午5:17:00
   * @action insertUser
   * @return Object
   */
  @RequestMapping("/insertUser")
  @ResponseBody
  public Object insertUser(User user) {
    if (StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(String.valueOf(user.getUserId()))
        || StringUtils.isEmpty(String.valueOf(user.getAge()))
        || StringUtils.isEmpty(user.getPassword())) {
      return "信息不全";
    }
    try {
      userService.insertUser(user);
    } catch (Exception e) {
      return "添加出错";
    }
    return "成功添加一条数据" + user.toString();
  }


}
