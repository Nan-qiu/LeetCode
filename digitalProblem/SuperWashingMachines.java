package leetcode.digitalProblem;

import java.util.Arrays;

public class SuperWashingMachines {
    public static void main(String[] args){
        int[] a = {0,0,11,5};
        System.out.println(findMinMoves(a));
    }

    public static int findMinMoves(int[] machines){
        int n = machines.length;// 洗衣机个数
        int clothes = Arrays.stream(machines).sum();// 衣服件数
        int max = Integer.MIN_VALUE;
        int sum=0;
        if (clothes % n != 0) return -1;
        int average = clothes / n;//每个洗衣机平分的衣服数量

        for(int i = 0; i < n; i++){
            machines[i] -= average; //减去平均值，表示当前位置缺少或者多出的数量
            sum+=machines[i];// 记录当前节点左边总共缺少或者多出的衣服数量
            max = Math.max(Math.max(Math.abs(sum),machines[i]),max);//累计的sum的绝对值和当前位置的数量取最大值，在和当前的max作比较
        }
        return max;//返回能在全局达到平衡的最大步骤
    }
}
