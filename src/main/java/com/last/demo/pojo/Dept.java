package com.last.demo.pojo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*部门类*/
@Data //提供getset方法
@NoArgsConstructor //提供一个无参的构造方法
@AllArgsConstructor//提供一个全参的构造方法
public class Dept {
    private Integer id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}

