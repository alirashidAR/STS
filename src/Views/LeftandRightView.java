package Views;
import java.util.*;

public class LeftandRightView {

    public static TreeNode buildTree(String input){

        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = input.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);

        int i=1;
        while(!queue.isEmpty() && i<values.length){

            TreeNode current = queue.poll();

            if(!values[i].equals("N")){
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;
            if(i>=values.length){
                break;
            }

            if (!values[i].equals("N")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return  root;
    }

    public static void leftViewTree(TreeNode root){
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // The first node of this level is part of the left view
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // if it's the first node in this level
                if (i == 0) {
                    System.out.print(current.val + " ");
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
    }

    public static void rightView(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){

                TreeNode current = queue.poll();

                if(i==levelSize-1){
                    System.out.print(current.val + " ");
                }

                if(current.left != null){
                    queue.offer(current.left);

                }

                if(current.right != null){
                    queue.offer(current.right);
                }
            }
        }
    }

    public static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if(current.left != null){
                queue.offer(current.left);
            }
            if(current.right != null){
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        TreeNode root = buildTree(input);
        System.out.println("Left View");
        leftViewTree(root);
        System.out.println();
        System.out.println("Right View");
        rightView(root);

    }

}
