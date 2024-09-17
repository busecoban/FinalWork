public class reverseInteger_7 {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x /= 10;
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7)){
                return 0;
            }
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)){
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
    public static void main(String[] args) {
        reverseInteger_7 obj = new reverseInteger_7();
        int x = 123;
        int result = obj.reverse(x);
        System.out.println("Reversed integer: " + result);
    }
    
}
