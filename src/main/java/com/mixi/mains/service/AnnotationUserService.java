package com.mixi.mains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mixi.mains.mapper.AnnotationUserMapper;
import com.mixi.mains.model.User;

@Service
public class AnnotationUserService {
  
  @Autowired
  private AnnotationUserMapper userMapper;
  
  public User getUserAnnotation(String name){
    
    return userMapper.getUserAnnotation(name);
  }

}
