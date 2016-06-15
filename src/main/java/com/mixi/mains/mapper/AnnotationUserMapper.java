package com.mixi.mains.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mixi.mains.model.User;

public interface AnnotationUserMapper {
  
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
}
