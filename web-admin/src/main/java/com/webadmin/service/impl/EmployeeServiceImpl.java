package com.webadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.webadmin.bean.Employee;
import com.webadmin.mapper.EmployeeMapper;
import com.webadmin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lijichen
 * @date 2021/1/15 - 13:55
 */

/**
 * extends ServiceImpl<EmployeeMapper,Employee> ： 继承mybatis-plus的service实现
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeMapper.selectEmployeeById(id);
    }
}
