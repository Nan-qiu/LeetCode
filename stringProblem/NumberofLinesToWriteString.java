package leetcode.stringProblem;

public class NumberofLinesToWriteString {

    public int[] numberOfLines(int[] widths, String s) {
        int lineCnt=1;
        int curLine=0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if (curLine+widths[c-'a']>100){
                lineCnt++;
                curLine=widths[c-'a'];
            }else curLine+=widths[c-'a'];
        }
        return new int[]{lineCnt,curLine};
    }
}
