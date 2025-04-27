import java.util.*;

public class LoopDetection {
    static Node insertNode(Node head, int val){
        Node newNode = new Node(val);
        if(head==null){
            head= newNode;
            return head;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    static void display(Node head){
        while(head!=null){
            System.out.print(head.num+"->");
            head=head.next;
        }
        System.out.println("->null");
    }

    static void createCycle(Node head, int a , int b){
        int cnta=0;
        int cntb=0;
        Node p1 = head;
        Node p2 = head;
        while(cnta!=a&&cntb!=b){
            if(cnta!=a){
                p1 = p1.next;
                ++cnta;
            }
            if(cntb!=b) {
                p2 = p2.next;
                ++cntb;
            }
        }
        p2.next = p1;
    }
    static boolean isLoop(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        for(int i=0;i<n;i++){
            int m = sc.nextInt();
            head = insertNode(head,m);
        }
        display(head);
        int a = sc.nextInt();
        createCycle(head,1,a);
        if(isLoop(head)) {
            System.out.println("Loop Detected");
        }else{
            System.out.println("Not Loop Detected");
        }
    }
}
