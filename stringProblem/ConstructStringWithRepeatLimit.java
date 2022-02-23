package leetcode.stringProblem;

public class ConstructStringWithRepeatLimit {
    public static void main(String[] args){
        String s = "aababab";
        System.out.println(repeatLimitedString(s,2));
    }

    public static String repeatLimitedString(String s,int repeatLimit){
        int[] bytes = new int[26];
        for(char c : s.toCharArray()){
            bytes[c - 'a']++;
        }

        int fir = findNextIndex(bytes,bytes.length);
        int sec = findNextIndex(bytes,fir);
        int count = 0;

        StringBuilder res = new StringBuilder();
        while (true) {
            if (bytes[fir] != 0 && count != repeatLimit){ //大字母不为0，没到阈值
                res.append((char) ('a' + fir));
                count++;
                bytes[fir]--;
            } else if (sec == fir && count == repeatLimit){ //sec==fir,且阈值满
                return res.toString();
            } else if (bytes[fir] != 0 && bytes[sec] != 0 && count == repeatLimit){ //大字母不为0，到阈值
                res.append((char) ('a' + sec));
                bytes[sec]--;
                count = 0;
            } else if (sec == 0 && bytes[sec] == 0){ //sec到0，且值为0
                return res.toString();
            } else if (bytes[fir] == 0){ //大字母为0
                count = 0;
                fir = sec;
                sec = findNextIndex(bytes,sec);
            } else if (bytes[sec] == 0){
                sec = findNextIndex(bytes,sec);
            }
        }
    }

    private static int findNextIndex(int[] bytes,int index){
        for(int i = index - 1; i >= 0; i--){
            if (bytes[i] != 0) return i;
        }
        return 0;
    }
}
