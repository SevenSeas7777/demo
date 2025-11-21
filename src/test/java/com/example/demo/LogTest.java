package com.example.demo;

import com.example.demo.mapper.EmpMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Emp;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {

    @Test
    public void contextLoads() {
        //记录器
        Logger logger = LoggerFactory.getLogger(getClass());

        //日志的级别；
        //由低到高   trace<debug<info<warn<error
        //可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");


    }

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmpMapper empMapper;


    @Test
    public void test() {
        List<User> admin = userService.getByName("admin");
        for (User user : admin) {
            System.out.println(user);
        }
    }

    /*@Test
    public void test1() {
        User admin = userMapper.findByName("admin");
        System.out.println(admin);
    }*/

    @Test
    public void test2() {
        empMapper.deleteById(19);
    }

    @Test
    public void test3() {
        //创建员工对象
        Emp emp = new Emp();
        emp.setUsername("tom");
        emp.setName("汤姆");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        //调用添加方法
        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void test4() {
        Emp emp = new Emp();
        emp.setId(17);
        emp.setUsername("xu");
        emp.setName("徐煜霄");
        emp.setImage("1.jpg");
        emp.setGender((short) 2);
        emp.setJob((short) 2);
        emp.setEntrydate(LocalDate.of(200, 10, 21));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(5);
        empMapper.updateById(emp);
    }

    @Test
    public void  test5() throws ParseException {
        Date begin = new Date();
        Date end = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        begin = sdf.parse("2008-12-31");
        end = sdf.parse("2025-12-00");
        List<Emp> list = empMapper.list(null, null, begin, end);
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    @Test
    public void  test6()  {
        Emp emp = new Emp();
        emp.setId(17);
        emp.setUsername("xuyuxiao");
        empMapper.update(emp);
    }
    @Test
    public void test7() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        empMapper.delete(list);
    }
    @Test
    public void test8() {
        ArrayList<Emp> list = new ArrayList<>();
        Emp emp = new Emp();
        emp.setUsername("xu");
        emp.setName("徐");
        Emp emp1 = new Emp();
        emp1.setUsername("yu");
        emp1.setName("煜");
        Emp emp2 = new Emp();
        emp2.setUsername("xiao");
        emp2.setName("霄");
        list.add(emp);
        list.add(emp1);
        list.add(emp2);
        empMapper.batchInsert(list);
    }
}
