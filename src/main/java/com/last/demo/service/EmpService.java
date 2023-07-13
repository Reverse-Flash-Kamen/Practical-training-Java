package com.last.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.last.demo.pojo.Emp;
import com.last.demo.pojo.PageBean;

public interface EmpService {
    /**
     * 更新员工
     * 
     * @param emp
     */
    public void update(Emp emp);

    /**
     * 根据ID查询员工
     * 
     * @param id
     * @return
     */
    public Emp getById(Integer id);

    /**
     * 保存员工信息
     * 
     * @param emp
     */
    void save(Emp emp);

    /**
     * 批量删除操作
     * 
     * @param ids id集合
     */
    void delete(List<Integer> ids);

    /**
     * 条件分页查询
     * 
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @param name     姓名
     * @param gender   性别
     * @param begin    开始时间
     * @param end      结束时间
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
}
