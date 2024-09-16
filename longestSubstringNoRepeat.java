public class longestSubstringNoRepeat {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        int[] index = new int[128];
        
        for(int j=0, i=0; j<n; j++){
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j-i+1);
            index[s.charAt(j)] = j+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        longestSubstringNoRepeat obj = new longestSubstringNoRepeat();
        String s = "abcabcbb";
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }
    
}
