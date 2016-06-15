package com.mixi.mains.model;


/**
 * @Description 封装类
 * @author taohanlin
 * @date 2016年6月2日 下午6:17:23
 */
public class User {
  private int userId;
  private String name;
  private int age;
  private String password;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public String toString() {
    return "User [userId=" + userId + ", name=" + name + ", age=" + age + ", password=" + password
        + "]";
  }


}
