package leetcode.digitalProblem;

public class PathWithMaximumGold {
    private static final int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};

    public static int getMaximumGold(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        //记录被访问过的节点
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (grid[i][j] != 0) ans = Math.max(ans,dfs(grid,i,j,visited));
            }
        }
        return ans;
    }

    private static int dfs(int[][] grid,int i,int j,boolean[][] visited){
        if (grid[i][j] == 0 || visited[i][j]) return 0;
        //已访问
        visited[i][j] = true;
        int ans = 0;
        for(int[] ints : direct){
            int x = i + ints[0];
            int y = j + ints[1];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length){
                ans = Math.max(ans,dfs(grid,x,y,visited));
            }
        }

        visited[i][j] = false;

        return ans + grid[i][j];
    }
}
