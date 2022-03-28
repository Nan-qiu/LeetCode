package leetcode.digitalProblem;

import java.util.Arrays;

public class MaximumPointsInAnArcheryCompetition {

    public static void main(String[] args){
        int[] n = {3,2,28,1,7,1,16,7,3,13,3,5};
        System.out.println(Arrays.toString(maximumBobPoints(89,n)));
    }
    /*
     * A:  0,0,1,1,3,0,0,0,0,2,0,0    18
     * B:  0,0,0,0,0,0,0,1,1,3,1,1     21+9+8+7
     *     0,1,0,0,0,1,1,1,1,0,1,1    21+8+7+6+5+1 48
     * ---------------------------
     *     0 1 2 3 4 5 6 7 8 9 10 11
     *
     * */

    static int max = 0;
    static int[] finalRes = null;
    static int battleAlice = 0;

    public static int[] maximumBobPoints(int numArrows,int[] aliceArrows){
        // int res = 0;
        int[] isGet = new int[aliceArrows.length];
        dfs1(numArrows,aliceArrows,0,aliceArrows.length - 1,isGet);
        return finalRes;
    }

    private static void dfs1(int numArrows,int[] aliceArrows,int res,int index,int[] isGet){

        if (numArrows < 0) return;
        if (index < 0) return;
        if (numArrows == 0){
            //System.out.println(res);
            if (res > max){
                max = res;
                finalRes = isGet.clone();
            }
            return;
        }


        isGet[index] +=1;
        battleAlice++;
        if (aliceArrows[index] - battleAlice == -1) {
            battleAlice=0;
            dfs1(numArrows - 1,aliceArrows,res + index,index - 1,isGet);

        }
        else dfs1(numArrows - 1,aliceArrows,res,index,isGet);
        isGet[index] -=1;


        //不选
        dfs1(numArrows,aliceArrows,res,index - 1,isGet);
    }


    private static void dfs(int numArrows,int[] aliceArrows,int res,int index,int[] isGet){
        if (index == 0){
            if (numArrows > 0){
                isGet[0] += numArrows;
            }
            if (res > max){
                max = res;
                finalRes = isGet.clone();
            }
            return;
        }


//        if (numArrows < 0) return;
//        if (numArrows == 0){
//            System.out.println(res);
//            if (res > max){
//                max = res;
//                finalRes = isGet.clone();
//            }
//            return;
//        }
//        if (index < 1) return;


        //选
        if (numArrows > aliceArrows[index]){
            isGet[index] += aliceArrows[index] + 1;
            dfs(numArrows - aliceArrows[index] - 1,aliceArrows,res + index,index - 1,isGet);
            isGet[index] -= aliceArrows[index] + 1;
        }
        //不选
        dfs(numArrows,aliceArrows,res,index - 1,isGet);
    }
}
