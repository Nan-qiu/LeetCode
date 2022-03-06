package leetcode.digitalProblem;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentNumberFollowingKeyInAnArray {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length-1; i++){
            if (nums[i]==key){
                if (map.containsKey(nums[i+1])){
                    int n = map.get(nums[i+1]);
                    map.put(nums[i+1],n+1);
                }else {
                    map.put(nums[i+1],1);
                }
            }
        }
        int res=0;
        int max=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int k = entry.getKey();
            int v = entry.getValue();
            if (max<v){
                res=k;
                max=v;
            }
        }
        return res;
    }
}
