package leetcode.stringProblem;

import java.util.Arrays;

public class LongestHappyString {

    public static void main(String[] args){
        System.out.println(longestDiverseString(8,11,0));
    }

    public static String longestDiverseString(int a,int b,int c){
        StringBuilder res = new StringBuilder();
        Pair[] arr = {new Pair(a,'a'),new Pair(b,'b'),new Pair(c,'c')};

        while (true) {
            Arrays.sort(arr,(p1,p2) -> p2.freq - p1.freq);
            boolean hasNext = false;
            for(Pair pair : arr){
                if (pair.freq <= 0){
                    break;
                }
                int m = res.length();
                if (m >= 2 && res.charAt(m - 2) == pair.ch && res.charAt(m - 1) == pair.ch){
                    continue;
                }
                hasNext = true;
                res.append(pair.ch);
                pair.freq--;
                break;
            }
            if (!hasNext){
                break;
            }
        }

        return res.toString();
    }

    static class Pair {
        int freq;
        char ch;

        public Pair(int freq,char ch){
            this.freq = freq;
            this.ch = ch;
        }
    }


//    static int maxFlag = 0;
//    static int secFlag = 0;
//    static int count = 0;
//
//    public static String longestDiverseString(int a,int b,int c){
//        int flag = 0;
//        int dou=0;
//        StringBuilder res = new StringBuilder();
//        compare(a,b,c);
//        while (a != 0 || b != 0 || c != 0) {
//            if (maxFlag==flag) break;
//
//            if (flag != 1){
//                if (maxFlag == 1){
//                    count++;
//                    maxFlag = secFlag;
//                    if (dou==0||a >= 2){
//
//                        res.append("aa");
//                        a -= 2;
//                        if (maxFlag==1&&secFlag==2) dou=1;
//                        else dou=0;
//                        flag = 1;
//                    } else if (dou==1&&a != 0){
//                        flag = 0;
//                        dou=0;
//                        res.append("a");
//                        a -= 1;
//                    }
//                    if (count == 2){
//                        compare(a,b,c);
//                        count = 0;
//                    }
//                }
//
//            }
//            if (flag != 2){
//
//                if (maxFlag == 2){
//                    count++;
//                    maxFlag = secFlag;
//                    if (b >= 2||dou==0){
//
//                        res.append("bb");
//                        b -= 2;
//                        flag = 2;
//                    } else if (b != 0&&dou>0){
//                        flag = 0;
//                        res.append("b");
//                        b -= 1;
//                    }
//                    if (count == 2){
//                        compare(a,b,c);
//                        count = 0;
//                    }
//                }
//
//            }
//
//            if (flag != 3){
//
//                if (maxFlag == 3){
//                    count++;
//                    maxFlag = secFlag;
//                    if (c >= 2||dou==0){
//
//                        res.append("cc");
//                        c -= 2;
//                        flag = 3;
//                    } else if (c != 0&&dou>0){
//                        flag = 0;
//                        res.append("c");
//                        c -= 1;
//                    }
//                    if (count == 2){
//                        compare(a,b,c);
//                        count = 0;
//                    }
//                }
//            }
//
//
//        }
//        return res.toString();
//    }
//
//    public static void compare(int a,int b,int c){
//        if (a >= b && a >= c){
//            maxFlag = 1;
//            if (b >= c) secFlag = 2;
//            else secFlag = 3;
//        }
//        if (b >= a && b >= c){
//            maxFlag = 2;
//            if (a >= c) secFlag = 1;
//            else secFlag = 3;
//        }
//        if (c >= a && c >= b){
//            maxFlag = 3;
//            if (a >= b) secFlag = 1;
//            else secFlag = 2;
//        }
//    }
}