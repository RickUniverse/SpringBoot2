package com.webadmin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.webadmin.bean.Employee;
import com.webadmin.exception.UserTooManyException;
import com.webadmin.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author lijichen
 * @date 2021/1/13 - 19:13
 */
@Slf4j
@Controller
public class TableController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }


    @GetMapping("/user/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id,
                                 @RequestParam(value = "pn",required = false,defaultValue = "1") Integer pageNo,
                                 RedirectAttributes redirectAttributes) {
        boolean b = employeeService.removeById(id);
        log.warn("删除操作id为:{},结果{},的数据",id,b);
        // 带参数的重定向
        redirectAttributes.addAttribute("pageNo",pageNo);
        return "redirect:/dynamic_table";
    }


    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pageNo",required = false,defaultValue = "1") Integer pageNo,
                                Model model) {

        /*if (1 == 1) {
            throw new UserTooManyException();
        }*/

        Page<Employee> employeePage = new Page<>(pageNo,2);
        // 分页查询的结果
        Page<Employee> page = employeeService.page(employeePage, null);

        model.addAttribute("users",page);


        return "table/dynamic_table";
    }



    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table() {
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        int i = 10/0;
        return "/error";
    }
}
