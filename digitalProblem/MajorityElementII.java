package leetcode.digitalProblem;

import java.util.*;

public class MajorityElementII {
    public static void main(String[] args){
        int[] a={1,1,1,2,2,3,3,3};
        System.out.println(majorityElement(a));
    }
    public static List<Integer> majorityElement(int[] nums){
        int count = nums.length / 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int a : nums){
            if (!map.containsKey(a)){
                map.put(a,1);
            } else{
                map.computeIfPresent(a,(key,value) -> value + 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for(Map.Entry<Integer, Integer> s : entrySet){
            if (s.getValue() > count) list.add(s.getKey());
        }
        return list;
    }
}
