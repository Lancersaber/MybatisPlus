package com.atguigu.hashtable;

public class HashTableDemo {

    public static void main(String args[]){
        HashTab hashTab = new HashTab(7);

    }
}
/**
 *      散列表(Hash table,也叫做哈希表)，是根据关键码值而直接进行访问的数据结构。也就是说，它通过把关键码值映射
 * 到表中一个位置来访问记录，以加快查找的速度。这个映射函数叫做散列函数，存放记录的数组叫做散列表。
 * 散列表两种形式(数组+链表||数组+二叉排序树)
 */
//创建哈希表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;//表示共有多少条链表

    //构造器
    public HashTab(int size){
        this.size=size;
        //初始化数组empLinkedListArray
        empLinkedListArray=new EmpLinkedList[size];
        //留一个坑,不要忘了初始化每一条链表
        for (int i=0;i<size;i++){
            empLinkedListArray[i]=new EmpLinkedList();
        }
    }

    //添加
    public void add(Emp emp){
        //根据员工的id得到该员工应该加入到哪条链表
        int empLinkedListNo=hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //遍历整个hashtable
    public void list(){
        for(int i=0;i<size;i++){
            empLinkedListArray[i].list(i+1);
        }
    }

    //根据输入id查找雇员
    public void findEmpById(int id){
        //使用散列函数确定到哪条链表上查找
        int empLinkedListNo=hashFun(id);
        Emp empById = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if(empById!=null){
            System.out.println("在第"+(empLinkedListNo+1)+"条链表中找到雇员");
        }else {
            System.out.println("在哈希表中，没有找到该雇员");
        }
    }

    //编写散列函数，使用一个简单的取模法
    public int hashFun(int id){
        return id%size;
    }
}


//创建EmpLinkedList,表示链表
class EmpLinkedList{
    //头指针，执行第一个Emp，因此我们这个链表的head，是直接指向第一个Emp
    private Emp head;//默认为null

    //添加雇员到链表
    //说明
    //1、假定当添加雇员时，id是自增的，即id的分配总是从小到大
    //因此我们将雇员直接加入到本链表的最后即可
    public void add(Emp emp){
        //如果是添加第一个雇员
        if(head==null){
            head=emp;
            return;
        }
        //不是第一个雇员，则使用一个辅助指针定位到最后
        Emp curEmp=head;
        while (curEmp!=null){
            curEmp=curEmp.next;
        }
        //退出时直接将emp加到最后即可
        curEmp.next=emp;
    }

    //遍历链表的雇员信息
    public void list(int i){
        if(head==null){//说明链表为空
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("第"+i+"条链表的信息为");
        Emp curEmp=head;
        while (curEmp!=null){
            System.out.println("==>"+curEmp);
            curEmp=curEmp.next;
        }
    }

    //根据id查找雇员
    //如果查找到就返回emp，如果没有找到，就返回null
    public Emp findEmpById(int id){
        //判断链表是否为空
        if(head==null){
            return null;
        }
        Emp curEmp=head;
        while (curEmp!=null&&curEmp.id!=id){
            curEmp=curEmp.next;
        }
        return curEmp;
    }
}

//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;    //默认为null

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
