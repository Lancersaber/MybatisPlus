package New.Graph;

import java.util.Arrays;
//可以用于判断两个点是否连通
public class DepthFirstSearch {

    public static void main(String[] args){
        Graph graph=new Graph(7);
        graph.setE(8);
        graph.addEdge(0,1);
        graph.addEdge(0,5);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        DepthFirstSearch depthFirstSearch=new DepthFirstSearch(graph,0);
        boolean[] marked = depthFirstSearch.getMarked();
        System.out.println(Arrays.toString(marked));
    }

    private boolean[] marked;
    private int count;

    //从 s 这个点开始进行深度搜索
    public DepthFirstSearch(Graph G,int s){
        marked=new boolean[G.V()];
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        marked[v]=true;
        count++;
        for (int w: G.adj(v)){
            if (!marked[w]) dfs(G,w);
        }
    }

    public boolean[] getMarked(){
        return marked;
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }
}
