package leetcode;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args){
        int[] a = {3,2,3};
        System.out.println(majorityElement(a));
    }

    public static int majorityElement(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
