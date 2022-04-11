package leetcode.digitalProblem;

public class UniquePathsII {
    public static void main(String[] args){
        int[][] a = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsII uniquePathsII = new UniquePathsII();
        System.out.println(uniquePathsII.uniquePathsWithObstacles(a));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid){
//        int M = obstacleGrid.length;
//        int N = obstacleGrid[0].length;
//        if (obstacleGrid[0][0] == 1 || obstacleGrid[M - 1][N - 1] == 1) return 0;
//        int[][] dp = new int[M][N];
//        //初始化
//        for(int i = 0; i < M; i++){
//            for(int j = 0; j < N; j++){
//                dp[i][j] = -1;
//            }
//        }
//        return process1(obstacleGrid, M, N, 0, 0, dp);

        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[M - 1][N - 1] == 1) return 0;
        int[][] dp = new int[M][N];
        dp[M - 1][N - 1] = 1;

        //处理边
        for(int i = N - 2; i >= 0; i--){
            if (obstacleGrid[M - 1][i] != 1) dp[M - 1][i] = dp[M - 1][i + 1];
        }
        for(int i = M - 2; i >= 0; i--){
            if (obstacleGrid[i][N - 1] != 1) dp[i][N - 1] = dp[i + 1][N - 1];
        }

        //处理剩下的格子
        for(int i = M - 2; i >= 0; i--){
            for(int j = N - 2; j >= 0; j--){
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i][j + 1] + dp[i + 1][j];
            }
        }

        return dp[0][0];
    }

    //记忆化搜索
    private int process1(int[][] obstacleGrid, int m, int n, int curM, int curN, int[][] dp){
        if (dp[curM][curN] != -1) return dp[curM][curN];
        if (curM == m - 1 && curN == n - 1){
            dp[curM][curN] = 1;
            return 1;
        } else if (obstacleGrid[curM][curN] == 1){
            dp[curM][curN] = 0;
            return 0;
        } else if (curM == m - 1) return process1(obstacleGrid, m, n, curM, curN + 1, dp);
        else if (curN == n - 1) return process1(obstacleGrid, m, n, curM + 1, curN, dp);
        else{
            int i = process1(obstacleGrid, m, n, curM, curN + 1, dp) + process1(obstacleGrid, m, n, curM + 1, curN, dp);
            dp[curM][curN] = i;
            return i;
        }
    }

    //暴力
    private int process(int[][] obstacleGrid, int m, int n, int curM, int curN){
        if (curM == m - 1 && curN == n - 1) return 1;
        else if (obstacleGrid[curM][curN] == 1) return 0;
        else if (curM == m - 1) return process(obstacleGrid, m, n, curM, curN + 1);
        else if (curN == n - 1) return process(obstacleGrid, m, n, curM + 1, curN);
        else return process(obstacleGrid, m, n, curM, curN + 1) + process(obstacleGrid, m, n, curM + 1, curN);
    }

}
