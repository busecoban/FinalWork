import java.util.Arrays;

public class FindArrGivenSubsetSums_1982 {
    public int[] recoverArray(int n, int[] sums) {
        int m = sums.length;
        Arrays.sort(sums);
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = sums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        FindArrGivenSubsetSums_1982 obj = new FindArrGivenSubsetSums_1982();
        int n = 3;
        int[] sums = {1, 2, 3, 4, 5, 6};
        System.out.println("Recover array: " + Arrays.toString(obj.recoverArray(n, sums)));
    }
}
