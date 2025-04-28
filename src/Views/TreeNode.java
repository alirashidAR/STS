package Views;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    TreeNode(int x, TreeNode left, TreeNode right){
        val = x;
        this.left = left;
        this.right = right;
    }
}
