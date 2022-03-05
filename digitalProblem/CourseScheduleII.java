package leetcode.digitalProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

    public static void main(String[] args){
        int[][] a = {};
        System.out.println(Arrays.toString(findOrder(1,a)));

    }

    public static int[] findOrder(int numCourses,int[][] prerequisites){
        int[] res = new int[numCourses];
        int[] inDegrees = new int[numCourses];
        if (prerequisites.length == 0) {
            for(int i = 0; i < numCourses; i++){
                res[i]=i;
            }
            return res;
        }
        //把每个课程入度++
        for(int[] prerequisite : prerequisites){
            inDegrees[prerequisite[0]]++;
        }
        //把入度为0 的节点下标放入队列
        Queue<Integer> list = new LinkedList<>();
        for(int i = 0; i < inDegrees.length; i++){
            if (inDegrees[i] == 0) list.offer(i);
        }

        int count = 0;
        while (!list.isEmpty()) {
            int cur = list.poll();
            res[count++] = cur;
            for(int[] ints : prerequisites){
                if (ints[1] == cur){
                    inDegrees[ints[0]]--;
                    if (inDegrees[ints[0]] == 0) list.offer(ints[0]);
                }
            }
        }

        return count == numCourses ? res : new int[0];
    }
}
