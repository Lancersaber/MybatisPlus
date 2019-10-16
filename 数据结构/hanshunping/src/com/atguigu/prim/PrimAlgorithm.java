package com.atguigu.prim;


import java.util.Arrays;

public class PrimAlgorithm {

    public static void main(String[] args){
        //测试图是否创建成功
        char[] data=new char[]{'A','B','C','D','E','F','G'};
        int vertexs=data.length;
        //邻接矩阵的关系使用二维数组表示

    }
}

//创建最小生成树-->村庄的图
class MinTree{
    //创建图的邻接矩阵

    /**
     *
     * @param graph     图对象
     * @param vertexs   图对应的顶点个数
     * @param data      图的各个顶点的值
     * @param weight    图的邻接矩阵
     */
    public void createGraph(MGraph graph,int vertexs,char data[],int[][] weight){
        int i,j;
        for (i=0;i<vertexs;i++){
            graph.data[i]=data[i];
            for (j=0;j<vertexs;j++){
                graph.weight[i][j]=weight[i][j];
            }
        }
    }

    //显示图的方法
    public void showGraph(MGraph graph){
       for (int [] link:graph.weight){
           System.out.println(Arrays.toString(link));
        }
    }

    //编写一个Prim算法，得到最小生成树

    /**
     *
     * @param graph 目标图
     * @param v     表示从图的第几个顶点开始生成
     */
    public void prim(MGraph graph,int v){
        //标记顶点是否被访问过，默认元素值都为0，表示没有访问过
        int[] visited = new int[graph.vertexs];

        //把当前这个结点标记为已访问
        visited[v]=1;
        //h1和h2记录两个顶点的下标
        int h1=-1;
        int h2=-1;
        int minWeight=10000;//将minWeight初始化为一个较大值，后面在遍历过程中，会被替换
        for (int k=1;k<graph.vertexs;k++){  //因为有graph.vertexs个顶点，普里姆算法结束后，有graph.vertexs-1条边

            //这个是确定每一次生成的子图和哪个结点的距离最近
            for (int i=0;i<graph.vertexs;i++){  // i 结点表示被访问过的结点
                for (int j=0;j<graph.vertexs;j++){  //j 结点表示还没有访问过的结点
                    if (visited[i]==1 && visited[j]==0 && graph.weight[i][j]<minWeight){
                        //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                        minWeight=graph.weight[i][j];
                        h1=i;
                        h2=j;
                    }
                }

                //找到一条边是最小的
                System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+">权值："+minWeight);
                //将当前这个结点标记为已经访问过
                visited[h2]=1;
                //重置minWeight
                minWeight=10000;
            }
        }
    }
}

class MGraph{
    int vertexs;//表示图的结点个数
    char[] data; //存放结点数据
    int[][] weight;//存放邻接矩阵

    public MGraph(int n){
        vertexs=n;
        data=new char[vertexs];
        weight=new int[vertexs][vertexs];
    }
}
