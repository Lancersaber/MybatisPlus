package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前缀表达式(波兰表达式)
 *      运算符在前面，数字在后面，扫描方式为从右至左扫描，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，
 * 用运算符对它们做相应的计算(栈顶元素和次顶元素)，并将结果入栈，重复上述过程直至表达式最左端，最后运算得出的值即为表达式的结果。
 *
 * 后缀表达式(逆波兰表达式)
 *      后缀表达式又称为逆波兰表达式，与前缀表达式相似，只是运算符位于操作数之后
 *  后缀表达式的计算机求值
 *      从左至右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算(次顶元素和栈顶元素)，
 *  并将结果入栈，重复上述过程直到表达式右端，最后运算得出的值即为表达式的结果。
 */
public class PolandNotation {

    public static void main(String args[]){
        /*
        //先定义一个逆波兰表达式
        //为了方便，逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression="3 4 + 5 * 6 -";
        //思路
        //1、先将"3 4 + 5 * 6 -"==》ArrayList中
        //2、将ArrayList传递给一个方法，配合栈完成计算
        List<String> listString = getListString(suffixExpression);
        int calculate = calculate(listString);
        System.out.println(suffixExpression+" = "+calculate);*/
        ArrayList<String> arrayList = parseSuffixExpression("1+((2+3)*4)-5");
        System.out.println("arrayList="+arrayList);
    }

    //将一个逆波兰表达式依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将suffixExpression 按照空格分割
        String[] s = suffixExpression.split(" ");
        List<String> list=new ArrayList<>();
        for (String string:s){
            list.add(string);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    public static int calculate(List<String> ls){
        //创建一个栈，只需要一个栈
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item:ls){
            //这里使用正则表达式来取出数
            if (item.matches("\\d+")){ //匹配的是多位数
                //入栈
                stack.push(item);
            }else {
                //pop出两个数并运算，再入栈
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if(item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res=num1-num2;
                }else if(item.equals("*")){
                    res=num1*num2;
                }else if(item.equals("/")){
                    res=num1/num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(""+res);
            }
        }

        //最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }
    /**
     * 如何将中缀表达式转换成为后缀表达式
     * 1、初始化两个栈：运算符栈s1和存储中间结果的栈s2
     * 2、从左至右扫描中缀表达式
     * 3、遇到操作数时，将其压入s2
     * 4、遇到运算符时，比较其与s1栈顶运算符的优先级(括号不算是运算符)
     * 4.1、如果s1为空，或栈顶运算符为左括号'(' ,则直接将此运算符入栈
     * 4.2、否则，若优先级比栈顶运算符的高，也将运算符压入s1
     * 4.3、否则，将s1栈顶的运算符弹出并压入到s2中，再次转到4.1与s1中新的栈顶运算符相比较
     * 5、遇到括号时
     * 5.1、如果是左括号，则直接压入栈s1
     * 5.2、如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃。
     * 6、重复步骤2至5，直至表达式的最右边
     * 7、将s1中剩余的运算符依次弹出压入s2
     * 8、依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     */
    //完成将一个中缀表达式转成后缀表达式的功能
    //说明
    //1、1+((2+3)*4)-5 ==> 转成1 2 3 + 4 * + 5 -
    //2、因为直接对一个字符串进行操作不方便，因此先将“1+((2+3)*4)-5”==>中缀表达式对应的list
    //3、将得到的中缀表达式对应的List==>后缀表达式对应的List

    public static ArrayList<String> parseSuffixExpression(String expression){
        ArrayList<String> list = toInfixExpression(expression);
        System.out.println("list="+list);
        //定义两个栈
        Stack<String> s1=new Stack<>(); //符号栈
        //说明：因为s2这个栈，在整个转换过程中，没有pop操作，而且后面还需要进行逆序操作
        //因此比较麻烦，这里我们不用stack，直接使用ArrayList
        ArrayList<String> arrayList=new ArrayList<>();
        System.out.println(list.size());

        //遍历list
        for (String item:list){
            //如果是一个数，加入arrayList
            if (item.matches("\\d+")){
                arrayList.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                //如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃。
                while (!s1.peek().equals("(")){
                    arrayList.add(s1.pop());
                }
                s1.pop();//将这个小括号弹出，消除小括号
            }else {
                //当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，再次转到4.1与s1中新的栈顶运算符相比较
                while (s1.size()!=0 && Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    //在运算时，先进arrayList的运算符先被执行运算，也即优先级越高
                    arrayList.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出压入到arrayList中
        while (s1.size()!=0){
            arrayList.add(s1.pop());
        }
        return arrayList;//因为是存放到list中，而不是stack中，因此按顺序输出即可
    }

    //方法：将中缀表达式转成对应的list
    public static ArrayList<String> toInfixExpression(String s){
        //定义一个List，存放中缀表达式对应的内容
        ArrayList<String> list=new ArrayList<>();
        int i=0;//这相当于指针，用于遍历中缀表达式的字符串
        String str; //做多位数的拼接工作
        char c;//每遍历到一个字符，就放入c中
        do {
            //如果c非数字，就需要加入list中
            if ((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                list.add(""+c);
                i++;//i需要后移
            }else {//c为数字时，需要考虑拼接
                //先将str置空
                str="";
                while (i<s.length()&&((c=s.charAt(i))>=48&&(c=s.charAt(i))<=57)){
                    str+=c;//拼接
                    i++;
                }
                list.add(str);
            }
        }while (i<s.length());
        return list;
    }
}

//编写一个类，可以返回一个运算符对应的优先级
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;
    private static int ZUO=0;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation){
        int result=0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
            case "(":
                result=ZUO;
                break;
             default:
                 System.out.println("不存在该运算符");
                 break;
        }
        return result;
    }
}
