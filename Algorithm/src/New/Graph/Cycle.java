package New.Graph;

//使用深度优先搜索判断图是否为无环图
public class Cycle {

    public static void main(String[] args){
        Graph graph=new Graph(13);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,6);
        graph.addEdge(0,5);
        graph.addEdge(1,2);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);

        graph.addEdge(7,8);
        graph.addEdge(9,10);
        graph.addEdge(9,11);
        graph.addEdge(9,12);
        graph.addEdge(11,12);

        Cycle cycle=new Cycle(graph);
        boolean b = cycle.HasCycle();
        System.out.println("HasCycle : "+b);
    }

    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G){
        marked=new boolean[G.V()];
        for (int s=0;s<G.V();s++){
            if (!marked[s])
            {
                dfs(G,s,s);
            }
        }
    }

    private void dfs(Graph G,int v,int u){
        marked[v]=true;
        for (int w:G.adj(v)){
            if (!marked[w])
                dfs(G,w,v);
            else if (w!=u)
                hasCycle=true;
        }
    }

    public boolean HasCycle(){
        return hasCycle;
    }

}
