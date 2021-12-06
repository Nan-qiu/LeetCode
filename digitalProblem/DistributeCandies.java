package leetcode.digitalProblem;

import java.util.HashSet;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        //int half=candyType.length/2;
        HashSet<Integer> set = new HashSet<>();
        for(int a:candyType){
            set.add(a);
            if(set.size()==candyType.length/2) break;
        }
        return Math.min(candyType.length/2,set.size());
    }
}
