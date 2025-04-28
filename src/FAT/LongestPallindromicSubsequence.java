package FAT;
import java.util.Scanner;

public class LongestPallindromicSubsequence {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(longestPalindromicSubsequence(s));
    }

    public static int longestPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the DP table from shorter substrings to longer ones
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start < n - len + 1; start++) {
                int end = start + len - 1;
                if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = 2 + (len > 2 ? dp[start + 1][end - 1] : 0);
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }

        return dp[0][n - 1]; // The result is stored at the top-right corner of the DP table
    }
}
