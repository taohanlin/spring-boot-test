package com.mixi.mains.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mixi.mains.model.User;
import com.mixi.mains.service.AnnotationUserService;


@Controller
public class HelloController {
  private Logger LOG=Logger.getLogger(HelloController.class);
  
  @Autowired
  private AnnotationUserService userService;

    @RequestMapping("/getUserByName")
    @ResponseBody
    public User getUserByName(@RequestParam(value="name", required=false, defaultValue="zhangsan") String name, Model model) {
        LOG.info(model);
        model.addAttribute("name", name);
        User userAnnotation = userService.getUserAnnotation(name);
        LOG.info(userAnnotation);
        System.out.println(userAnnotation.getName()+" == "+userAnnotation.getPassword());
        return userAnnotation;
    }
  

}
