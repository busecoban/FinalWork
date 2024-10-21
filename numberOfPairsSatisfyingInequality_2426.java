public class numberOfPairsSatisfyingInequality_2426 {
    public int countPairs(int[] nums, int low, int high) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] >= low && nums[i] + nums[j] <= high) {
                    res++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        numberOfPairsSatisfyingInequality_2426 obj = new numberOfPairsSatisfyingInequality_2426();
        int[] nums = {1, 2, 3, 4};
        int low = 2;
        int high = 5;
        System.out.println("Number of pairs satisfying inequality: " + obj.countPairs(nums, low, high));
    }
    
}
