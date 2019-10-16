package New.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//有向图中基于深度优先搜索的顶点排序
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre; //所有顶点的前序排列
    private Queue<Integer> post; //所有顶点的后序排列
    private Stack<Integer> reversePost; //所有顶点的逆后序排列

    public DepthFirstOrder(Digraph G){
        pre=new LinkedList<>();
        post=new LinkedList<>();
        reversePost=new Stack<>();

        marked=new boolean[G.V()];

    }


    private void dfs(Digraph G,int v){
        pre.add(v);
        marked[v]=true;

        for (int w:G.adj(v)){
            if (!marked[w])
                dfs(G,w);
        }

        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}
