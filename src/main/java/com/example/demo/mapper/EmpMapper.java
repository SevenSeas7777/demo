package com.example.demo.mapper;


import com.example.demo.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Mapper
public interface EmpMapper {
    //@Delete("delete from emp where id=#{id}")
    void deleteById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    /*@Insert("insert into emp (username,name,gender,image,job,entrydate,dept_id,create_time,update_time)" +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")*/
    void insert(Emp emp);

    /*@Update("update emp set username=#{username},name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime}" +
            " where id=#{id}")*/
    void updateById(Emp emp);


    List<Emp> list(String name, String gender, Date begin, Date end );

    void update(Emp emp);


    void delete(@Param("ids") List<Integer> ids);

    void batchInsert(List<Emp> list);

}
