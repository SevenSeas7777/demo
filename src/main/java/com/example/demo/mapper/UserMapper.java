package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

 /*   @Results({@Result(column = "user_id",property = "userId")})
    @Select("select * from t_user where username=#{username}")
    User findByName(@Param("username")String username);
    */

   void insert(User user);

   List<User> find(User user);

   void update(User user);

   void delete(Integer userId,String username,Integer balance);



}
