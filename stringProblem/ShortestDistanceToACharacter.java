package leetcode.stringProblem;

import java.util.Arrays;

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c){
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        Arrays.fill(left, 10001);
        Arrays.fill(right, 10001);
        char[] chars = s.toCharArray();
        boolean f = false;
        int count = 0;
        for(int i = 0; i < chars.length; i++){
            if (chars[i] == c){
                left[i] = 0;
                count = 0;
                f = true;
            } else{
                if (f) left[i] = ++count;
            }
        }
        f = false;
        count = 0;
        for(int i = chars.length - 1; i >= 0; i--){
            if (chars[i] == c){
                right[i] = 0;
                count = 0;
                f = true;
            } else{
                if (f) right[i] = ++count;
            }
        }

        int[] res = new int[right.length];
        for(int i = 0; i < res.length; i++){
            res[i] = Math.min(left[i], right[i]);
        }
        return res;
    }
}
