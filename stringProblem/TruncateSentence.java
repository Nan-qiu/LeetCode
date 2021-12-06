package leetcode.stringProblem;

public class TruncateSentence {
    public static void main(String[] args){
        System.out.println(truncateSentence("chopper is not a tanuki",5));
    }
    public static String truncateSentence(String s, int k) {
        int count=k-1;
        int retainIndex=0;
        for(char c : s.toCharArray()){
            if (c==' ') count--;
            if (count<0) break;
            retainIndex++;
        }
        return s.substring(0,retainIndex);
    }
}
