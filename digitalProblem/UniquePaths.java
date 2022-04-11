package leetcode.digitalProblem;

public class UniquePaths {

    public int uniquePaths(int m, int n){
//        int[][] dp = new int[m][n];
//        dp[m - 1][n - 1] = 1;
//        return process1(m, n, 0, 0, dp);

        //动态规划
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for(int i = 0; i < m - 1; i++){
            dp[i][n - 1] = 1;
        }
        for(int i = 0; i < n - 1; i++){
            dp[m - 1][i] = 1;
        }

        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    //记忆化
    private int process1(int m, int n, int curM, int curN, int[][] dp){
        if (dp[curM][curN] != 0) return dp[curM][curN];
        if (curM == m - 1 || curN == n - 1) return 1;
        else return process1(m, n, curM + 1, curN, dp) + process1(m, n, curM, curN + 1, dp);
    }

    //暴力
    private int process(int m, int n, int curM, int curN){
        if (curM == m - 1 || curN == n - 1) return 1;
        else return process(m, n, curM + 1, curN) + process(m, n, curM, curN + 1);
    }
}
