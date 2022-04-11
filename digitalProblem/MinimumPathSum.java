package leetcode.digitalProblem;

public class MinimumPathSum {
    public static void main(String[] args){
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] a = {{1, 2}, {1, 1}};
        System.out.println(minimumPathSum.minPathSum(a));
    }

    //动态规划
    public int minPathSum(int[][] grid){
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[m][n];
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                dp[i][j] = -1;
//            }
//        }
//        int i = process1(grid, m, n, 0, 0, dp);
//        //int i = process(grid, m, n, 0, 0);
//        return i;

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        //边界处理
        for(int i = m - 2; i >= 0; i--){
            dp[i][n - 1] = dp[i + 1][n - 1] + grid[i][n - 1];
        }
        for(int i = n - 2; i >= 0; i--){
            dp[m - 1][i] = dp[m - 1][i + 1] + grid[m - 1][i];
        }
        //从倒数第二排开始
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = min + grid[i][j];
            }
        }
        return dp[0][0];
    }

    //记忆化搜索
    private int process1(int[][] grid, int m, int n, int curM, int curN, int[][] dp){
        if (dp[curM][curN] != -1) return dp[curM][curN];
        if (curM == m - 1 && curN == n - 1){
            dp[curM][curN] = grid[curM][curN];
            return grid[curM][curN];
        } else if (curM == m - 1){
            return process1(grid, m, n, curM, curN + 1, dp) + grid[curM][curN];
        } else if (curN == n - 1){
            return process1(grid, m, n, curM + 1, curN, dp) + grid[curM][curN];
        }

        int p1 = process1(grid, m, n, curM, curN + 1, dp);
        int p2 = process1(grid, m, n, curM + 1, curN, dp);
        dp[curM][curN] = Math.min(p1, p2) + grid[curM][curN];
        return dp[curM][curN];
    }

    //暴力递归
    private int process(int[][] grid, int m, int n, int curM, int curN){
        if (curM == m - 1 && curN == n - 1) return grid[curM][curN];
        else if (curM == m - 1){
            return process(grid, m, n, curM, curN + 1) + grid[curM][curN];
        } else if (curN == n - 1){
            return process(grid, m, n, curM + 1, curN) + grid[curM][curN];
        }

        int p1 = process(grid, m, n, curM, curN + 1);
        int p2 = process(grid, m, n, curM + 1, curN);
        return Math.min(p1, p2) + grid[curM][curN];
    }
}
