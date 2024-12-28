public class createSortedArrayThroughInstructions_1649 {
    public int createSortedArray(int[] instructions) {
        int n = instructions.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + instructions[i];
        }
        return countWhileMergeSort(sums, 0, n + 1);
    }
    private int countWhileMergeSort(long[] sums, int start, int end) {
        if (end - start <= 1) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count = countWhileMergeSort(sums, start, mid) + countWhileMergeSort(sums, mid, end);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; i++, r++) {
            while (k < end && sums[k] < sums[i]) {
                k++;
            }
            while (j < end && sums[j] <= sums[i]) {
                j++;
            }
            while (t < end && sums[t] < sums[i]) {
                cache[r++] = sums[t++];
            }
            cache[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }
    public static void main(String[] args) {
        createSortedArrayThroughInstructions_1649 obj = new createSortedArrayThroughInstructions_1649();
        int[] instructions = {1, 5, 6, 2};
        System.out.println("Create sorted array: " + obj.createSortedArray(instructions));
    } 
}
