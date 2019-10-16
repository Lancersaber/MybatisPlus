package 第14章类型信息.proxy.myownproxy.MyTest;

import java.util.Arrays;

public class Shell {

//    public boolean test(){
//        return 1==1;
//    }
//
//    public void test01(){
//        assert test();
//    }

    public static void main(String[] args){
        int arr[]={9,8,7,6,5,4,3,2,100,21,45,56,11,0,9,1,0};

        int h=1;
        int N=arr.length;
        while (h<N/3){
            h=3*h+1;
        }
        System.out.println("h="+h);

//        while (h>=1){
//            for (int i=h;i<N;i++){
//                int target=arr[i];
//                int targetIndex=i;
//                for (int j=i;j>=h;j-=h){
//                    arr[j]=arr[j-h];
//                    while (targetIndex>=h && arr[targetIndex-h] >target){
//
//                    }
//                }
//            }
//        }



        while (h>=1){
            for (int i=h;i<N;i++){
//                System.out.println("i = "+i);
                int targetIndex=i;//保留目标数的下标，先假设为i
                int target=arr[i]; //将目标值保留下来
                arr[i]=arr[i-h];  //必须在 target=arr[i]后
                for (int j=i-h;j>=0;j-=h){ //注意j>=0 需要带等于号
                    while (targetIndex>=h && arr[targetIndex-h]>target){
                        arr[targetIndex]=arr[targetIndex-h];
                        targetIndex-=h;
                    }
                    arr[targetIndex]=target;
                }
            }
            System.out.println(Arrays.toString(arr));
            h/=3;
        }


        //第一轮排序
        /*for (int i=1;i<N;i++){
            int target=arr[i];
            int index=i-1;
            arr[index+1]=arr[index];
            while (index>0&&arr[index]>target){
                arr[index]=arr[index-1];
                index--;
            }
            arr[index]=target;
            System.out.println("第 "+i+" 轮排序");
            System.out.println(Arrays.toString(arr));
        }*/

    }
}
