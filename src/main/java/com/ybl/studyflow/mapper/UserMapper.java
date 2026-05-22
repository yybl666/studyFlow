package com.ybl.studyflow.mapper;

import com.ybl.studyflow.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Select("select id,username,password from user where username = #{username}")
    User findByUsername(@Param("username") String username);

    @Insert("insert into user(username,password) values(#{username},#{password})")
    void insert(User user);
}