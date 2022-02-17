package leetcode.digitalProblem;

public class KnightProbabilityInChessboard {
    public static void main(String[] args){
        System.out.println(knightProbability1(3,2,0,0));
    }

    private static final int[][] DIRS = {{2,-1},{2,1},{-2,1},{-2,-1},{1,-2},{-1,-2},{-1,2},{1,2}};

    //----------------------------------------------------------------------
    //经典dfs
    public static double knightProbability(int n,int k,int row,int column){
        return dfs(n,k,row,column);
    }

    private static double dfs(int n,int k,int row,int column){
        if (row < 0 || row >= n || column < 0 || column >= n) return 0;
        if (k == 0) return 1;
        double res = 0;

        for(int[] dir : DIRS){
            res += dfs(n,k - 1,row + dir[0],column + dir[1]) / 8.0;
        }
//        res+=dfs(n,k - 1,row + 2,column - 1)/8.0;
//        res+=dfs(n,k - 1,row + 2,column + 1)/8.0;
//        res+=dfs(n,k - 1,row - 2,column + 1)/8.0;
//        res+=dfs(n,k - 1,row - 2,column - 1)/8.0;
//        res+=dfs(n,k - 1,row + 1,column - 2)/8.0;
//        res+=dfs(n,k - 1,row - 1,column - 2)/8.0;
//        res+=dfs(n,k - 1,row - 1,column + 2)/8.0;
//        res+=dfs(n,k - 1,row + 1,column + 2)/8.0;
        return res;
    }

    //--------------------------------------------------------------
    //记忆化搜索
    public static double knightProbability1(int n,int k,int row,int column){
        //memo为dfs的缓存
        double[][][] memo = new double[n][n][k + 1];
        return dfs1(n,k,row,column,memo);
    }

    private static double dfs1(int n,int k,int row,int column,double[][][] memo){
        if (row < 0 || row >= n || column < 0 || column >= n) return 0;
        if (k == 0) return 1;
        double res = 0;
        //如果有值，则直接使用
        if (memo[row][column][k] != 0) return memo[row][column][k];

        for(int[] dir : DIRS){
            res += dfs1(n,k - 1,row + dir[0],column + dir[1],memo) / 8.0;
        }
        //把查出来的值放入缓存
        memo[row][column][k] = res;
        return res;
    }

    //--------------------------------------------------------------
    //动态规划 k从0开始变大
    public static double knightProbability2(int n,int k,int row,int column){
        double[][][] dp = new double[n][n][k + 1];
        for(int kk = 0; kk <= k; kk++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if (kk == 0) dp[i][j][kk] = 1;
                    else{
                        for(int[] dir : DIRS){
                            int lastI = i + dir[0];
                            int lastJ = j + dir[1];
                            if (lastI >= 0 && lastJ >= 0 && lastI < n && lastJ < n)
                                //当前格子的值由上一层的格子决定
                                dp[i][j][kk] += dp[lastI][lastJ][kk - 1]/8.0;
                        }
                    }
                }
            }
        }
        return dp[row][column][k];
    }

}
