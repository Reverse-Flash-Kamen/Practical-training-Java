package com.last.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.last.demo.pojo.Emp;
import com.last.demo.pojo.PageBean;
import com.last.demo.pojo.Result;
import com.last.demo.service.EmpService;

@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    // 批量删除
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        empService.delete(ids);
        return Result.success();
    }

    // 条件分页查询
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            String name, Short gender,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        // 调用业务层分页查询功能
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        // 响应
        return Result.success(pageBean);
    }

    // 新增
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        // 调用业务层新增功能
        empService.save(emp);
        // 响应
        return Result.success();
    }

    // 根据id查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    // 修改员工
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success();
    }
}
