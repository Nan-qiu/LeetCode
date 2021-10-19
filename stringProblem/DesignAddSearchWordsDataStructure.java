package leetcode.stringProblem;

public class DesignAddSearchWordsDataStructure {
    public static void main(String[] args){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("abc");
        System.out.println(wordDictionary.search(".b."));
    }
}

class WordDictionary { // 前缀树实现

    private final Node node;

    public WordDictionary(){
        node = new Node();
    }

    public void addWord(String word){
        Node cur=node;// 头节点不能动！
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (cur.nexts[index] == null){
                cur.nexts[index] = new Node();
            }
            cur = cur.nexts[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word){
        return process(word,0,node);
    }

    public boolean process(String word,int index,Node node){
        if (index == word.length()) return node.isEnd;
        char ch = word.charAt(index);
        if (ch=='.'){
            for(int i = 0; i < 26; i++){
                Node child=node.nexts[i];
                if (node.nexts[i] != null && process(word,index + 1,child)){
                    return true;
                }
            }
        }else {
            int i = ch - 'a';
            Node child=node.nexts[i];
            return node.nexts[i] != null && process(word,index + 1,child);
        }
//        if (Character.isLetter(ch)){ // 若为字母
//            int i = ch - 'a';
//            Node child=node.nexts[i];
//            return node.nexts[i] != null && process(word,index + 1,child);
//        } else{
//            for(int i = 0; i < 26; i++){
//                Node child=node.nexts[i];
//                if (node.nexts[i] != null && process(word,index + 1,child)){
//                    return true;
//                }
//            }
//        }
        return false;
    }
}

class Node {
    boolean isEnd;
    Node[] nexts;

    public Node(){
        nexts = new Node[26];
        isEnd = false;
    }
}

//    HashSet<String> set;
//    boolean flag = false;
//
//    public WordDictionary(){
//        set = new HashSet<>();
//    }
//
//    public void addWord(String word){
//        set.add(word);
//    }
//
//    public boolean search(String word){
//        flag=false;
//        return process(word,0);
//    }
//
//    public boolean process(String word,int index){
//        if (flag) return true;
//        if (set.contains(word)) return true;
//        StringBuilder builder = new StringBuilder();
//        builder.append(word);
//        for(int i = index; i < word.length(); i++){
//            if (builder.charAt(i) == '.'){
//                for(int j = 0; j < 26; j++){
//                    builder.setCharAt(i,(char) ('a' + j));
//                    if (set.contains(builder.toString())){
//                        flag=true;
//                        return true;
//                    }
//                    process(builder.toString(),i + 1);
//                }
//            }
//        }
//        return flag;
//    }
