package CAT2;

public class RecoverBST{

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverBST(TreeNode root){
        inorder(root);

        if(first!=null&&second!=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    public void inorder(TreeNode root){
        if(root==null){
            return;
        }

        inorder(root.left);

        if(prev.val>root.val){
            if(first==null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
    public void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        RecoverBST solution = new RecoverBST();

        // Create a sample tree with two nodes swapped
        /*
              3
             / \
            1   4
               /
              2
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);

        System.out.println("Before recovery (In-order traversal):");
        solution.printInOrder(root);
        System.out.println();

        // Recover the BST
        solution.recoverBST(root);

        System.out.println("After recovery (In-order traversal):");
        solution.printInOrder(root);
        System.out.println();
    }
}