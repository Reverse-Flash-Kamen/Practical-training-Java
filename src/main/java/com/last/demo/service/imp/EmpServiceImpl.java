package com.last.demo.service.imp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.last.demo.mapper.EmpMapper;
import com.last.demo.pojo.Emp;
import com.last.demo.pojo.PageBean;
import com.last.demo.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    // @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 执行条件分页查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        // 获取查询结果
        Page<Emp> p = (Page<Emp>) empList;
        // 封装PageBean p.getTotal()获得总条目数 p.getResult()获得当前页的条目数
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    // @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    // @Override
    public void save(Emp emp) {
        // 补全数据
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        // 调用添加方法
        empMapper.insert(emp);
    }

    // @Override
    public Emp getById(Integer id) {
        return empMapper.findById(id);
    }

    // @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now()); // 更新修改时间为当前时间

        empMapper.update(emp);
    }
}
