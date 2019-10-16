package New.Graph;

//使用深度优先搜索找出图中的所有连通分量
public class CC {

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

        CC cc=new CC(graph);
        int count = cc.count();
        System.out.println("共有 " +count+" 个连通分量");
        boolean connected = cc.connected(0, 6);
        System.out.println("0 和 6 是 连通的吗："+connected);
        System.out.println("0 和 7 是 连通的吗："+cc.connected(0,7));
    }

    private boolean[] marked;
    private int[] id; //标识每个顶点所属哪个连通分量
    private int count;//用来标识有几个连通分量

    public CC(Graph G){
        marked=new boolean[G.V()];
        id=new int[G.V()];
        for (int s=0;s<G.V();s++){
            if (!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }

    private void dfs(Graph G,int v){
        marked[v]=true;
        id[v]=count;
        for (int w:G.adj(v)){
            if (!marked[w])
                dfs(G,w);
        }
    }

    public boolean connected(int v,int w){
        return id[v]==id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }
}
