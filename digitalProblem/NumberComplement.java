package leetcode.digitalProblem;

public class NumberComplement {
    public static void main(String[] args){
        System.out.println(findComplement(2147483647));
    }

    public static int findComplement(int num){
        int high = 0;
        for(int i = 1; i <= 30; i++){
            if (num>=1<<i){
                high = i;
            } else break;
        }
        int mask = (1 << (high + 1)) - 1;
        return mask ^ num;
    }
}
