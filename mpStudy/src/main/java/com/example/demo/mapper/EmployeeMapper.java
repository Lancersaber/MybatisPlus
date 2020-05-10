package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.beans.Employee;

/**
 * 让xxxMapper接口继承BaseMapper接口即可
 * 泛型指定的就是当前Mapper接口所操作的实体类类型
 * @author 34689
 */

public interface EmployeeMapper extends BaseMapper<Employee> {
    //mp:插入数据后会自动回显主键id的值
}
