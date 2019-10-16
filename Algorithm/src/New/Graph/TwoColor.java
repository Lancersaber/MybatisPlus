package New.Graph;

//使用深度优先搜索判断图 G 是否为二分图。
public class TwoColor {

    public static void main(String[] args){
        Graph graph=new Graph(13);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,6);
        graph.addEdge(0,5);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);

        graph.addEdge(7,8);
        graph.addEdge(9,10);
        graph.addEdge(9,11);
        graph.addEdge(9,12);
        graph.addEdge(11,12);

        TwoColor twoColor=new TwoColor(graph);
        boolean bipartite = twoColor.isBipartite();
        System.out.println("这个图是一个二分图 ："+bipartite);
    }

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable=true;

    public TwoColor(Graph G){
        marked=new boolean[G.V()] ;
        color=new boolean[G.V()];
        for (int s=0;s<G.V();s++){
            if (!marked[s])
                dfs(G,s);
        }
    }

    private void dfs(Graph G,int v){
        marked[v]=true;
        for (int w:G.adj(v)){ //w 为 与 v 相连的顶点
            if(!marked[w]){
                color[w]=!color[v];
                dfs(G,w);
            }
            else if (color[w]==color[v])
                isTwoColorable=false;
        }
    }

    public boolean isBipartite(){
        return isTwoColorable;
    }
}
