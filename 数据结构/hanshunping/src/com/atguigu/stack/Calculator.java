package com.atguigu.stack;

import java.sql.SQLTransactionRollbackException;
import java.util.Stack;

/**
 * 使用栈完成计算一个表达式的结果
 * 7*2*2-5+1-5+3-4
 * 3+2*6-2
 *
 * 算法思路
 * 1、通过一个index值(索引)，来遍历我们的表达式
 * 2、如果我们发现是一个数字，就直接入数栈
 * 3、如果发现扫描到一个符号，就分如下情况
 * 3.1 如果发现当前的符号栈为空，就直接入栈
 * 3.2 如果发现符号栈有操作符，就进行比较，如果当前的操作符优先级小于或者等于栈中的操作符，
 * 就需要从数栈中pop出两个数，再从符号栈中pop出一个符号，进行运算，将得到的结果，入数栈。然后
 * 将当前扫描的操作符入符号栈。如果当前的操作符优先级大于或者等于栈中的操作符，就直接入栈。
 * 4 当表达式扫描完毕，就顺序地从数栈和符号栈中pop出相应的数和符号进行运算
 * 5 最后数栈只有一个数字，就是表达式结果的值
 */
public class Calculator {

    public static void main(String args[]){

        //中缀表达式
        String expression="300+2*7-2";
        //创建两个栈，一个数栈，一个字符栈
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> operStack = new Stack<>();

        //定义需要的相关变量
        int index=0;//用于扫描
        int num1=0; //存放数1
        int num2=0; //存放数2
        int oper=0; //存放运算符
        int res=0;  //存放运算结果
        char ch=' ';//将每次扫描得到的char保存到ch
        String num=""; //用于接收扫描到的多位数
        //开始while循环进行扫描
        while (true){
            //依次得到expression的每一个字符
            ch=expression.substring(index,index+1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if(isOper(ch)){//如果是运算符
                //判断当前符号栈是否为空
                if(!operStack.isEmpty()){
                    //进行处理
                    //3.2 如果发现符号栈有操作符，就进行比较，如果当前的操作符优先级小于或者等于栈中的操作符，
                    // 就需要从数栈中pop出两个数，再从符号栈中pop出一个符号，进行运算，将得到的结果，入数栈。然后
                    // 将当前扫描的操作符入符号栈。如果当前的操作符优先级大于或者等于栈中的操作符，就直接入栈。
                    if(priority(ch)<=priority(operStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=cal(num1,num2,oper);
                        //把运算结果入数栈
                        numStack.push(res);
                        //把当前扫描到的操作符放入符号栈
                        operStack.push((int)ch);
                    }else {
                        //如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
                        operStack.push((int)ch);
                    }
                }else {
                    //如果为空，直接入栈
                    operStack.push((int)ch);
                }
            }
            else { //如果是数，则直接入数栈
//                numStack.push((int)ch-48);
                //分析思路
                //1、当处理多位数时，不能发现是一个数就立即入栈，因为它可能是多位数
                //2、在处理数时，需要向expression的表达式的index后再看几位，如果是数就进行扫描，如果是符号才入栈
                //3、因此我们需要定义一个变量字符串，用于拼接
                num+=ch;

                //如果ch已经是expression的最后一位，则直接入栈
                if(index==expression.length()-1){
                    numStack.push(Integer.parseInt(num));
                }else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    if(isOper(expression.substring(index+1,index+2).charAt(0))){
                        //如果后一位是运算符，则入栈num
                        numStack.push(Integer.parseInt(num));
                        //重要步骤，清空num
                        num="";
                    }
                }
            }

            //让index+1，并判断是否扫描到expression的最后
            index++;
            if(index>=expression.length()){
                break;
            }
        }

        //当表达式扫描完毕，就顺序地从数栈和符号栈中pop出相应的数和符号进行运算
        while (true){
            //如果符号栈为空，则计算到最后的结果，数栈中只有一个数字
            if(operStack.isEmpty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=cal(num1,num2,oper);
            numStack.push(res);//入栈
        }
        System.out.println("表达式"+expression+"="+numStack.pop());
    }

    //返回运算符的优先级，优先级使用数字表示，数字越大，优先级越高
    public static int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;//假定目前的表达式只有+，-，*，/
        }
    }

    //判断字符是否为运算符
    public static boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }

    public static int cal(int num1,int num2,int oper){
        int res=0;//res 用于存放计算结果
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;//注意顺序，后弹出的数(num2)减去先弹出的数(num1)
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
        }
        return res;
    }

}
