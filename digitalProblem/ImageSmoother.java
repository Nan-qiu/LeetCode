package leetcode.digitalProblem;

import java.util.Arrays;

public class ImageSmoother {
    public static void main(String[] args){
        int[][] n = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(Arrays.deepToString(imageSmoother(n)));
    }

    public static int[][] imageSmoother(int[][] img){
        int[][] res = new int[img.length][img[0].length];
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                int col = i - 1 == -1 ? 0 : i - 1;
                int limitCol = i == img.length - 1 ? i : i + 1;
                int limitRow = j == img[0].length - 1 ? j : j + 1;
                int ans = 0;
                int count = 0;
                for(; col <= limitCol; col++){
                    int row = j - 1 == -1 ? 0 : j - 1;
                    for(; row <= limitRow; row++){
                        ans += img[col][row];
                        count++;
                    }
                }
                res[i][j] = ans / count;
            }
        }
        return res;
    }
}

