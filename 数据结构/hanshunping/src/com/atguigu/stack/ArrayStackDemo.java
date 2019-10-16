package com.atguigu.stack;

import java.lang.reflect.Array;

public class ArrayStackDemo {

    public static void main(String args[]){
        ArrayStack stack=new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.list();
    }

}

//定义一个ArrayStack 表示栈

/**
 * 思路：
 * 1、使用数组来模拟栈
 * 2、定义一个top来表示栈
 * 3、入栈的操作，当有数据加入到栈时，top++;stack[top]=data
 * 4、出栈的操作，int value=stack[top];top--;return value;
 */
class ArrayStack{
    private int maxSize; //栈的大小
    private int[] stack; //数组，数组模拟栈，数据就放在该数组中
    private int top=-1; //top指向栈顶，初始值为-1

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top==maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top==-1;
    }

    //入栈
    public void push(int value){
        //先判断栈是否满
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }

    //出栈-pop,将栈顶的数据返回
    public int pop(){
        //先判断栈是否空
        if(isEmpty()){
            //异常处理
            throw new RuntimeException("栈为空");
        }
        int value=stack[top];
        top--;
        return value;
    }

    //遍历栈,遍历时，需要从栈顶开始显示数据
    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有数据~~");
            return;
        }
        for(int i=top;i>=0;i--){
            System.out.print(stack[i]+" ");
        }
    }

}
