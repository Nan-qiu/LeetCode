package leetcode.stringProblem;

public class FindClosestLCCI {
    public int findClosest(String[] words, String word1, String word2){

        String fir = null;
        int res = Integer.MAX_VALUE;
        int p = 0;

        for(int i = 0; i < words.length; i++){
            if (words[i].equals(word1) || words[i].equals(word2)){
                if (fir == null){
                    fir = words[i];
                    p = i;
                    continue;
                }

                if (words[i].equals(fir)) p = i;
                else{
                    res = Math.min(res, i - p);
                    fir = words[i];
                    p = i;
                }
            }
        }
        return res;
    }
}
