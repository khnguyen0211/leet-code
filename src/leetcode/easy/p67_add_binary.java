package leetcode.easy;

public class p67_add_binary {
    /*
     * Runtime 1 ms Beats 99.96%
     */
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder rs = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            carry = sum / 2;
            rs.append(sum % 2);
        }
        return rs.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println('1' - '0');
    }
}
