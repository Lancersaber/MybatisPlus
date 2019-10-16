package New.Graph;

//拓扑排序
public class Topogical {
    private Iterable<Integer> order; //顶点的拓扑排序

    public Topogical(Digraph G){
        //使用 DirectedCycle 来确保 G 中没有环
        DirectedCycle cyclefinder=new DirectedCycle(G);
        if (!cyclefinder.hasCycle()){
            DepthFirstOrder dfs=new DepthFirstOrder(G);

            order=dfs.reversePost();
        }
    }

    public Topogical(EdgeWeightedDigraph G){

    }


    public Iterable<Integer> order() { //拓扑有序的所有顶点
        return order;
    }

    //G 是有向无环图吗
    public boolean isDAG(){
        return order!=null;
    }
}
