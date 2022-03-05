package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args){
//        int[][] ints = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ints = {{1,4},{0,2},{3,5}};
        System.out.println(Arrays.deepToString(merge(ints)));
    }

    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals,(h1,h2) -> h1[0] == h2[0] ? h1[1] - h2[1] : h1[0] - h2[0]);
        System.out.println(Arrays.deepToString(intervals));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(intervals[0][0]);
        list.add(intervals[0][1]);
        int listIndex = 1;
        int count = 1;
        int temp = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if (temp >= intervals[i][0]){
                if (temp < intervals[i][1]){
                    temp = intervals[i][1];
                    list.remove(listIndex);
                    list.add(intervals[i][1]);
                }
            } else{
                temp=intervals[i][1];
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
                count++;
                listIndex += 2;
            }
        }
        int[][] res = new int[count][2];
        boolean flag = true; //true第一个，false第二个
        for(int i = 0; i < list.size(); i++){
            if (flag) res[i / 2][0] = list.get(i);
            else res[i / 2][1] = list.get(i);
            flag = !flag;
        }
        return res;
    }
}
