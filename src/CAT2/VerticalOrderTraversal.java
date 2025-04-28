package CAT2;
import java.util.*;

class Pair{
    TreeNode node;
    int hd;
    Pair(TreeNode node,int hd){
        this.node = node;
        this.hd = hd;
    }
}

public class VerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer,List<Integer>> mp = new TreeMap<>();
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(root,0));

        while(!pq.isEmpty()){
            Pair current = pq.poll();
            TreeNode currentNode = current.node;
            int hd = current.hd;

            mp.computeIfAbsent(hd , k-> new ArrayList<>()).add(currentNode.val);

            if(currentNode.left != null){
                pq.offer(new Pair(currentNode.left,hd-1));
            }
            if(currentNode.right != null) {
                pq.offer(new Pair(currentNode.right, hd + 1));
            }
        }
        for( List<Integer> list : mp.values() ){
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        VerticalOrderTraversal vt = new VerticalOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = vt.verticalOrder(root);
        System.out.println(res);

    }
}
