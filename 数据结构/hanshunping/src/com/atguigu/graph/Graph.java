package com.atguigu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList;   //存储顶点的集合
    private int [][] edges;//存储图对应的临接矩阵
    private int numOfEdges;//表示边的数目
    //定义一个数组boolean[],记录某个结点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args){
        //测试
        int n=5; //结点的个数
        String vertexs[]={"A","B","C","D","E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环地添加结点
        for (String value:vertexs){
            graph.insertVertex(value);
        }
        //添加边

        graph.showGraph();
    }

    //构造器
    public Graph(int n){
        //初始化矩阵和ArrayList
        edges=new int[n][n];
        vertexList=new ArrayList<>(n);
        isVisited=new boolean[n];
        numOfEdges=0;
    }

    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //添加边
    /**
     *
     * @param v1    表示点的下标，即第几个顶点
     * @param v2    第二个顶点下标
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }

    //返回结点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //返回边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回结点i(下标) 对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }
    /**
     * 图遍历介绍
     *  所谓图的遍历，即是对结点的访问。一个图有那么多结点，如何遍历这些结点，需要制定策略，一般有两个访问策略1)深度优先遍历 2）广度优先遍历
     *
     * 图的深度优先搜索
     * 1) 深度优先遍历，从初始访问结点出发，初始访问结点可能有多个邻接结点，深度优先遍历的策略就是首先访问第一个邻接结点，然后再以这个被访问的
     * 邻接结点作为初始结点，访问它的第一个邻接结点，可以这样理解：每次都在访问完当前结点后首先访问当前结点的第一个邻接结点。
     * 2) 可以看到，这样的访问策略是优先往纵向挖掘深入，而不是对一个结点的所有邻接结点进行横向访问
     * 3) 显然，深度优先搜索是一个递归的过程
     *
     * 算法步骤
     * 1、访问初始结点v，并标记结点v为已访问
     * 2、查找结点v的第一个邻接结点w
     * 3、若w存在，则继续执行4，如果不存在，则回到第一步，将从v的下一个结点继续
     * 4、若w未被访问，对w进行深度优先遍历递归(即把w当做另一个v，然后进行步骤123)
     * 5、若w被访问，查找结点v的w邻接结点的下一个邻接结点，转到步骤3
     */
    //得到第一个邻接结点的下标

    /**
     *
     * @param index
     * @return  如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index){
        for (int j=0;j<vertexList.size();j++){
            if (edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标，来获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
        for (int j=v2+1;j<vertexList.size();j++){
            if (edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    //i 第一次就是0
    private void dfs(boolean[] isVisited,int i){
        //首先我们访问该结点，输出
        System.out.println(getValueByIndex(i)+"->");
        //将该结点设置未已经访问过
        isVisited[i]=true;
        //查找结点i的第一个邻接结点w
        int w=getFirstNeighbor(i);
        while (w!=-1){  //说明有邻接结点
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果w结点已经被访问过
            w=getNextNeighbor(i,w);
        }
    }

    //对dfs进行重载，遍历我们所有的结点并进行dfs
    public void dfs(){
        //遍历所有的结点，进行dfs[回溯]
        for (int i=0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }


    /**
     * 广度优先遍历基本思想(Broad First Search)
     * 类似于一个分层搜索的过程，广度优先遍历需要使用一个队列以保持访问过的结点的顺序，以便按这个顺序来访问这些结点的邻接结点。
     *
     * 广度优先遍历算法步骤
     * 1、访问初始结点v并标记结点v为已访问
     * 2、结点v入队列
     * 3、当队列非空时，继续执行，否则算法结束
     * 4、出队列，取得队头结点u
     */
    //对一个结点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited,int i){
        int u;//表示队列的头节点对应下标
        int w;//表示邻接结点下标
        //队列，结点访问的顺序
        LinkedList<Integer> queue = new LinkedList<>();
        //访问结点，输出结点信息
        System.out.print(getValueByIndex(i)+"==>");
        //标记为已访问
        isVisited[i]=true;
        //将结点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()){
            //取出队列的头结点下标
            u= queue.removeFirst();
            //得到第一个邻接点的下标w
            w=getFirstNeighbor(u);
            while (w!=-1){  //找到
                //是否访问过
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"==>");
                    //标记已经访问
                    isVisited[w]=true;
                    //入队列
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻接点
                w=getNextNeighbor(u,w);//体现广度优先搜索
            }
        }
    }

    //遍历所有的结点，都进行广度优先搜索
    public void bfs(){
        for (int i=0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }
}
