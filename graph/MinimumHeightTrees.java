package leetcode.graph;

import java.util.*;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges){
        ArrayList<Integer> res = new ArrayList<>();
        if (n == 1){
            res.add(0);
            return res;
        }

        int[] degree = new int[n];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();

        //初始化
        for(int[] edge : edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        //把度数为1 的叶子节点放入queue
        for(int i = 0; i < degree.length; i++){
            if (degree[i] == 1) queue.add(i);
        }

        while (queue.size() > 0) {
            res.clear();
            int size = queue.size();
            //把queue里叶子节点依次弹出，若叶子节点的邻居节点--为1，则把邻居节点加入queue
            for(int i = 0; i < size; i++){
                Integer poll = queue.poll();
                res.add(poll);
                HashSet<Integer> set = map.get(poll);
                for(Integer integer : set){
                    degree[integer]--;
                    if (degree[integer] == 1){
                        queue.add(integer);
                    }
                }
            }
        }
        return res;
    }

}
