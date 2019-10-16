package New.Graph;

//记录有向图的可达性
public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G,int s){ //从G 中找到从s 可达的所有顶点
        marked=new boolean[G.V()];
        dfs(G,s);
    }

    private void dfs(Digraph G,int v){
        marked[v]=true;
        for (int w:G.adj(v))
            if (!marked[w])
                dfs(G,w);
    }

    public boolean marked(int v){// v 是可达的吗
        return marked[v];
    }
}