package leetcode.digitalProblem;

public class OfferII068 {


    public int searchInsert(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        int mid = 0;

        if (target < nums[i]) return 0;
        else if (target > nums[j]) return nums.length;

        while (i < j) {
            mid = i + (j - i) / 2;
            if (nums[mid] > target){
                j = mid;
            } else if (nums[mid] < target){
                i = mid+1;
            } else return mid;
        }

        return nums[mid] > target ? mid : mid + 1;
    }
}
