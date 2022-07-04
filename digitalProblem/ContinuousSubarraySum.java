package leetcode.digitalProblem;

import java.util.HashMap;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k){
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i - 1];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i < nums.length; i++){
            int left = nums[i] % k;
            if (map.containsKey(left)){
                Integer index = map.get(left);
                if (i - index >= 2) return true;
            } else{
                map.put(left, i);
            }
        }

        return false;
    }

//    public boolean checkSubarraySum(int[] nums, int k) {
//        int[] tem = new int[nums.length + 1];
//        //前缀和
//        for(int i = 0; i < nums.length; i++){
//            tem[i+1]=tem[i]+nums[i];
//        }
//        System.out.println(Arrays.toString(tem));
//
//        for(int i = 0; i < tem.length; i++){
//            for(int j = i+2; j < tem.length; j++){
//                if ((tem[j]-tem[i])%k==0) return true;
//            }
//        }
//        return false;
//    }
}
