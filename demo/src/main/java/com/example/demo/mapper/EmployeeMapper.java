package com.example.demo.mapper;

import com.example.demo.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    public Employee getEmployee(int id);
}
