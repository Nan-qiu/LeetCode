package leetcode.digitalProblem;

public class CountHillsAndValleysInAnArray {

    public int countHillValley(int[] nums){
        int res = 0;
        for(int i = 1; i < nums.length - 1; i++){
            if (nums[i] == nums[i - 1]) continue;
            int left = findLeft(nums,i);
            int right = findRight(nums,i);
            if (left != -1 && right != -1 && left > nums[i] && nums[i] < right){
                res++;
            } else if (left != -1 && right != -1 && left < nums[i] && nums[i] > right){
                res++;
            }
        }
        return res;
    }

    private int findRight(int[] nums,int index){
        int num = nums[index];
        for(int i = index + 1; i < nums.length; i++){
            if (num != nums[i]) return nums[i];
        }
        return -1;
    }

    private int findLeft(int[] nums,int index){
        int num = nums[index];
        for(int i = index - 1; i >=0; i--){
            if (num != nums[i]) return nums[i];
        }
        return -1;
    }
}
