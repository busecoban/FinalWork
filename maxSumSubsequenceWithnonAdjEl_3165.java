public class maxSumSubsequenceWithnonAdjEl_3165 {
    public int maxSum(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i]);
        }
        int res = 0;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            res += dp[r];
            if (l > 0) {
                res -= dp[l - 1];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        maxSumSubsequenceWithnonAdjEl_3165 obj = new maxSumSubsequenceWithnonAdjEl_3165();
        int[] nums = {2, 4, 6, 8, 10};
        int[][] queries = {{0, 2}, {1, 3}, {2, 4}};
        System.out.println("Max sum of subsequence with non-adjacent elements: " + obj.maxSum(nums, queries));
    }
}
