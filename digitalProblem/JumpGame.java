package leetcode.digitalProblem;

public class JumpGame {
    public static void main(String[] args){
        JumpGame jumpGame = new JumpGame();
        int[] a = {2, 5, 0, 0};
        System.out.println(jumpGame.canJump(a));
    }

    public boolean canJump(int[] nums){
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if (max < i) return false;
            max = Math.max(i + nums[i], max);
        }
        return true;
    }
}
