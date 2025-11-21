package com.example.demo;

import com.example.demo.mapper.EmpMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void stringTest() {
        redisTemplate.opsForValue().set("hello", "word");
    }

    @Test
    public void stringTest1() {
        //redis创建String结构数据
        redisTemplate.opsForValue().set("name", "xyx");
        //获取value
        Object o = redisTemplate.opsForValue().get("name");
        System.out.println(o);
        //设置过期时间
        redisTemplate.opsForValue().set("time", "10s后删除", 10L, TimeUnit.SECONDS);

        Boolean a = redisTemplate.opsForValue().setIfAbsent("name", "rose");
        //当没有该key时创建
        Boolean b = redisTemplate.opsForValue().setIfAbsent("age", "18");
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void hashTest() {
        //获取hash操作对象
        HashOperations hashOperations = redisTemplate.opsForHash();
        //redis创建hash结构数据
        hashOperations.put("001", "name", "xyx");
        hashOperations.put("001", "age", "18");
        hashOperations.put("001", "city", "HZ");

        //获取指定key的value
        Object o = hashOperations.get("001", "name");
        System.out.println(o);
        System.out.println("---------");
        //获取指定表单中的所有key
        Set keys = hashOperations.keys("001");
        for (Object key : keys) {
            System.out.println(key);
        }
        System.out.println("---------");
        //获取表单中的所有value
        List values = hashOperations.values("001");
        for (Object value : values) {
            System.out.println(value);
        }

    }

    @Test
    public void listTest() {
        //获取list操作对象
        ListOperations listOperations = redisTemplate.opsForList();
        //redis创建list结构数据，一次一个
        listOperations.leftPush("list", "a");
        //redis创建list结构数据，一次多个
        listOperations.leftPushAll("list", "b", "c", "d");

        //获取value，并设置取值范围，结果根据打印时先进后打印
        List list = listOperations.range("list", 0, -1);
        for (Object o : list) {
            System.out.println(o);
        }

        //获取list长度
        Long aLong = listOperations.size("list");
        System.out.println("long:" + aLong);
        //转换为int类型
        int i = aLong.intValue();
        //rpop根据先进先出顺序输出
        for (int i1 = 0; i1 < i; i1++) {
            Object o = listOperations.rightPop("list");
            System.out.println(o);
        }

    }

    @Test
    public void setTest() {
        //创建set操作对象
        SetOperations setOperations = redisTemplate.opsForSet();
        //redis创建set结构数据,不会存在重复value,储存是无序的
        setOperations.add("set", "a", "b", "c", "d");
        //获取value
        Set set = setOperations.members("set");
        for (Object o : set) {
            System.out.println(o);
        }
    }

    @Test
    public void zsetTest() {
        //创建zset操作对象
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        //redis创建zset结构数据，类型为double,根据从小到大排序
        zSetOperations.add("zSet","a",10);
        zSetOperations.add("zSet","b",11);
        zSetOperations.add("zSet","c",12);
        zSetOperations.add("zSet","d",13);

        //获取数据
        Set zSet = zSetOperations.range("zSet", 0, -1);
        for (Object o : zSet) {
            System.out.println(o);
        }

        //删除数据,可以删除一个或者多个
        zSetOperations.remove("zSet","a");
    }

    @Test
    public void general(){
        //获取redis所有的key
        Set keys = redisTemplate.keys("*");
        for (Object key : keys) {
            System.out.println(key);
        }
        //判断某个key是否存在
        Boolean b = redisTemplate.hasKey("ddd");
        Boolean b1 = redisTemplate.hasKey("name");
        System.out.println(b);
        System.out.println(b1);

        //删除指定key
        //Boolean zSet = redisTemplate.delete("zSet");
        //获取指定key对应的value的数据类型
        DataType zSet = redisTemplate.type("zSet");
        System.out.println(zSet.name());

    }

}
