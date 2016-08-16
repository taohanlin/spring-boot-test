package com.mixi.mains.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.mixi.mains.model.User;

/**
 * @Description: 注解实现层
 * @author taohanlin
 * @date 2016年8月3日 下午6:20:31
 */
public interface AnnotationUserMapper {
  /**
   * @Description 注解查
   * @author taohanlin
   * @date 2016年8月5日 上午11:09:28
   * @action getUserAnnotation
   * @return User
   */  
  @Select({"<script>","select * from user "
      + "where "
      + "<if test=\"name != null\" > " 
      + "name = #{name}"
      + "</if>"
      + "<if test=\"name == null\" > " 
      + "userId = '1'"
      + "</if>" 
      +" LIMIT 1","</script>"})
  User getUserAnnotation(@Param("name") String name);
  
  
  /**
   * @Description 注解增
   * @author taohanlin
   * @date 2016年8月5日 上午11:09:45
   * @action insertUser
   * @return void
   */
  @Insert("INSERT INTO user (userId,name,password,age)"
    +"VALUES (#{userId},#{name},#{password},#{age})")
  void insertUser(User user);

  /**
   * @Description 注解查
   * @author taohanlin
   * @date 2016年8月5日 上午11:09:59
   * @action findUserById
   * @return User
   */
  @Select("select * from user where userId=#{userId}")
  @Results(
    {
      @Result(id=true,column="userId",property="userId"),
      @Result(column="name",property="name"),
      @Result(column="password",property="password"),
      @Result(column="age",property="age")
    }
    )
  User findUserById(Integer userId);
  
  
}
