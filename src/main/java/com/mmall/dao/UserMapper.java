package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer checkUsername(@Param("username") String username);

    User selectLogin(@Param("username") String username, @Param("password") String password);

    Integer checkEmail(@Param("email") String email);

    String selectQuestionByUsername(@Param("username") String username);

    Integer checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);

    Integer updatePasswordByUsername(@Param("username") String username, @Param("passwordNew") String passwordNew);

    Integer checkPassword(@Param("userId") Integer userId, @Param("password") String password);

    Integer checkEmailByUserId(@Param("email") String email, @Param("userId") Integer userId);
}