package com.mixi.mains.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mixi.mains.Application;
import com.mixi.mains.model.User;
import com.mixi.mains.service.UserService;

/**
 * @Description: 用户表测试
 * @author taohanlin
 * @date 2016年6月3日 下午6:31:08
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class UserControllerTest{
  
  @Autowired
  private UserService userService;
  
  @Test
   public void test(){
     List<User> userInfo = userService.getUserInfo();
     for (User user2 : userInfo) {
      System.out.println(user2);
    }
     
   }

}
