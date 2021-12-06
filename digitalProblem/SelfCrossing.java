package leetcode.digitalProblem;

public class SelfCrossing {

    public static void main(String[] args){
        //int[] a = {1,1,2,2,3,1,1};
        int[] a = {1,1,2,1,1};

        System.out.println(isSelfCrossing(a));
    }

    public static boolean isSelfCrossing(int[] distance){
        if (distance.length < 4) return false;
        int i = 2;
        while (i < distance.length && distance[i] > distance[i - 2]) {//外卷
            i++;
            if (i == distance.length) return false;//若卷完，则没圈
        }
        //外卷转内卷
        if (i >= 4 && distance[i] >= distance[i - 2] - distance[i - 4] || (i == 3 && distance[i] == distance[i - 2]))
            distance[i - 1] -= distance[i - 3]; //给定限制
        i++;
        while (i < distance.length && distance[i] < distance[i - 2]) i++;//内卷
        return i != distance.length;

    }
}
