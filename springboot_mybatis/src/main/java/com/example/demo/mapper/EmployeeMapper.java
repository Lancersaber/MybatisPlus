package com.example.demo.mapper;

import com.example.demo.bean.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {

    @Select("select id,last_name from tb1_employee where id=#{id}")
    public Employee getPartEmp(Integer id);

    @Select("select * from tb1_employee where id=#{id}")
    public Employee getEmployeeId(Integer id);

    @Select("select * from tb1_employee")
    public List<Employee> getAllEmps();

    @Insert("insert into tb1_employee(id,last_name,gender,email) values (#{id},#{lastName},#{gender},#{email})")
    public void insert(Employee employee);

    @MapKey("id")
    @Select("select * from tb1_employee")
    public Map<Integer,Employee> getMap();
}
