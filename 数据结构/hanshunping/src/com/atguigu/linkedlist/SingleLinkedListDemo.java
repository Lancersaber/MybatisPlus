package com.atguigu.linkedlist;

public class SingleLinkedListDemo {

    public static void main(String args[]){
        //进行测试
        //先创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList linkedList=new SingleLinkedList();
        //加入
        linkedList.addByOrder(heroNode1);
        linkedList.addByOrder(heroNode4);
        linkedList.addByOrder(heroNode3);
        linkedList.addByOrder(heroNode2);

        linkedList.list();
        linkedList.del(1);
        System.out.println("删除后");
        linkedList.list();
        int length = SingleLinkedList.getLength(linkedList.getHead());
        System.out.println("有效节点个数为"+length);

//        System.out.println("**************");
//        linkedList.reverse(linkedList.getHead());
//        linkedList.list();

    }
}

/**
 * 小结
 * 1）链表是以节点的方式来存储，链式存储
 * 2）每个节点包含data域，next域，指向下一个节点
 * 3) 链表的各个节点不一定是连续存储
 * 4）链表分带头节点的链表和没有头节点的链表，根据实际的需求来确定。
 */
//定义一个SingleLinkedList 管curHeroNode{no=4, name='林冲', nickName='豹子头'理
class SingleLinkedList{
    //先初始化一个头节点，头节点不要动.头节点不存放具体的数据
    private HeroNode head=new HeroNode();
    private HeroNode test=new HeroNode();

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){

        //因为head节点不能动，因此我们需要一个辅助节点temp
        HeroNode temp=head;
        //遍历找到最后
        while (temp.next!=null){
            temp=temp.next;
        }
        //当退出while循环时，temp指向链表的最后节点
        temp.next=heroNode;
    }

    public HeroNode getHead() {
        return head;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置(如果已经有这个排名，则给出提示信息，添加失败)
    public void addByOrder(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助节点temp
        //因为是单链表，因此我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp=head;
        boolean flag=false;//标识添加的编号是否存在，默认为false
        while (temp.next!=null){
            if(temp.next.no>heroNode.no){//位置找到，就在temp的后面插入
                break;
            }else if(temp.next.no==heroNode.no){
                flag=true;//说明编号已经存在
                break;
            }
            temp=temp.next;//后移，遍历当前链表
        }

        //判断flag的值
        if(flag){
            System.out.println("准备插入的英雄编号已经存在，不能添加");
        }else {
            //加入到链表中
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    //说明
    //1、根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head.next;
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

    //删除节点
    //思路
    //1、head节点不能动，因此我们需要一个temp辅助节点找到带删除节点的前一个节点
    //2、说明我们在比较时，是temp.next.no和需要删除的节点的no比较
    public void del(int no){
        HeroNode temp=head;
        boolean flag=false;
        while (temp.next!=null){
            if(temp.next.no==no){//注意这里不能写成temp.no,必须这样写
                //找到了待删除节点的前一个节点
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){//如果找到
            temp.next=temp.next.next;
        }else {
            System.out.println("没有要删除的节点");
        }
    }

    //遍历链表
    public void list(){
        //先判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp=head;
        while (temp.next!=null){
            System.out.println(temp.next);
            temp=temp.next;
        }
    }

    //方法：获取到单链表的节点的个数(如果是带头节点的链表，不统计头节点)
    /**
     *
     * @param head 链表的头节点
     * @return 链表中有效节点的个数
     */
    public static int getLength(HeroNode head){
        if(head.next==null){
            return 0;
        }
        HeroNode current=head.next;
        int length=0;
        while (current!=null){
            length++;
            current=current.next;
        }
        return length;
    }

    //查找单链表中的倒数第k个节点【新浪面试题】
    //思路
    //1、编写一个方法接收head节点，同时接收一个index
    //2、index 表示是倒数第index个节点
    //3、先把链表从头到尾遍历，得到链表的总长度
    //4、得到size后，我们从链表的第一个开始遍历(size-index)个
    //5、如果找打返回该节点，否则返回null
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        //判断如果链表为空，返回null
        if(head.next==null){
            return null;
        }
        //第一次遍历得到链表的长度
        int size=getLength(head);
        //第二次遍历size-index位置，就是我们倒数的第k个节点
        //先做一个index校验
        if(index<=0||index>size){
            return null;
        }
        //定义一个辅助变量,for循环定位倒数的index
        HeroNode current=head.next;
        for(int i=0;i<size-index;i++){
            current=current.next;
        }
        return current;
    }

    /**
     * 将单链表进行翻转
     * 思路：
     * 1、先定义一个结点reverseHead=new HeroNode();
     * 2、从头到尾遍历原来的链表，每遍历一个结点，就将其取出，并放在新的链表的最前端
     * 3、原来的链表的head.next=reverseHead.next
     */
    public static void reverseList(HeroNode head){
        //如果当前链表为空，或者只有一个结点，无需翻转
        if (head.next==null ||head.next.next==null){
            return;
        }
        //定义一个辅助指针，帮助我们遍历原来的链表
        HeroNode cur=head.next;
        HeroNode next=null;//指向当前结点的下一个结点
        HeroNode reverseHead=new HeroNode();

        //遍历原来的链表，每遍历一个结点，就将其取出，并放在新的链表的最前端
        while (cur!=null){
            next=cur.next;//先暂时保存当前结点的下一个结点，因为后面需要使用
            cur.next=reverseHead.next;//将cur的下一个结点指向新的链表的最前端
            reverseHead.next=cur;//
            cur=next;//让cur后移
        }
        //将head.next指向reverseHead.next,实现单链表的翻转
        head.next=reverseHead.next;
    }

}

//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;

    public HeroNode() {
    }

    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int no,String name,String nickName){
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
