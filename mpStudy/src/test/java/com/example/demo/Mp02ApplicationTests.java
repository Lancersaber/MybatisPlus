package com.example.demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.beans.Employee;
import com.example.demo.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.*;

@SpringBootTest
class Mp02ApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    void contextLoads() {
        System.out.println(employeeMapper);
    }



    @Test
    public void testCommonInsert(){
        Employee employee=new Employee();
        employee.setName("bill");
//        employee.setAge(19);
        employee.setEmail("3468989340");
        //insert方法在插入时，会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现在sql语句中
        //如果不给employee的某些字段赋值，则会默认插入null值，但是在非空的字段时会报错
        employeeMapper.insert(employee);

        //获取当前数据在数据库中的主键值
        //注意这里并没有设置id值
        Integer key=employee.getId();
        System.out.println("key: "+key);
    }

    @Test
    public void testCommonTest(){
        //初始化修改对象
        Employee employee=new Employee();
        employee.setId(11);
        employee.setName("Jike");
        employee.setAge(18);
//        employee.setEmail("111");

        //对数据库的影响条数
        //update方法在更新时，会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现在sql语句中
        int i = employeeMapper.updateById(employee);


        System.out.println("影响的条数为： "+i);

    }

    /**
     * 通用 查询操作
     */
    @Test
    public void testCommonSelect(){

        //1、通过id查询
//        Employee employee = employeeMapper.selectById(1);
//        System.out.println(employee);

        //2、通过多个列进行查询
        //通过id + lastName
//        Employee employee=new Employee();
//        employeeMapper.selectOne();

        //3、通过多个id进行查询
//        List<Integer> idList = new ArrayList<>(Arrays.asList(3, 4, 5, 6));
//        List<Employee> employees = employeeMapper.selectBatchIds(idList);
//        System.out.println(employees);

        //4、通过Map封装条件查询
//        Map<String,Object> columnMap=new HashMap<>();

        //map中键值为表中对应的属性名，值为对应的属性值
//        columnMap.put("name","bill");
//        columnMap.put("age",19);
//        List<Employee> employeeMap = employeeMapper.selectByMap(columnMap);
//        System.out.println(employeeMap);

        //5、分页查询
        Page<Employee> employeePage = employeeMapper.selectPage(new Page<>(2, 2), null);
//        List<Employee> records = employeePage.getRecords();
        long size = employeePage.getSize();


        System.out.println(size);
    }

    @Test
    public void testCommonDelete(){

        //1、根据id进行删除
//        int i = employeeMapper.deleteById(12);
//        System.out.println(i);

        //根据条件进行删除
//        Map<String,Object> map=new HashMap<>();
//        map.put("name","Tom");
//        map.put("age",28);
//        employeeMapper.deleteByMap(map);

        //3、根据id批量删除
        List<Integer> idList=new ArrayList<>(Arrays.asList(6,7,8));
        int i = employeeMapper.deleteBatchIds(idList);
        System.out.println(i);
    }
    int times=0;
    @Test
    public void test01(){

        int plate=2;
        Hanio(plate,"A","B","C");
        System.out.println("一共运行"+times);
    }


    public void Hanio(int n,String plateA,String plateB,String plateC){
        if(n==1){
            Move(n,plateA,plateB);
        }
        else{
            Hanio(n-1,plateA,plateC,plateB);
            Move(n,plateA,plateB);
            Hanio(n-1,plateC,plateB,plateA);
        }
    }

    public void Move(int n, String A,String B){
        System.out.println("将"+n+"从"+A+"移到"+B+"上");
        times++;
    }
}
