package com.example.demo.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 定义JavaBean中成员变量时所使用的类型
 *   因为每个基本类型都有一个默认值：
 *      int ==> 0
 *      boolean==> false
 *
 * Mybatis plus会默认使用实体类的类名到数据库中找对应的表
 *
 */

/**
 * @TableName
 *      value:实体对应的表名
 */
@Data
@TableName(value = "tbl_employee")
public class Employee {

    /**
     * @TableId
     *  value:如果属性列的字段名和表中的主键名一样，则可以不指定。如果相同，则必须指定
     *  type: 指定主键策略
     */
    @TableId(value = "id")
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    @TableField(exist = false)
    private Double salary;
}
