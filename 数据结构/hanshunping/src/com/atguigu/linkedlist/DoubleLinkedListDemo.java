package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String args[]){
        System.out.println("双向链表的测试");
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");

        //创建一个双向链表
        DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);

        doubleLinkedList.list();
    }
}
/**
 * 单向链表的缺点
 * 1、查找的方向只能是一个方向，而双向链表可以向前或向后查找
 * 2、单向链表不能自我删除，需要辅助节点，而双向链表，则可以自我删除，所以前面我们单链表删除节点时，总是找到待删除节点的上一个节点
 */
/**
 * 分析双向链表的遍历，添加，修改，删除的操作思路===》代码实现
 * 1）遍历方向和单链表一样，只是可以向前，也可以向后
 * 2）添加(默认添加到双链表的最后)
 *      (1)先找到双向链表的最后这个节点temp
 *      (2)temp.next=newHeroNode
 *      (3)newHeroNode.pre=temp;
 * 3) 修改思路和原理和单向链表一样
 * 4）删除
 *      (1) 因为是双向链表，因此，我们可以实现自我删除某个节点
 *      (2) 直接找到要删除的这个节点，比如temp
 *      (3) temp.next.pre=temp.pre;
 *      (4) temp.pre.next=temp.next;
 */
//创建一个双向链表的类
class DoubleLinkedList{
    //初始化头节点
    private HeroNode2 head=new HeroNode2();

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表的方法
    public void list(){
        //先判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp=head;
        while (temp.next!=null){
            System.out.println(temp.next);
            temp=temp.next;
        }
    }

    //添加(默认添加到链表的最后)
    public void add(HeroNode2 heroNode){
        //因为head节点不能动，因此我们需要一个辅助节点temp
        HeroNode2 temp=head;
        //遍历找到最后
        while (temp.next!=null){
            temp=temp.next;
        }
        //当退出while循环时，temp指向链表的最后节点
        //形成一个双向链表
        temp.next=heroNode;
        heroNode.pre=temp;
    }

    //修改一个节点的内容，可以看到双向链表的内容修改和单向链表一样
    public void update(HeroNode2 newHeroNode){
        //判断是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp=head.next;
        boolean flag=false;//标识是否找到该节点
        while (temp!=null){
            if(temp.no==newHeroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //根据flag判断是否找到需要修改的节点
        if(flag){
            temp.nickName=newHeroNode.nickName;
            temp.name=newHeroNode.name;
        }else { //没有找到
            System.out.println("没有找到编号为"+newHeroNode.no+"的节点");
        }
    }

    //从双向链表删除一个节点
    //说明
    //1、对应双向链表，我们可以直接找到删除的这个节点
    public void del(int no){

        //判断当前链表是否为空
        if(head.next==null){//空链表
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp=head.next;
        boolean flag=false;
        while (temp!=null){
            if(temp.no==no){//注意这里不能写成temp.no,必须这样写
                //找到了待删除节点的前一个节点
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){//如果找到
            temp.pre.next=temp.next;
            //这里的代码有问题，temp.next可能为null
            //如果是最后一个节点，就不需要执行下面的语句，否则会出现空指针
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }else {
            System.out.println("没有要删除的节点");
        }
    }
}

class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 pre;  //指向前一个节点，默认为null
    public HeroNode2 next; //指向下一个节点，默认为null

    public HeroNode2() {
    }

    //构造器
    public HeroNode2(int no,String name,String nickName){
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'';
    }
}
