package leetcode.medium;

public class p2275_largest_combination {
    public static int largest_combination(int[] candidates) {
        int max = candidates[0];
        for(int i : candidates) {
            if(i > max) {
                max = i;
            }
        }
        int n = candidates.length;
        int largestCounter = 0;
        String[] binaryArr = new String[n];
        int largestLength = Integer.toBinaryString(max).length();
        
        for (int i = 0; i < n; i++) {
            binaryArr[i] = convert_to_binary(Integer.toBinaryString(candidates[i]), largestLength);
        }
        for (int i = largestLength - 1; i >= 0; i--) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(binaryArr[j].charAt(i) == '1') {
                    count++;
                }
            }
            if(count > largestCounter) {
                largestCounter = count;
            }
        }
        return largestCounter;
    }

    public static String convert_to_binary(String s, int largestLength) {
        int n = s.length();
        int lack = largestLength - n;
        StringBuilder binaryString = new StringBuilder();
        for(int i = 1; i <= lack; i++) {
            binaryString.append(0);
        }
        return binaryString.append(s).toString();
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{8, 8};
        System.out.println(largest_combination(candidates));
    }
}
