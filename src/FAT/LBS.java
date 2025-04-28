package FAT;

import java.util.Arrays;
import java.util.Scanner;

public class LBS {
    public static int list(int[] arr, int n) {
        int[] lis = new int[n];
        int[] lds = new int[n];

        // Every element is an LIS of length 1 by itself
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        // Build the lis array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for(int i = n-2 ;i >=0 ;i--){
            for(int j =n-1; j>i;j--){
                if(arr[i] > arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int maxBitonic =0;
        for(int i=0;i<n;i++){
            int bitonic = lis[i]+lds[i]-1;
            if(bitonic>maxBitonic){
                maxBitonic = bitonic;
            }
        }
        // Find the maximum bitonic
        return maxBitonic;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(list(arr, n));

        sc.close(); // good practice to close Scanner
    }
}
