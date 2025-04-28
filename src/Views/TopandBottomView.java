package Views;

import java.util.*;

public class TopandBottomView {

    static TreeNode buildTree(String input) {
        if (input.length() == 0 || input.charAt(0) == 'N') {
            return null;
        }

        String[] values = input.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (!values[i].equals("N")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;

            if (i >= values.length) break;

            // Right child
            if (!values[i].equals("N")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    static void printLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                System.out.print(current.val + " ");
                queue.offer(current.left);
                queue.offer(current.right);
            } else {
                System.out.print("N ");
            }
        }
    }

    static void printTopView(TreeNode root) {
        if (root == null) return;

        Map<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;

            // If hd is not already present in map, add it
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.val);
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        // Print the top view
        for (int val : topViewMap.values()) {
            System.out.print(val + " ");
        }
    }

    static void printBottomView(TreeNode root) {
        if (root == null) return;

        Map<Integer,Integer> mp = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()) {

            Pair current = queue.poll();
            TreeNode node = current.node;
            mp.put(current.hd, node.val);

            if(node.left != null) {
                queue.offer(new Pair(node.left, node.val - 1));
            }
            if(node.right != null) {
                queue.offer(new Pair(node.right, node.val + 1));
            }
        }

        for(int val : mp.values()){
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();  // Input the entire line like "1 2 3 N 4 5 N N 6"

        TreeNode root = buildTree(input);

        System.out.println("Level Order:");
        printLevelOrder(root);

        System.out.println("\nTop View:");
        printTopView(root);

        System.out.println("\nBottom View:");
        printBottomView(root);
    }
}
