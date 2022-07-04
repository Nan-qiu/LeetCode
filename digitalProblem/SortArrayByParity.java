package leetcode.digitalProblem;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums){
        if (nums.length == 1) return nums;
        int fir = 0;
        int sec = 1;
        while (sec < nums.length) {
            //都为偶数
            if (nums[fir] % 2 == 0 && nums[sec] % 2 == 0){
                sec++;
                fir++;
                //fir偶，sec奇
            } else if (nums[fir] % 2 == 0 && nums[sec] % 2 == 1){
                sec++;
                fir++;
                //fir奇数，sec偶数
            } else if (nums[fir] % 2 == 1 && nums[sec] % 2 == 0){
                nums[fir] ^= nums[sec];
                nums[sec] ^= nums[fir];
                nums[fir] ^= nums[sec];
                fir++;
                sec++;
            } else if (nums[fir] % 2 == 1 && nums[sec] % 2 == 1){
                sec++;
            }
        }
        return nums;
    }
}
