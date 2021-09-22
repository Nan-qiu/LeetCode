package leetcode;

import java.util.Arrays;

public class LengthOfLastWord {
    public static void main(String[] args){
        String s="wcnd dnm   ";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        String[] ss=s.split(" ");
        System.out.println(Arrays.toString(ss));
        return ss[ss.length-1].length();

//        int count=0;
//        StringBuffer sb = new StringBuffer(s);
//        String a=sb.reverse().toString().trim();
//        for(int i = 0; i < a.length(); i++){
//            if (a.charAt(i) != ' '){
//                count++;
//            }else {
//                return count;
//            }
//        }
//        return count;
    }
}
