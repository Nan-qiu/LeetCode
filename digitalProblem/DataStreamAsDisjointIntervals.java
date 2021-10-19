package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class DataStreamAsDisjointIntervals {
    public static void main(String[] args){
        SummaryRanges ranges = new SummaryRanges();
        ranges.addNum(1);
        System.out.println(Arrays.deepToString(ranges.getIntervals()));
        ranges.addNum(2);
        System.out.println(Arrays.deepToString(ranges.getIntervals()));
        ranges.addNum(3);
        System.out.println(Arrays.deepToString(ranges.getIntervals()));
        ranges.addNum(7);
        System.out.println(Arrays.deepToString(ranges.getIntervals()));
    }
}

class SummaryRanges {
    List<Integer> list;
    TreeSet<Integer> set;

    public SummaryRanges(){
        list = new ArrayList<>();
        set = new TreeSet<>();
    }

    public void addNum(int val){
        list.add(val);
        set.add(val);
    }

    public int[][] getIntervals(){
        List<int[]> res = new ArrayList<>();
        if (!list.isEmpty()){

            while (!set.isEmpty()) {
                int i = set.pollFirst();
                int j = i;
                while (set.contains(j + 1)) {
                    j = set.pollFirst();
                }
                res.add(new int[]{i,j});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}