package leetcode.medium;

public class p2601_prime_subtraction_operation {
    /*
     * Using Sieve of eratosthenes algorithm to find all prime numbers less than n
     */
    public static boolean[] find_all_prime_less_than_n(int n) {
        boolean[] isPrimes = new boolean[n + 1];
        for (int i = 0; i < isPrimes.length; i++) {
            isPrimes[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrimes[i] == true) {
                for (int j = i * 2; j < isPrimes.length; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        return isPrimes;
    }

    private static int find_prime(boolean[] isPrimes, int num, int prev) {
        for (int i = num - 1; i >= 2; i--) {
            if (isPrimes[i] && num - i > prev) {
                return i;
            }
        }
        return 0;
    }

    /*
     * Runtime 11 ms Beats 10.53%
     */
    public static boolean prime_sub_operation(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        boolean[] isPrimes = find_all_prime_less_than_n(max);

        arr[0] -= find_prime(isPrimes, arr[0], 0);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
            arr[i] -= find_prime(isPrimes, arr[i], arr[i - 1]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {38, 39, 52, 16, 67, 96, 69, 44, 63, 29};
        System.out.println(prime_sub_operation(arr));
    }
}
