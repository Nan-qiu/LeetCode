package leetcode.digitalProblem;

import java.util.Stack;

public class SumOfSubarrayRanges {
    public static void main(String[] args){
        int[] ints = {4,-2,-3,4,1};
        System.out.println(subArrayRanges1(ints));
    }


    public static long subArrayRanges1(int[] nums){
        if (nums.length==1) return 0;
        long res=0;
        for(int i = 0; i < nums.length; i++){
            int max=nums[i];
            int min=nums[i];
            for(int j = i+1; j < nums.length; j++){
                max=Math.max(max,nums[j]);
                min=Math.min(min,nums[j]);
                res+=Math.abs(max-min);
            }
        }
        return res;
    }
    public static long subArrayRanges(int[] nums){
        Stack<Integer> cur = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        cur.push(nums[0]);
        for(int i = 1; i < nums.length; i++){
            while (!cur.isEmpty() && cur.peek() > nums[i]) {
                int pop = cur.pop();
                temp.push(pop);
            }
            cur.push(nums[i]);
            while (!temp.isEmpty()) {
                int pop = temp.pop();
                cur.push(pop);
            }
        }
        long res = 0;
        int firN=cur.pop();
        while (!cur.isEmpty()) {
            int secN = cur.pop();
            res += Math.abs(firN - secN);
        }
        return res;
    }
}
