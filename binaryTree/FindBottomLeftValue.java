package leetcode.binaryTree;

public class FindBottomLeftValue {
    public static void main(String[] args){
        TreeNode s = new TreeNode(1,new TreeNode(4,new TreeNode(5,null,null),null),new TreeNode(2,new TreeNode(3,new TreeNode(6,new TreeNode(8,null,null),null),null),new TreeNode(7,null,null)));
        System.out.println(findBottomLeftValue(s));
    }

    static int H = 0;
    static int R = 0;

    public static int findBottomLeftValue(TreeNode root){
        int h = 0;
        return process(root,h);
    }

    public static int process(TreeNode root,int h){
        h++;
        if (h > H){
            H = h;
            R = root.val;
        }
        if (root.left != null){
            process(root.left,h);
        }
        if (root.right != null){
            process(root.right,h);
        }
        return R;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){
        }

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}



