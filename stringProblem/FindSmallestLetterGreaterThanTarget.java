package leetcode.stringProblem;

public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters,char target){
        int k = target - 'a';
        for(char letter : letters){
            if (letter - 'a' > k) return letter;
        }
        return letters[0];
    }

}
