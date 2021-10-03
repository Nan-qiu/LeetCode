package leetcode.digitalProblem;

public class FindFirstNearestPoint {
    public static void main(String[] args){
        int[][] a = {{1,2},{3,1},{2,4},{2,3},{4,4}};
        System.out.println(nearestValidPoint(3,4,a));
    }

    public static int nearestValidPoint(int x,int y,int[][] points){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < points.length; i++){
            if (points[i][0] == x || points[i][1] == y){
                int distance = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (distance < min){
                    min = distance;
                    index = i;
                }
            }
        }
        return index;
    }
}
