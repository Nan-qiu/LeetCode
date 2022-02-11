package leetcode.digitalProblem;

public class NumberOfEnclaves {
    public static void main(String[] args){
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));

    }


    static boolean flag = true;

    public static int numEnclaves(int[][] grid){
        //boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if (grid[i][j] != 0 ){
                    int cur = infect(grid,i,j);
                    res += flag ? cur : 0;
                    flag = true;
                }
            }
        }
        return res;
    }

    public static int infect(int[][] grid,int i,int j){
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length){
            flag = false;
            return 0;
        }
        if (grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int score=0;
        score+=infect(grid,i-1,j);
        score+=infect(grid,i+1,j);
        score+=infect(grid,i,j-1);
        score+=infect(grid,i,j+1);
        return score+1;
    }

//    private static int dfs(int[][] grid,boolean[][] visited,int i,int j){
//        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length){
//            flag = false;
//            return 0;
//        }
//        if (grid[i][j] == 0) return 0;
//        if (visited[i][j]) return 0;
//        int score = 0;
//        visited[i][j] = true;
//        score += dfs(grid,visited,i + 1,j);
//        score += dfs(grid,visited,i - 1,j);
//        score += dfs(grid,visited,i,j - 1);
//        score += dfs(grid,visited,i,j + 1);
//        return score + 1;
//    }


}
