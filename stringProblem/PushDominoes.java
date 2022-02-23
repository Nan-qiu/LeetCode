package leetcode.stringProblem;

public class PushDominoes {
    public static void main(String[] args){
        System.out.println(pushDominoes("L"));
    }

    public static String pushDominoes(String dominoes){
        char[] dominoe = dominoes.toCharArray();
        int fir = 0;
        int sec = 0;
        for(int i = 0; i < dominoe.length; i++){
            fir = i;
            if (dominoe[fir] == 'L'){ //fir遇到'L'
                if (dominoe[sec] == '.'){ //如果sec是’.‘
                    while (sec != fir) {
                        dominoe[sec] = 'L';
                        sec++;
                    }
                } else if (dominoe[sec] == 'L'){ //如果sec是’L‘
                    while (sec != fir) {
                        dominoe[sec] = 'L';
                        sec++;
                    }
                } else if (dominoe[sec] == 'R'){ //如果sec是’R‘
                    int k = fir - sec;
                    int count = 0;
                    if (k % 2 == 0){ //中间有不倒的牌
                        while (sec != fir) {
                            if (count < k / 2){
                                dominoe[sec] = 'R';
                                sec++;
                            } else if (count == k / 2){
                                dominoe[sec] = '.';
                                sec++;
                            } else{
                                dominoe[sec] = 'L';
                                sec++;
                            }
                            count++;
                        }
                    } else{ //中间没有不倒的牌
                        while (sec != fir) {
                            if (count <= k / 2){
                                dominoe[sec] = 'R';
                            } else{
                                dominoe[sec] = 'L';
                            }
                            sec++;
                            count++;
                        }
                    }
                }
            } else if (dominoe[fir] == 'R'){ //fir遇到'R'
                if (dominoe[sec] == '.'){ //如果sec是’.‘
                    sec = fir;
                } else if (dominoe[sec] == 'L'){ //如果sec是’L‘
                    sec = fir;
                } else if (dominoe[sec] == 'R'){ //如果sec是’R‘
                    while (sec != fir) {
                        dominoe[sec] = 'R';
                        sec++;
                    }
                }
            } else if (i == dominoe.length - 1){
                if (dominoe[fir] == '.' && dominoe[sec] == 'R'){
                    while (sec != dominoe.length) {
                        dominoe[sec] = 'R';
                        sec++;
                    }
                }
            }
        }
        return String.valueOf(dominoe);
    }
}
