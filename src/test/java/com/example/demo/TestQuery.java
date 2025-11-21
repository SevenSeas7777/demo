package com.example.demo;

import com.example.demo.mapper.CustomerMapper;
import com.example.demo.pojo.Customer;
import com.example.demo.pojo.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestQuery {
    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void testQuery() {

        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
        List<Customer> list = customerMapper.QueryByNameAndJobs(customer);
        for (Customer c : list) {
            System.out.println(c);
        }


    }

    @Test
    public void findByWhere() {
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
        List<Customer> list = customerMapper.findByWhere(customer);
        for (Customer c : list) {
            System.out.println(c);
        }

    }


    @Test
    public void testUpdate() {
        Customer customer = new Customer();
        customer.setId(3);
        customer.setPhone("123456789");
        int rows = customerMapper.updateCustomerBySet(customer);
        if (rows > 0) {
            System.out.println("您修改成功了" + rows + "条数据");
        } else {
            System.out.println("您修改失败了！");
        }
    }

    @Test
    public void testforeach() {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(2);
        ids.add(3);
        List<Customer> list=customerMapper.findByArray(ids);
        for(Customer c:list){
            System.out.println(c);
        }

    }
    @Test
    public void testforeachMap() {

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", ids);
        map.put("jobs", "teacher");
        List<Customer> list = customerMapper.findByMap(map);
        for (Customer c : list) {
            System.out.println(c);
        }

    }

    @Test
    public void testforeach1(){


        Integer[] ids={1,2};
        List<Customer> list=customerMapper.findByList(ids);
        for(Customer c:list){
            System.out.println(c);
        }

    }
}
