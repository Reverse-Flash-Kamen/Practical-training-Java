package com.last.demo.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.last.demo.pojo.Emp;

@Mapper
public interface EmpMapper {
    // 获取当前页的结果列表
    public List<Emp> list(@Param("name") String name, @Param("gender") Short gender, @Param("begin") LocalDate begin,
            @Param("end") LocalDate end);

    // 批量删除
    void delete(@Param("ids") List<Integer> ids);

    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime});")
    void insert(Emp emp);

    // 根据ID查询员工信息
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
            "from emp " +
            "where id = #{id}")
    public Emp findById(Integer id);

    // 修改员工信息
    public void update(Emp emp);
}
