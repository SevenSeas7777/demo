package com.example.demo.mapper;

import com.example.demo.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerMapper {
    List<Customer> QueryByNameAndJobs(Customer customer);

    List<Customer> findByWhere(Customer customer);

    int updateCustomerBySet(Customer customer);

    List<Customer> findByArray( List<Integer> ids);

    List<Customer> findByMap(Map<String, Object> map);

    List<Customer> findByList(@Param("list") Integer[] ids);
}
