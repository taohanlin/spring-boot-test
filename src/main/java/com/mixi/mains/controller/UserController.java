package com.mixi.mains.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mixi.mains.model.User;
import com.mixi.mains.service.UserService;

@Controller
public class UserController {
  
  private Logger logger=Logger.getLogger(UserController.class);
  
  @Autowired
  private UserService userService;
  
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
  
  

}
