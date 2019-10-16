package com.lancer.Interface;

import com.lancer.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

//@Mapper
//@CacheNamespace
public interface EmplyeeMapper {

    @Select("select id,last_name from tb1_employee where id=#{id}")
    public Employee getPartEmp(Integer id);

//    @Select("select * from tb1_employee where id=#{id}")
    public Employee getEmployeeId(Integer id);

    @Select("select * from tb1_employee")
    public List<Employee> getAllEmps();

    @Insert("insert into tb1_employee(id,last_name,gender,email) values (#{id},#{lastName},#{gender},#{email})")
    public void insert(Employee employee);

    @MapKey("id")
    @Select("select * from tb1_employee")
    public Map<Integer,Employee> getMap();

//    动态sql
//    查询员工，要求是携带了哪个字段的信息，查询条件就带上这个字段
    public List<Employee> getEmpsByConditionIf(Employee employee);
}
