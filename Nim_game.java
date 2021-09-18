package leetcode;

public class Nim_game {
    public static void main(String[] args){
        System.out.println(canWinNim(3));
    }
    public static boolean canWinNim(int n){
        return n % 4 != 0;
    }
}
