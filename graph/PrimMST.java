package leetcode.graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimMST { // 先随机选一个点，然后在它所有的边里选权值最小的一个，指针来到这个边对应的点上，再选最小的边，若当前点在注册过的点集里，跳过，找没注册过的点

    public static Set<Edge> primMST(Graph graph){
        PriorityQueue<Edge> queue = new PriorityQueue<>(); // 边的小根堆，优先级队列
        HashSet<Node> set = new HashSet<>(); //点集
        HashSet<Edge> res = new HashSet<>(); //要返回的边集
        for(Node node:graph.nodes.values()){ // 把所有点都过完，防止没联通的图
            if (!set.contains(node)){
                set.add(node);
                queue.addAll(node.edges);// 解锁这个点周围的边
                while (!queue.isEmpty()){
                    Edge edge=queue.poll();//弹出最小的边
                    Node newNode=edge.to;// 把这个边对面的那个点给newNode
                    if (!set.contains(newNode)){
                        set.add(newNode);
                        res.add(edge);
                        queue.addAll(newNode.edges);//把新节点的所有边放入优先级队列
                    }
                }
            }
        }
        return res;
    }
}
