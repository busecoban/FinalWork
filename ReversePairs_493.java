import java.util.*;
public class ReversePairs_493 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        Arrays.sort(nums, start, end + 1);
        return count;
    }
    public static void main(String[] args) {
        ReversePairs_493 obj = new ReversePairs_493();
        int[] nums = {1, 3, 2, 3, 1};
        System.out.println("Reverse pairs: " + obj.reversePairs(nums));
    } 
}
