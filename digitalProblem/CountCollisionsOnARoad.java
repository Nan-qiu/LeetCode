package leetcode.digitalProblem;

public class CountCollisionsOnARoad {
    public static void main(String[] args){
        System.out.println(countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }

    public static int countCollisions(String directions){
        char[] chars = directions.toCharArray();

        int[] stop = new int[chars.length];
        for(int i = 0; i < chars.length; i++){
            if (chars[i] == 'S') stop[i] = 1;
        }

        int res = 0;
        int rightT = 0;
        for(int i = 0; i < chars.length; i++){
            if (i - 1 >= 0 && stop[i] == 0 && chars[i] == 'L'){
                if (stop[i - 1] == 1){
                    res += 1;
                    stop[i] = 1;
                } else{
                    if (chars[i - 1] == 'R'){
                        res += 2;
                        stop[i - 1] = 1;
                        stop[i] = 1;
                    }
                }
            } else if (i + 1 < chars.length && stop[i] == 0 && chars[i] == 'R'){
                if (stop[i + 1] == 1){
                    res += 1;
                    stop[i] = 1;
                    if (rightT != 0){
                        res += rightT;
                        rightT = 0;
                    }
                } else{
                    if (chars[i + 1] == 'L'){
                        res += 2;
                        stop[i + 1] = 1;
                        stop[i] = 1;
                        if (rightT != 0){
                            res += rightT;
                            rightT = 0;
                        }
                    } else if (chars[i + 1] == 'R'){
                        rightT++;
                    }
                }
            }
        }
        return res;
    }
}
