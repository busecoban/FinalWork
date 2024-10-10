public class regularExprMatch_10 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aa";
        String p = "a*";
        System.out.println("Match: "+sol.isMatch(s, p));
    }
}
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-2];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pc == '*') {
                    if (j >= 2) {
                        char ppc = p.charAt(j-2);
                        if (ppc == sc || ppc == '.') {
                            dp[i][j] = dp[i][j-2] || dp[i-1][j];
                        } else {
                            dp[i][j] = dp[i][j-2];
                        }
                    }
                }
            }
        }
        return dp[n][m];  
    }
}
