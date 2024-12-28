import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class contest429 {
    public int minimumOperations(int[] nums) {
        int operations = 0;

        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        while (numList.size() > new HashSet<>(numList).size()) {
            int removeCount = Math.min(3, numList.size());
            for (int i = 0; i < removeCount; i++) {
                numList.remove(0);
            }
            operations++;
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 2, 3, 3, 5, 7};
        int[] nums2 = {4, 5, 6, 4, 4};
        int[] nums3 = {6, 7, 8, 9};

        contest429 solution = new contest429();
        System.out.println(solution.minimumOperations(nums1)); // Output: 2
        System.out.println(solution.minimumOperations(nums2)); // Output: 2
        System.out.println(solution.minimumOperations(nums3)); // Output: 0
    }

}

