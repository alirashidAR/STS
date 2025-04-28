package FAT;

import java.util.Scanner;

public class SubsetSum {
    public static boolean checkSubsetSum(int[] arr, int sum, int n) {
        if (sum == 0) {
            return true;
        }
        if (n<=0) {
            return false;
        }
        if (arr[n - 1] > sum) {
            return checkSubsetSum(arr, sum, n - 1);
        }
        return checkSubsetSum(arr, sum - arr[n - 1], n - 1) || checkSubsetSum(arr, sum, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of the array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target sum
        System.out.print("Enter the target sum: ");
        int sum = sc.nextInt();

        // Check if there exists a subset with the given sum
        if (checkSubsetSum(arr, sum, n)) {
            System.out.println("Yes, there exists a subset with the given sum.");
        } else {
            System.out.println("No, there is no subset with the given sum.");
        }

        sc.close();
    }
}
