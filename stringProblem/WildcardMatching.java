package leetcode.stringProblem;

import java.util.Arrays;

public class WildcardMatching {
    public static void main(String[] args){
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("acdcb", "a*c?b"));
        //System.out.println(wildcardMatching.isMatch("acdcb", "a*"));
    }

    public boolean isMatch(String s, String p){
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        boolean[][] visited = new boolean[s.length() + 1][p.length() + 1];
        //return process1(s.toCharArray(), p.toCharArray(), dp, visited, 0, 0);
        process1(s.toCharArray(), p.toCharArray(), dp, visited,0,0);
        for(boolean[] booleans : dp){
            System.out.println(Arrays.toString(booleans));
        }
        return dp[0][0];
    }

    //暴力尝试
    private boolean process(char[] s, char[] p, int sIndex, int pIndex){
        if (s.length == sIndex && p.length == pIndex) return true;
        if (p.length == pIndex) return false;
        if (s.length == sIndex){
            for(int i = pIndex; i < p.length; i++){
                if (p[i] != '*') return false;
            }
            return true;
        }
        boolean res = false;
        if (s[sIndex] == p[pIndex] && process(s, p, sIndex + 1, pIndex + 1)) res = true;
        else if (p[pIndex] == '?' && process(s, p, sIndex + 1, pIndex + 1)) res = true;
        else if (p[pIndex] == '*'){
            //匹配空串
            if (process(s, p, sIndex, pIndex + 1)) res = true;
            //匹配一个字符
            if (process(s, p, sIndex + 1, pIndex + 1)) res = true;
            //匹配多个字符
            if (process(s, p, sIndex + 1, pIndex)) res = true;
        }

        return res;
    }

    //记忆化搜索
    private boolean process1(char[] s, char[] p, boolean[][] dp, boolean[][] visited, int sIndex, int pIndex){
        if (visited[sIndex][pIndex]) return dp[sIndex][pIndex];
        if (s.length == sIndex && p.length == pIndex) return true;
        if (p.length == pIndex) return false;
        if (s.length == sIndex){
            for(int i = pIndex; i < p.length; i++){
                if (p[i] != '*') return false;
            }
            return true;
        }
        boolean res = false;
        if (s[sIndex] == p[pIndex] && process1(s, p, dp, visited, sIndex + 1, pIndex + 1)) res = true;
        else if (p[pIndex] == '?' && process1(s, p, dp, visited, sIndex + 1, pIndex + 1)) res = true;
        else if (p[pIndex] == '*'){
            //匹配空串
            if (process1(s, p, dp, visited, sIndex, pIndex + 1)) res = true;
            //匹配一个字符
            if (process1(s, p, dp, visited, sIndex + 1, pIndex + 1)) res = true;
            //匹配多个字符
            if (process1(s, p, dp, visited, sIndex + 1, pIndex)) res = true;
        }

        dp[sIndex][pIndex] = res;
        visited[sIndex][pIndex] = true;
        return res;
    }
}
