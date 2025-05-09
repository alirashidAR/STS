import java.util.*;

public class StockSpan {

    static void stockSpan(int arr[], int n , int S[]) {

        Stack<Integer> st = new Stack<>();
        st.push(0);
        S[0]=1;
        for (int i = 1; i < n; i++) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            S[i] = (st.isEmpty())?i+1:(i-st.peek());
            st.push(i);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] S = new int[n];
        stockSpan(arr, n, S);
        for(int i = 0; i < n; i++){
            System.out.print(S[i]+" ");
        }
    }
}
