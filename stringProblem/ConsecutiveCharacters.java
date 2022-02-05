package leetcode.stringProblem;

public class ConsecutiveCharacters {
    public static void main(String[] args){
        System.out.println(maxPower("cc"));
    }

    public static int maxPower(String s){
        int res = 1;
        int cur = 1;
        char pre = ' ';
        for(char c : s.toCharArray()){
            if (pre == c) cur++;
            else{
                pre = c;
                res = Math.max(cur,res);
                cur = 1;
            }
        }
        return Math.max(cur,res);
    }
}
