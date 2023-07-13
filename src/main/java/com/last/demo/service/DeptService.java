package com.last.demo.service;

import java.util.List;

import com.last.demo.pojo.Dept;

public interface DeptService {
    /**
     * 查询所有的部门数据
     * 
     * @return 存储Dept对象的集合
     */

    /**
     * 根据id删除部门
     * 
     * @param id 部门id
     */
    void delete(Integer id);

    /**
     * 新增部门
     * 
     * @param dept 部门对象
     */
    void add(Dept dept);

    /*
     * 修改部门
     */
    void update(Dept dept);

    /*
     * 根据ID查询数据
     */
    Dept selectById(Integer id);

    List<Dept> list();
}
