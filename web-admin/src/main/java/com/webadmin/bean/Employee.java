package com.webadmin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author lijichen
 * @date 2021/1/15 - 13:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName(value = "tb_employee")//告诉mybatis-plus 是数据库中的那个表
public class Employee {
    private Integer id;
    private String lastName;

    // 因为mybatis-plue，要求每个字段再数据库中都要存在，所以需要加上exist=false指明数据库中没有该字段
    @TableField(exist = false)
    private String other;
}
