package com.mixi.mains.mapper;

import java.util.List;

import com.mixi.mains.model.User;

public interface UserMapper {
  /**
   * @Description 查询用户信息
   * @author taohanlin
   * @date 2016年6月2日 下午6:18:32
   * @action findUserInfo
   * @return User
   */
  public List<User> findUserInfo();

}
