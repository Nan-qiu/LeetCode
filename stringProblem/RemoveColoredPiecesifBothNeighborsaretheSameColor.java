package leetcode.stringProblem;

public class RemoveColoredPiecesifBothNeighborsaretheSameColor {
    public static void main(String[] args){
        System.out.println(winnerOfGame("ABBBBBBBAAA"));
    }

    public static boolean winnerOfGame(String colors){
        char[] chars = colors.toCharArray();
        //byte[] Alice = new byte[chars.length];
        //byte[] Bob = new byte[chars.length];
        int Alice = 0;
        int Bob = 0;
        for(int i = 1; i < chars.length - 1; i++){
            if (chars[i] == 'A'){
                if (chars[i - 1] == 'A' && chars[i + 1] == 'A') Alice++;
            } else{
                if (chars[i - 1] == 'B' && chars[i + 1] == 'B') Bob++;
            }
        }
        if (Alice == 0) return false;
        else if (Bob == 0) return true;
        else return Alice > Bob;
    }
}
