package leetcode.stringProblem;

public class RotateString {
    public static void main(String[] args){
        RotateString rotateString = new RotateString();
        System.out.println(rotateString.rotateString("abcde", "abced"));
    }

    public boolean rotateString(String s, String goal){
        if (s.length()!=goal.length()) return false;
        s+=s;
        return s.contains(goal);
    }

}
