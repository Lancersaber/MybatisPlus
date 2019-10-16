package com.atguigu.queue;

public class CircleArrayQueueDemo {

    public static void main(String args[]){

    }
}
//循环队列
/**
 * 1、front变量的含义做一个调整：front就指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素
 * 2、rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定。
 * 3、当队列满时，条件为(rear+1)%(maxSize)==front
 * 4、当队列为空时，rear=front
 * 5、front初始值为0，rear的初始值也为0
 * 6、当我们这样分析后，队列中有效的数据的个数为(rear+ maxSize-front) % maxSize
 */

class CircleArray{
    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数据用于存放数据，模拟队列

    //创建队列的构造器
    public CircleArray(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        front=0; //指向队列头部，分析出front指向队列头的前一个位置
        rear=0; //指向队列尾的数据，即就是队列最后一个数据
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列已满，不能加入数据！！");
            return;
        }
        arr[rear]=n;
        //注意：这里必须考虑取模
        rear=(rear+1)%maxSize;
    }

    //数据出队列
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            //通过抛出异常来进行处理
            throw new RuntimeException("队列为空，不能取数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1、先把front对应的值保留到一个临时变量
        //2、将front后移
        //3、将临时保存的变量返回
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空的，无法遍历.");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素即可
        for(int i=front;i<(front+size());i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //显示队列的头数据，不是取出数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空！");
        }
        return arr[front];
    }

}

