package leetcode.binaryTree;

import java.util.Arrays;

public class UniqueBinarySearchTrees {

    public int numTrees(int n){
        if (n == 0 || n == 1) return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return process1(n,dp);
    }

    private int process1(int n, int[] dp){
        if (dp[n]!=-1) return dp[n];
        if (n == 1 || n == 0){
            dp[n]=1;
            return 1;
        }
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            int left = process1(i - 1, dp);
            int right = process1(n - i, dp);
            cnt += left * right;
        }
        dp[n]=cnt;
        return cnt;
    }

    //force
    private int process(int n){
        if (n == 1 || n == 0) return 1;
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            int left = process(i - 1);
            int right = process(n - i);
            cnt += left * right;
        }
        return cnt;
    }
}
