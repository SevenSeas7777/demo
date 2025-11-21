package com.example.demo;

import com.example.demo.mapper.DeptMapper;
import com.example.demo.pojo.Dept1;
import com.example.demo.pojo.Emp1;
import com.example.demo.pojo.returnDao.OthersDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeptTest {
    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void selectByHave() {
        List<Dept1> depts = deptMapper.selectByHave(1);
        for (Dept1 dept : depts) {
            System.out.println(dept);
        }
    }

    @Test
    public void selectBySal(){
        List<String> emp1 = deptMapper.selectBySal("甘宁");
        for (String s : emp1) {
            System.out.println(s);
        }
    }
    @Test
    public void selectByOthers(){
        List<OthersDao> othersDaos = deptMapper.selectByOthers();
        for (OthersDao othersDao : othersDaos) {
            System.out.println(othersDao);
        }
    }
}
