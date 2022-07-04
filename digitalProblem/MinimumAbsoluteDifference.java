package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr){
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i < arr.length; i++){
            int sub = arr[i] - arr[i - 1];
            if (sub < min){
                min = sub;
                res.clear();
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);
                res.add(list);
            } else if (sub == min){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);
                res.add(list);
            }
        }

        return res;
    }
}
