package leetcode.digitalProblem;

public class MaximizetheConfusionofanExam {
    public static void main(String[] args){

        System.out.println(maxConsecutiveAnswers("FFFTTFTTFT",3));
    }

    public static int maxConsecutiveAnswers(String answerKey,int k){
        char[] chars = answerKey.toCharArray();
        int fir = 0;
        int sec = 0;
        int tCnt = 0;
        int fCnt = 0;
        int ans = 0;
        for(; sec < chars.length; sec++){
            if (chars[sec] == 'T') tCnt++;
            else fCnt++;
            while (Math.min(fCnt,tCnt) > k) {
                if (chars[fir++] == 'T') tCnt--;
                else fCnt--;
            }
            ans = Math.max(ans,sec - fir + 1);
        }
        return ans;
    }
}