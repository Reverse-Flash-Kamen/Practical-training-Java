package com.last.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.last.demo.pojo.Dept;
import com.last.demo.pojo.Result;
import com.last.demo.service.DeptService;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    // @RequestMapping(value = "/depts" , method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list() {
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) {
        // 调用service层功能
        deptService.delete(id);
        // 响应
        return Result.success();
    }

    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        // 调用service层添加功能
        deptService.add(dept);
        // 响应
        return Result.success();
    }

    /*
     * 根据ID查询
     */
    @GetMapping("/depts/{id}")
    public Result selectById(@PathVariable Integer id) {
        Dept dept = deptService.selectById(id);
        return Result.success(dept);
    }

    /*
     * 修改部门
     */
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.success();
    }
}
