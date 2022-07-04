package leetcode.digitalProblem;

import java.util.Arrays;
import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums){
        int[] sum = new int[nums.length + 1];

        //生成数组前缀和，num=1时 +1, =-1时 -1
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 1) sum[i + 1] = sum[i] + 1;
            else sum[i + 1] = sum[i] - 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        //map.put(0,-1);
        System.out.println(Arrays.toString(sum));
        for(int i = 0; i < sum.length; i++){
            int cur = sum[i];
            if (map.containsKey(cur)){
                Integer index = map.get(cur);
                res = Math.max(res, i - index);
            } else{
                map.put(sum[i], i);
            }
        }
        return res;
    }
}
