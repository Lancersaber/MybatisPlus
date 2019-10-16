package com.atguigu.linkedlist;
/**
 * 构建一个单向的环形链表思路
 * 1、先创建第一个结点，让first指向该结点，并形成环形
 * 2、后面当我们每创建一个新的结点，就把该结点加入到已有的环形链表中即可。
 *
 * 遍历环形链表
 * 1、先让一个辅助指针(变量)，指向first结点
 * 2、然后通过一个while循环遍历该环形链表即可（判断条件为curBoy.next!=first）
 */
//约瑟夫问题
public class Josepfu {
    public static void main(String[] args){
        //测试一把看构建和遍历是否oK
        CircleSingleLinkedList list=new CircleSingleLinkedList();
        int num=10;
        list.addBoy(num);
//        list.showBoy();
        list.countBoy(1,3,num);
    }
}
//创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建一个first结点，当前还没有编号
    private Boy first=new Boy();
    //添加小孩结点，构建成一个环形的链表
    public void addBoy(int nums){
        // 对 nums 做一个数据校验
        if (nums<1){
            System.out.println("编号不正确");
            return;
        }
        Boy curBoy=null;//辅助指针，帮助构建环形链表
        //使用for循环来创建环形链表
        for (int i=1;i<=nums;i++){
            //根据编号创建小孩结点
            Boy boy=new Boy(i);
            //如果是第一个小孩
            if (i==1){
                first=boy;
                first.setNext(first);//自身构成一个环状
                //让curBoy指向第一个小孩结点
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy(){
        //先判断链表是否为空
        if (first==null){
            System.out.println("没有任何小孩");
            return;
        }
        //因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy=first;
//        while (curBoy.getNext()!=first){
//            System.out.println("小孩的编号 "+curBoy.getNo());
//            curBoy=curBoy.getNext();//后移
//        }
        do {
            System.out.println("小孩的编号 "+curBoy.getNo());
            curBoy=curBoy.getNext();
        }while (curBoy!=first);
    }

    /**
     * 根据用户的输入，生成一个小孩出圈的顺序
     * 1、需要创建一个辅助指针helper,事先应该指向环形链表的最后这个结点
     * 2、在报数前，先让first和helper移动 startNo-1 次
     * 3、当小孩报数时，让first和helper指针同时移动 countNum-1 次
     * 4、这时可以将first指向的小孩结点出圈
     * first=first.next;
     * helper.next=first;
     * 原来first指向的结点就没有任何引用，就会被回收
     */
    //根据用户输入，计算出小孩出圈的顺序

    /**
     *
     * @param startNo   表示从第几个小孩开始数
     * @param countNum  表示数几下
     * @param nums      表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        //先对数据进行校验
        if (first==null||startNo<1||startNo>nums){
            System.out.println("数据不合理");
            return;
        }
        //创建一个辅助指针，帮助完成小孩出圈
        Boy helper=first;
        //1、需要创建一个辅助指针helper,事先应该指向环形链表的最后这个结点
        while (helper.getNext()!=null && helper.getNext()!=first){
            helper=helper.getNext();
        }
        //2、在报数前，先让first和helper移动 startNo-1 次
        for (int i=0;i<startNo-1;i++){
            first=first.getNext();
            helper=helper.getNext();
        }
        //3、当小孩报数时，让first和helper指针同时移动 countNum-1 次,然后出圈
        //这里是一个循环操作，直到圈中只有一个结点
        while (helper!=first){ //helper和first指向同一个结点
            //让first和helper同时移动countNum-1 次,然后出圈
            for (int j=0;j<countNum-1;j++){
                first=first.getNext();
                helper=helper.getNext();
            }
            //这时first指向的结点，就是要出圈的小孩结点
            System.out.println("小孩"+first.getNo()+"出圈");
            //这时将first指向的小孩结点出圈
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的是"+first.getNo()+"号小孩");
    }
}


//创建一个Boy类，表示一个结点
class Boy{
    private int no;//编号
    private Boy next; //指向下一个结点，默认为null

    public Boy(){

    }

    public Boy(int no){
        this.no=no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

}
