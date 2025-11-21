package com.example.demo.mapper;

import com.example.demo.pojo.Dept1;
import com.example.demo.pojo.Emp1;
import com.example.demo.pojo.returnDao.OthersDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeptMapper {
    List<Dept1> selectByHave(Integer count);

    List<String> selectBySal(String ename);

     List<OthersDao> selectByOthers();
}
