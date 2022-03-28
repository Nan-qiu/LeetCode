package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindtheDifferenceofTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1,int[] nums2){
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> inNum1 = new HashSet<>();
        HashSet<Integer> inNum2 = new HashSet<>();

        ArrayList<Integer> ans2 = new ArrayList<>();
        ArrayList<Integer> ans1 = new ArrayList<>();
        for(int i : nums1){
            inNum1.add(i);
        }
        for(int i : nums2){
            inNum2.add(i);
            if (!ans2.contains(i)){
                if (!inNum1.contains(i)) ans2.add(i);
            }

        }
        for(int i : nums1){
            if (!ans1.contains(i)){
                if (!inNum2.contains(i)) ans1.add(i);
            }
        }
        res.add(ans1);
        res.add(ans2);
        return res;
    }
}
