package leetcode.digitalProblem;

public class CountNumberofMaximumBitwiseORSubsets {
    public static void main(String[] args){
        CountNumberofMaximumBitwiseORSubsets subsets = new CountNumberofMaximumBitwiseORSubsets();
        int[] n={3,2,1,5};
        System.out.println(subsets.countMaxOrSubsets(n));
    }
    int count=0;
    int max=0;
    public int countMaxOrSubsets(int[] nums) {
        //max=nums[0];
        process(nums,0,0);
        return count;
    }

    public void process(int[] nums,int size,int xor){
        if (size==nums.length){
            if (max==xor) count++;
            else if (max<xor){
                max=xor;
                count=1;
            }
            return;
        }

        process(nums,size+1,xor|nums[size]);
        process(nums,size+1,xor);
    }
}
