package com.webadmin.controller;

import com.webadmin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijichen
 * @date 2021/1/15 - 13:56
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp")
    public Object getEmp(Integer id) {
        return employeeService.getEmployeeById(id);
    }
}
