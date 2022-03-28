package leetcode.binaryTree;

import java.util.Arrays;

public class CountNodesWithTheHighestScore {
    public static void main(String[] args){
        CountNodesWithTheHighestScore s = new CountNodesWithTheHighestScore();
        int[] n={-1,2,0,2,0};
        System.out.println(s.countHighestScoreNodes(n));
    }
    long maxScore = 0;
    int res = 0;
    int n;

    public int countHighestScoreNodes(int[] parents){
        this.n = parents.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; i++){
            left[i] = -1;
            right[i] = -1;
        }
        for(int i = 1; i < n; i++){
            int p = parents[i];
            if (left[p] == -1) left[p] = i;
            else right[p] = i;
        }
        System.out.println("left = " + Arrays.toString(left));
        System.out.println("right = " + Arrays.toString(right));
        dfs(0,left,right);
        return res;
    }

    private int dfs(int p,int[] left,int[] right){
        if (p == -1) return 0;
        int leftC = dfs(left[p],left,right);
        int rightC = dfs(right[p],left,right);
        int remain = n - leftC - rightC - 1;

        long sum = (long) help(leftC) * help(rightC) * help(remain);

        if (sum == maxScore) res++;
        else if (sum > maxScore){
            maxScore = sum;
            res = 1;
        }

        return leftC + rightC + 1;
    }

    private int help(int n){
        return n == 0 ? 1 : n;
    }
}
