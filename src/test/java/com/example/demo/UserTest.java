package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertTest(){
        User user = new User();
        user.setName("xuyuxiao");
        user.setBal(170);
        userMapper.insert(user);
    }

    @Test
    public void find(){
        User user = new User();
        user.setName("xyx");

        List<User> users = userMapper.find(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void update(){
        User user = new User();
        user.setName("xyx");
        user.setBal(180);
        userMapper.update(user);
    }
    @Test
    public void delect(){
        userMapper.delete(null,null,200);
    }
}
