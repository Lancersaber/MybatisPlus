package com.lancer.simpleSorting;

public class BaseClass {
    public long[] a; //ref to array a
    public int nElems; //number of data items
    //---------------------------------
    public BaseClass(int max){     //constructor
        a=new long[max];    //create the array
        nElems=0;           //no items yet
    }

    //----------------------------------
    public void insert(long value){     //put element into array
        a[nElems++]=value;
    }
    //--------------------------------------
    public void display(){      //displays array contents
        for(int j=0;j<nElems;j++){
            System.out.print(a[j]+ " ");//display it
        }
        System.out.println(" ");
    }
    //----------------------------------------
    public void bubbleSort1(){  //core of the class
        int out;
        int times=nElems;
        for(int i=0;i<nElems;i++){
            out=i;
            for(int j=i+1,in=j;j<times;j++){
                if(a[in]<a[out]){
                    swap(in,out);
                }
            }
            System.out.println(a[times-1]);
            times--;
        }
    }

    //------------------------------
    public void initArray(){
        long rand=0;
        for(int i=0;i<getLength();i++){
            rand=(long) (Math.random()*100);
            insert(rand);
        }
    }

    private int getLength(){
        return a.length;
    }

    //交换传入参数的值
    public void swap(int x,int y){
        long temp=a[x];
        a[x]=a[y];
        a[y]=temp;
    }
}
