package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomPickIndex {
    HashMap<Integer, ArrayList<Integer>> map;
    Random random = new Random();

    public RandomPickIndex(int[] nums){
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                ArrayList<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            } else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
    }

    public int pick(int target){
        ArrayList<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
