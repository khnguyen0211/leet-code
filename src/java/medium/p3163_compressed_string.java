package java.medium;

public class p3163_compressed_string {
    /*
     * Beats 94.92%
     */
    public static String compressed_string(String word) {
        char[] chars = word.toCharArray();
        StringBuilder rs = new StringBuilder();
        int i = 0;
        int n = chars.length;
        while (i < n) {
            int count = 1;
            while (i < n - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            while (count > 9) {
                rs.append(9);
                rs.append(chars[i]);
                count -= 9;
            }
            rs.append(count);
            rs.append(chars[i]);
            i++;
        }
        return rs.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressed_string("aaaaaaaaaaaaaabb"));
    }
}
