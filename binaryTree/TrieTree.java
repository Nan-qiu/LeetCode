package leetcode.binaryTree;

public class TrieTree { // 前缀树

    public static void main(String[] args){

    }

    public static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode(){
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];// a,b,c...26个字母 若字符多，则用哈希表 HashMap<Char,TrieNode> nexts
        }
    }

    public static class Trie {
        private TrieNode root = new TrieNode();

        public void insert(String word){ //加入word这个字符串
            if (word == null) return;
            char[] chs = word.toCharArray(); // 把字符串加进数组
            TrieNode node = root;
            node.pass++;// 头节点走过一次
            int index = 0;
            for(char ch : chs){
                index = ch - 'a'; // 从当ch的字符为 a index就为0， b 为 1，c 为 2
                if (node.nexts[index] == null) node.nexts[index] = new TrieNode(); // 如果node.nexts[index]节点为空，则新建
                node = node.nexts[index];
                node.pass++;//路过一次
            }
            node.end++; // 遍历走完，说明字符串走完，end++
        }

        public void delete(String word){ // 删除word这个字符串
            if (search(word) == 0) return; //查看树里面还有没有word这个字符串
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass--; //遇到一个节点就把pass--
            int index = 0;
            for(char ch : chs){
                index = ch - 'a';
                if (--node.nexts[index].pass == 0){ // 若发现当前节点--pass等于0时，把这个节点设为空，释放掉
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }

        public int search(String word){ // 寻找在加入过的字符串中，word有几个
            if (word == null) return 0;
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(char ch : chs){
                index = ch - 'a';
                if (node.nexts[index] == null) return 0; //若当前的node.nexts里没有index这个值，说明要找的字符串就没加入过，返回0
                node = node.nexts[index];
            }
            return node.end; // end的值就是加入过这个字符串的次数
        }

        public int prefixNumber(String pre){ // 在加入过的字符串中，以pre为前缀的字符串有几个
            if (pre == null) return 0;
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(char ch : chs){
                index = ch - 'a';
                if (node.nexts[index] == null) return 0; //若当前的node.nexts里没有index这个值，说明要找的字符串就没加入过，返回0
                node = node.nexts[index];
            }
            return node.pass; // pass的值就是路过这个字符串的次数
        }

    }

}
