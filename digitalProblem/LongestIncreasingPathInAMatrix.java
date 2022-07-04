package leetcode.digitalProblem;

import java.util.Arrays;

public class LongestIncreasingPathInAMatrix {

    public int longestIncreasingPath(int[][] matrix){
        int res = 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] ints : dp){
            Arrays.fill(ints, -1);
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                res = Math.max(dfs1(matrix, i, j, -1, dp), res);
            }
        }
        return res;
    }

    //暴力
    private int dfs(int[][] matrix, int x, int y, int pre){
        if (x >= matrix.length || x < 0 || y >= matrix[0].length || y < 0) return 0;
        if (matrix[x][y] <= pre) return 0;
        int p1 = dfs(matrix, x + 1, y, matrix[x][y]);
        int p2 = dfs(matrix, x, y + 1, matrix[x][y]);
        int p3 = dfs(matrix, x - 1, y, matrix[x][y]);
        int p4 = dfs(matrix, x, y - 1, matrix[x][y]);
        return Math.max(p1, Math.max(p2, Math.max(p3, p4))) + 1;
    }

    //记忆化
    private int dfs1(int[][] matrix, int x, int y, int pre, int[][] dp){

        if (x >= matrix.length || x < 0 || y >= matrix[0].length || y < 0) return 0;
        if (matrix[x][y] <= pre) return 0;
        if (dp[x][y] != -1) return dp[x][y];
        int p1 = dfs1(matrix, x + 1, y, matrix[x][y], dp);
        int p2 = dfs1(matrix, x, y + 1, matrix[x][y], dp);
        int p3 = dfs1(matrix, x - 1, y, matrix[x][y], dp);
        int p4 = dfs1(matrix, x, y - 1, matrix[x][y], dp);
        dp[x][y] = Math.max(p1, Math.max(p2, Math.max(p3, p4))) + 1;
        return dp[x][y];
    }

}
