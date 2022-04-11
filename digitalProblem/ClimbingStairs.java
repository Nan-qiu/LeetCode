package leetcode.digitalProblem;

public class ClimbingStairs {

    //dynamic
    public int climbStairs(int n){
//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//        dp[n - 1] = 1;
//        return process1(n, 0, dp);
        if (n == 1) return 1;
        //出生位置要占一格
        int[] dp = new int[n + 1];
        //终点位置为1
        dp[n] = 1;
        //倒数第二位置也为1
        dp[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--){
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        return dp[0];
    }

    //memory search
    private int process1(int n, int step, int[] dp){
        if (step == n) return 1;
        else if (step > n) return 0;
        if (dp[step] != -1) return dp[step];
        dp[step] = process1(n, step + 1, dp) + process1(n, step + 2, dp);
        return dp[step];
    }

    //force
    private int process(int n, int step){
        if (step == n) return 1;
        else if (step > n) return 0;
        return process(n, step + 1) + process(n, step + 2);
    }
}
