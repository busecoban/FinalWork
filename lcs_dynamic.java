/**
 * lcs_dynamic
 */
public class lcs_dynamic {

    public static void main(String[] args) {
        
    }

    public int longestCommmonSubsequence(String str1,String str2){
        int length1=str1.length();
        int length2=str2.length();
        return helper(str1, str2, length1-1, length2-1);
    }


    public static int helper(String str1,String str2,int ind1,int ind2){
        if(ind1<0||ind2<0) return 0;
        if(str1.charAt(ind1)==str2.charAt(ind2)){
            return 1+helper(str1, str2, ind1-1, ind2-1);
        }
        return Math.max(helper(str1, str2, ind1-1, ind2), helper(str1, str2, ind1, ind2-1));

    }
}