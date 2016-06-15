package com.mixi.mains.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mixi.mains.mapper.UserMapper;
import com.mixi.mains.model.User;

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public List<User> getUserInfo() {
    List<User> findUserInfo = userMapper.findUserInfo();
    return findUserInfo;
  }

}
