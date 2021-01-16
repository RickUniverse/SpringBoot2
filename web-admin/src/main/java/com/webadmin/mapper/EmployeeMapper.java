package com.webadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.webadmin.bean.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

//@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    Employee selectEmployeeById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into tb_employee(lastName) value(lastName)")
    void insertEmployee(Employee employee);

}
