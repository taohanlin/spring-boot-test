package com.mixi.mains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mixi.mains.mapper.AnnotationUserMapper;
import com.mixi.mains.model.User;

/**
 * @Description: 注解service层
 * @author taohanlin
 * @date 2016年8月3日 下午6:20:07
 */
@Service
public class AnnotationUserService {
  
  @Autowired
  private AnnotationUserMapper userMapper;
  
  public User getUserAnnotation(String name){
    return userMapper.getUserAnnotation(name);
  }
  
  public void insertUser(User user){  
        userMapper.insertUser(user);
  }
  
  public User findUserById(Integer userId){
    return userMapper.findUserById(userId);
  }

}
