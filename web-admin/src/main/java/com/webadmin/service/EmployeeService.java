package com.webadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.webadmin.bean.Employee;

/**
 * extends IService<Employee> : 继承mybatis-plus的顶级service接口
 */
public interface EmployeeService extends IService<Employee> {
    Employee getEmployeeById(Integer id);
}
