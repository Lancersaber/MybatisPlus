package com.lancer.结构型模式.组合模式.common;

//common表示一般化实现
//普通员工
public class Employee {

    //员工号
    private String no;
    //职工姓名
    private String name;
    //职位
    private String position;
    //薪资
    private float salary;

    public Employee(String no, String name, String position, float salary) {
        this.no = no;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void printUserBaseInfo(){
        System.out.println("|"+this.no+" "+this.name+" "+this.position+" "+this.salary);
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
