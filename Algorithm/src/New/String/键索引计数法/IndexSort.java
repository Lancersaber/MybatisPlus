package New.String.键索引计数法;

import java.util.Arrays;

//键索引计数法，适用于小整数键的简单排序方法
public class IndexSort {

    public static void main(String[] args){
        Student[] students=new Student[20];
        students[0]=new Student("Anderson",2);
        students[1]=new Student("Brown",3);
        students[2]=new Student("Davis",3);
        students[3]=new Student("Garcia",4);
        students[4]=new Student("Harris",1);
        students[5]=new Student("Jackson",3);
        students[6]=new Student("Johnson",4);
        students[7]=new Student("Jones",3);
        students[8]=new Student("Martin",1);
        students[9]=new Student("Martinez",2);
        students[10]=new Student("Miller",2);
        students[11]=new Student("Moore",1);
        students[12]=new Student("Robinson",2);
        students[13]=new Student("Smith",4);
        students[14]=new Student("Taylor",3);
        students[15]=new Student("Thomas",4);
        students[16]=new Student("Thompson",4);
        students[17]=new Student("White",2);
        students[18]=new Student("Williams",3);
        students[19]=new Student("Wilson",4);

        sort(students);
        for (Student student: students){
            System.out.println(student);
        }
    }

    public static void sort(Student[] a){
        int count[]=new int[6];//这里count的数组大小应该为数组a 中组数的最大值 + 2

        for (int i=0;i<a.length;i++){ //记录频率
            count[a[i].key()+1]++;
        }

        System.out.println(Arrays.toString(count));

        for (int r=0;r<5;r++){ //将频率转换为起始索引
            count[r+1]+=count[r];
        }
        System.out.println(Arrays.toString(count));

        Student[] aux=new Student[a.length];
        //将元素分类
        for (int i=0;i<a.length;i++){
            aux[count[a[i].key()]++]=a[i];
        }

        //回写
        for (int i=0;i<a.length;i++){
            a[i]=aux[i];
        }
    }
}
