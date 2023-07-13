package com.last.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.last.demo.pojo.Dept;

@Mapper
public interface DeptMapper {
    @Select("select id, name, create_time, update_time from dept")
    List<Dept> list();

    /**
     * 根据id删除部门信息
     * 
     * @param id 部门id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into dept (name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void inser(Dept dept);

    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept selectById(Integer id);
}
