package leetcode.digitalProblem;

public class Search2DMatrixII {
    public static void main(String[] args){
        int[][] a = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        System.out.println(searchMatrix(a,26));
    }

    public static boolean searchMatrix(int[][] matrix,int target){
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; ){
            for(int j = col - 1; j >= 0; ){
                if (matrix[i][j] == target) return true;
                if (matrix[i][j] < target) i++;
                else j--;
                if (i == row || j < 0) return false;
            }
        }
        return false;
//        int col = matrix[0].length;
//        for(int[] ints : matrix){
//            for(int j = col - 1; j >= 0; j--){
//                if (ints[j] == target) return true;
//                else if (ints[j] < target) break;
//            }
//        }
//        return false;
    }
}
