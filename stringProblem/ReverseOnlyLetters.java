package leetcode.stringProblem;

public class ReverseOnlyLetters {
    public static void main(String[] args){
        String s = "Test1ng-Leet=code-Q!";
        System.out.println(reverseOnlyLetters(s));

    }

    public static String reverseOnlyLetters(String s){
        StringBuilder letters = new StringBuilder();
        char[] chars = s.toCharArray();
        byte[] notLetter = new byte[chars.length];
        for(int i = 0; i < chars.length; i++){
            if (chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= 'A' && chars[i] <= 'Z') letters.append(chars[i]);
            else notLetter[i] = (byte) chars[i];
        }
        letters.reverse();
        for(int i = 0; i < notLetter.length; i++){
            if (notLetter[i] != 0) letters.insert(i,(char) notLetter[i]);
        }
        return letters.toString();
    }
}
