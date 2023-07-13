package com.last.demo.service.imp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last.demo.mapper.DeptMapper;
import com.last.demo.pojo.Dept;
import com.last.demo.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    // @Override
    public List<Dept> list() {
        List<Dept> deptList = deptMapper.list();
        return deptList;
    }

    // @Override
    public void delete(Integer id) {
        // 调用持久层删除功能
        deptMapper.deleteById(id);
    }

    // @Override
    public void add(Dept dept) {
        // 补全部门数据
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        // 调用持久层增加功能
        deptMapper.inser(dept);
    }

    // @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

    // @Override
    public Dept selectById(Integer id) {
        Dept dept = deptMapper.selectById(id);
        return dept;
    }
}
