package CAT2;
import java.util.*;

class BoundaryTraversal {
    static TreeNode root;

    // Build tree from level order input
    static TreeNode build(String[] s) {
        if (s[0].equals("N") || s.length == 0)
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            TreeNode curr = q.poll();
            String cval = s[i];
            if (!cval.equals("N")) {
                int h = Integer.parseInt(cval);
                curr.left = new TreeNode(h);
                q.add(curr.left);
            }
            i++;
            if (i >= s.length)
                break;
            cval = s[i];
            if (!cval.equals("N")) {
                int h = Integer.parseInt(cval);
                curr.right = new TreeNode(h);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    // Print all leaf nodes
    void printLeaves(TreeNode node) {
        if (node == null)
            return;
        printLeaves(node.left);
        if (node.left == null && node.right == null)
            System.out.print(node.val + " ");
        printLeaves(node.right);
    }

    // Print left boundary (excluding leaf nodes)
    void printBoundaryLeft(TreeNode node) {
        if (node == null)
            return;
        if (node.left != null) {
            System.out.print(node.val + " ");
            printBoundaryLeft(node.left);
        } else if (node.right != null) {
            System.out.print(node.val + " ");
            printBoundaryLeft(node.right);
        }
    }

    // Print right boundary (excluding leaf nodes)
    void printBoundaryRight(TreeNode node) {
        if (node == null)
            return;
        if (node.right != null) {
            printBoundaryRight(node.right);
            System.out.print(node.val + " ");
        } else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.val + " ");
        }
    }

    // Print boundary traversal (root, left boundary, leaves, right boundary)
    void printBoundary(TreeNode node) {
        if (node == null)
            return;

        // Print the root
        System.out.print(node.val + " ");

        // Print the left boundary (excluding leaf nodes)
        printBoundaryLeft(node.left);

        // Print all leaves
        printLeaves(node.left);
        printLeaves(node.right);

        // Print the right boundary (excluding leaf nodes)
        printBoundaryRight(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoundaryTraversal ob = new BoundaryTraversal();

        // Read the level order input and split into string array
        String s[] = sc.nextLine().split(" ");

        // Build the binary tree from the level order input
        root = build(s);

        // Print the boundary traversal
        ob.printBoundary(root);
    }
}
