package CAT2;
import java.util.*;

public class BoundaryTraversal {

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        res.add(root.val);

        addLeftBoundary(root.left,res);
        addLeafNodes(root,res);
        addRightBoundary(root.right,res);
        return res;
    }

    static void addLeftBoundary(TreeNode node, List<Integer> res) {
        while (node != null) {
            if(node.left != null && node.right != null){
                res.add(node.val);
            }

            if(node.left != null){
                node = node.left;
            }else{
                node = node.right;
            }
        }
    }

    static void addLeafNodes(TreeNode node, List<Integer> res) {
        if(node == null) return;
        if(node.left == null && node.right == null){
            res.add(node.val);
        }
        addLeafNodes(node.left, res);
        addLeafNodes(node.right, res);
    }

    static void addRightBoundary(TreeNode node, List<Integer> res) {
        Stack<Integer> st = new Stack<>();
        while(node != null){
            if(node.left != null && node.right != null){
                st.push(node.val);
            }

            if(node.right != null){
                node = node.right;
            }else{
                node = node.left;
            }

            while(!st.empty()){
                res.add(st.pop());
            }
        }
    }

    public static void main(String[] args) {
        BoundaryTraversal bt = new BoundaryTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> res = bt.preOrderTraversal(root);
        System.out.println(res);
    }
}
