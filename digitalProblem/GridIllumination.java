package leetcode.digitalProblem;

import java.util.Arrays;

public class GridIllumination {
    public static void main(String[] args){
        int[][] lamps = {{0,0},{0,0}};
        int[][] queries = {{0,4},{0,1},{1,4}};
        System.out.println(Arrays.toString(gridIllumination(5,lamps,queries)));
    }

    public static int[] gridIllumination(int n,int[][] lamps,int[][] queries){
        int[][] grid = new int[n][n];
        int[] res = new int[queries.length];
        int count = 0;
        for(int[] lamp : lamps){
            if (grid[lamp[0]][lamp[1]] == -1) continue;
            grid[lamp[0]][lamp[1]] = -1;
            light(grid,lamp[0],lamp[1]);
            System.out.println();
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    System.out.print(grid[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }

        for(int[] query : queries){
            if (grid[query[0]][query[1]] > 0 || grid[query[0]][query[1]] == -1){
                res[count++] = 1;
                turnOff(grid,query[0],query[1]);
                System.out.println("关灯");
                for(int i = 0; i < grid.length; i++){
                    for(int j = 0; j < grid[i].length; j++){
                        System.out.print(grid[i][j] + "\t");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
        return res;
    }

    public static void light(int[][] grid,int row,int col){
        int curRow = row;
        int curCol = col;

        //上
        while (curRow < grid.length - 1) {
            if (grid[++curRow][curCol] == -1) continue;
            grid[curRow][curCol] += 1;
        }
        curRow = row;

        //下
        while (curRow > 0) {
            if (grid[--curRow][curCol] == -1) continue;
            grid[curRow][curCol] += 1;
        }
        curRow = row;

        //左
        while (curCol > 0) {
            if (grid[curRow][--curCol] == -1) continue;
            grid[curRow][curCol] += 1;
        }
        curCol = col;

        //右
        while (curCol < grid.length - 1) {
            if (grid[curRow][++curCol] == -1) continue;
            grid[curRow][curCol] += 1;
        }
        curCol = col;

        //左上
        while (curRow > 0 && curCol < grid.length - 1) {
            if (grid[--curRow][++curCol] == -1) continue;
            grid[curRow][curCol] += 1;
        }
        curRow = row;
        curCol = col;

        //左下
        while (curRow > 0 && curCol > 0) {
            if (grid[--curRow][--curCol] == -1) continue;
            grid[curRow][curCol] += 1;
        }
        curRow = row;
        curCol = col;

        //右上
        while (curRow < grid.length - 1 && curCol < grid.length - 1) {
            if (grid[++curRow][++curCol] == -1) continue;
            grid[curRow][curCol] += 1;
        }
        curRow = row;
        curCol = col;

        //右下
        while (curRow < grid.length - 1 && curCol > 0) {
            if (grid[++curRow][--curCol] == -1) continue;
            grid[curRow][curCol] += 1;
        }
    }

    public static void turnOff(int[][] grid,int row,int col){
//        int curRow = row;
//        int curCol = col;

        for(int i = row - 1; i < row + 3; i++){
            for(int j = col - 1; j < col + 3; j++){
                if (i >= 0 && i <= grid.length - 1 && j >= 0 && j <= grid.length - 1 && grid[i][j] == -1)
                    grid[i][j] = turnOffLight(grid,i,j);
            }
        }

//        if (grid[curRow][curCol] == -1){
//            grid[curRow][curCol] = turnOffLight(grid,curRow,curCol);
//        }
//
//
//
//        //上
//        if (curRow > 0 && curRow < grid.length - 1 && curCol > 0 && curCol < grid.length - 1 && grid[++curRow][curCol] == -1){
//            grid[curRow][curCol] = turnOffLight(grid,curRow,curCol);
//        }
//
//        curRow = row;
//        //下
//        if (curRow > 0 && curRow < grid.length - 1 && curCol > 0 && curCol < grid.length - 1 && grid[--curRow][curCol] == -1){
//            grid[curRow][curCol] = turnOffLight(grid,curRow,curCol);
//        }
//
//        curRow = row;
//        //左
//        if (curRow > 0 && curRow < grid.length - 1 && curCol > 0 && curCol < grid.length - 1 && grid[curRow][--curCol] == -1){
//            grid[curRow][curCol] = turnOffLight(grid,curRow,curCol);
//        }
//
//        //右
//        curCol = col;
//        if (curRow > 0 && curRow < grid.length - 1 && curCol > 0 && curCol < grid.length - 1 && grid[curRow][++curCol] == -1){
//            grid[curRow][curCol] = turnOffLight(grid,curRow,curCol);
//        }
//
//        //左上
//        curCol = col;
//        if (curRow > 0 && curRow < grid.length - 1 && curCol > 0 && curCol < grid.length - 1 && grid[++curRow][--curCol] == -1){
//            grid[curRow][curCol] = turnOffLight(grid,curRow,curCol);
//        }
//        curRow = row;
//        curCol = col;
//
//        //左下
//        if (curRow > 0 && curRow < grid.length - 1 && curCol > 0 && curCol < grid.length - 1 && grid[--curRow][--curCol] == -1){
//            grid[curRow][curCol] = turnOffLight(grid,curRow,curCol);
//        }
//        curRow = row;
//        curCol = col;
//
//        //右上
//        if (curRow > 0 && curRow < grid.length - 1 && curCol > 0 && curCol < grid.length - 1 && grid[++curRow][++curCol] == -1){
//            grid[curRow][curCol] = turnOffLight(grid,curRow,curCol);
//        }
//        curRow = row;
//        curCol = col;
//
//        //右下
//        if (curRow > 0 && curRow < grid.length - 1 && curCol > 0 && curCol < grid.length - 1 && grid[--curRow][++curCol] == -1){
//            grid[curRow][curCol] = turnOffLight(grid,curRow,curCol);
//        }

    }


    public static int turnOffLight(int[][] grid,int row,int col){
        int curRow = row;
        int curCol = col;
        int count = 0;

        //上
        while (curRow < grid.length - 1) {
            if (grid[++curRow][curCol] == -1){
                count++;
                continue;
            }
            grid[curRow][curCol] -= 1;
        }
        curRow = row;

        //下
        while (curRow > 0) {
            if (grid[--curRow][curCol] == -1){
                count++;
                continue;
            }
            grid[curRow][curCol] -= 1;
        }
        curRow = row;

        //左
        while (curCol > 0) {
            if (grid[curRow][--curCol] == -1){
                count++;
                continue;
            }
            grid[curRow][curCol] -= 1;
        }
        curCol = col;

        //右
        while (curCol < grid.length - 1) {
            if (grid[curRow][++curCol] == -1){
                count++;
                continue;
            }
            grid[curRow][curCol] -= 1;
        }
        curCol = col;

        //左上
        while (curRow > 0 && curCol < grid.length - 1) {
            if (grid[--curRow][++curCol] == -1){
                count++;
                continue;
            }
            grid[curRow][curCol] -= 1;
        }
        curRow = row;
        curCol = col;

        //左下
        while (curRow > 0 && curCol > 0) {
            if (grid[--curRow][--curCol] == -1){
                count++;
                continue;
            }
            grid[curRow][curCol] -= 1;
        }
        curRow = row;
        curCol = col;

        //右上
        while (curRow < grid.length - 1 && curCol < grid.length - 1) {
            if (grid[++curRow][++curCol] == -1){
                count++;
                continue;
            }
            grid[curRow][curCol] -= 1;
        }
        curRow = row;
        curCol = col;

        //右下
        while (curRow < grid.length - 1 && curCol > 0) {
            if (grid[++curRow][--curCol] == -1){
                count++;
                continue;
            }
            grid[curRow][curCol] -= 1;
        }
        return count;
    }
}
