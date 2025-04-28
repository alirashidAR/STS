package CAT2;

import java.util.Arrays;
import java.util.Scanner;

public class LIS {
    public static int list(int[] arr, int n) {
        int[] lis = new int[n];

        // Every element is an LIS of length 1 by itself
        Arrays.fill(lis, 1);

        // Build the lis array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        // Find the maximum value in lis[]
        int maxLis = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] > maxLis) {
                maxLis = lis[i];
            }
        }
        return maxLis;
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
