package com.example.demo.service;

import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getByName(String username) {
        List<User> query = jdbcTemplate.query("select * from t_user where username=? ", (resultSet, i) -> {
            User user = new User();
            user.setName(resultSet.getString("username"));
            user.setUserId(resultSet.getInt("user_id"));
            return user;
        }, username);
        return query;
    }
}
