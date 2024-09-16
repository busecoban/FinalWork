
public class lcs_dynamic_5 {

    public static void main(String[] args) {
        // Burada lcs_dynamic_5 sınıfından nesne oluşturulmalı
        lcs_dynamic_5 lcs_dynamic = new lcs_dynamic_5();
        String str1 = "ABCDE";
        String str2 = "ACE";
        int lcs = lcs_dynamic.longestCommmonSubsequence(str1, str2);
        System.out.println(lcs);
    }

    public int longestCommmonSubsequence(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int[][] dp = new int[length1][length2];
        // İlk olarak diziyi -1 ile dolduruyoruz
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) { // j döngüsünde yanlışlık vardı, dp.length yerine dp[0].length olmalı
                dp[i][j] = -1;
            }
        }
        return helper(str1, str2, length1 - 1, length2 - 1, dp);
    }

    public static int helper(String str1, String str2, int ind1, int ind2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) return 0;
        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];  // Daha önce bulunduysa
        if (str1.charAt(ind1) == str2.charAt(ind2)) {
            return 1 + helper(str1, str2, ind1 - 1, ind2 - 1, dp);
        }
        // Sonuçları dizide saklıyoruz
        dp[ind1][ind2] = Math.max(helper(str1, str2, ind1 - 1, ind2, dp), helper(str1, str2, ind1, ind2 - 1, dp));
        return dp[ind1][ind2];
    }
}
