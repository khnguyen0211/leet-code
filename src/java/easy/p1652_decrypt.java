package java.easy;

public class p1652_decrypt {
    public static int[] decrypt(int[] code, int k) {
        int i = 0;
        int n = code.length;
        int[] result = new int[n];
        if (k == 0) {
            return result;
        }
        while (i < n) {
            int sum = 0;

            if (k > 0) {
                for (int j = i + 1; j <= i + k; j++) {
                    sum += code[j % n];
                }
            } else {
                for (int j = i - 1; j >= i + k; j--) {
                    if (j < 0) {
                        sum += code[n + j];
                    } else {
                        sum += code[j];
                    }
                }
            }
            result[i] = sum;
            i++;
        }
        return result;
    }
}
