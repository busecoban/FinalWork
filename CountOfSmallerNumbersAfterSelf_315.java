import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf_315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int n = nums.length;
        int[] count = new int[n];
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, indexes, count, 0, n - 1);
        for (int i = 0; i < n; i++) {
            res.add(count[i]);
        }
        return res;
    }
    
    private void mergeSort(int[] nums, int[] indexes, int[] count, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, indexes, count, start, mid);
        mergeSort(nums, indexes, count, mid + 1, end);
        merge(nums, indexes, count, start, end);
    }
    
    private void merge(int[] nums, int[] indexes, int[] count, int start, int end) {
        int mid = start + (end - start) / 2;
        int leftIndex = start;
        int rightIndex = mid + 1;
        int rightCount = 0;
        int[] newIndexes = new int[end - start + 1];
        int sortIndex = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[indexes[rightIndex]] < nums[indexes[leftIndex]]) {
                newIndexes[sortIndex] = indexes[rightIndex];
                rightCount++;
                rightIndex++;
            } else {
                newIndexes[sortIndex] = indexes[leftIndex];
                count[indexes[leftIndex]] += rightCount;
                leftIndex++;
            }
            sortIndex++;
        }
        while (leftIndex <= mid) {
            newIndexes[sortIndex] = indexes[leftIndex];
            count[indexes[leftIndex]] += rightCount;
            leftIndex++;
            sortIndex++;
        }
        while (rightIndex <= end) {
            newIndexes[sortIndex] = indexes[rightIndex];
            rightIndex++;
            sortIndex++;
        }
        for (int i = start; i <= end; i++) {
            indexes[i] = newIndexes[i - start];
        }
    }
    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf_315 obj = new CountOfSmallerNumbersAfterSelf_315();
        int[] nums = {5, 2, 6, 1};
        List<Integer> result = obj.countSmaller(nums);
        System.out.print("Count of smaller numbers after self: ");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

