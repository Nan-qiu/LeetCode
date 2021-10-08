package leetcode.digitalProblem;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaxNumber {
    public static void main(String[] args){
        int[] b = {-2147483648,1,1};
    }

    public static int thirdMax(int[] nums){
        PriorityQueue<Integer> frontHeap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int e : nums){
            if (set.contains(e)){
                continue;
            } else{
                frontHeap.add(e);
                set.add(e);
            }
            if (frontHeap.size() > 3){
                frontHeap.poll();
            }
        }
        if (frontHeap.size() != 3){
            int ans = 0;
            while (!frontHeap.isEmpty()) {
                ans = frontHeap.poll();
            }
            return ans;
        }
        return frontHeap.peek();
    }

}


