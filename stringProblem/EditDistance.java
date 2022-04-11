package leetcode.stringProblem;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args){
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int[] ints : dp){
            Arrays.fill(ints, -1);
        }
        return process1(word1, word2, 0, 0, dp);
    }

    //memory search
    private int process1(String word1, String word2, int p, int q, int[][] dp){
        if (dp[p][q] != -1) return dp[p][q];
        if (p == word1.length() && q == word2.length()) return 0;
            //某一方达到边界时，另一方直接返回剩下的下标个数
        else if (p == word1.length()){
            dp[p][q] = word2.length() - q;
            return dp[p][q];
        } else if (q == word2.length()){
            dp[p][q] = word1.length() - p;
            return dp[p][q];
        }

        //当前下标的字符相等时，返回两个下标+1 位置的结果
        if (word1.charAt(p) == word2.charAt(q)) return process1(word1, word2, p + 1, q + 1, dp);
        //不相等，就返回三种操作的最小值
        //增
        int p1 = process1(word1, word2, p, q + 1, dp) + 1;
        //删
        int p2 = process1(word1, word2, p + 1, q, dp) + 1;
        //改
        int p3 = process1(word1, word2, p + 1, q + 1, dp) + 1;
        dp[p][q] = Math.min(p1, Math.min(p2, p3));
        return dp[p][q];
    }

    //force
    private int process(String word1, String word2, int p, int q){
        if (p == word1.length() && q == word2.length()) return 0;
            //某一方达到边界时，另一方直接返回剩下的下标个数
        else if (p == word1.length()) return word2.length() - q;
        else if (q == word2.length()) return word1.length() - p;

        //当前下标的字符相等时，返回两个下标+1 位置的结果
        if (word1.charAt(p) == word2.charAt(q)) return process(word1, word2, p + 1, q + 1);
        //不相等，就返回三种操作的最小值
        int res;
        //增
        int p1 = process(word1, word2, p, q + 1) + 1;
        //删
        int p2 = process(word1, word2, p + 1, q) + 1;
        //改
        int p3 = process(word1, word2, p + 1, q + 1) + 1;
        res = Math.min(p1, Math.min(p2, p3));
        return res;
    }

}
