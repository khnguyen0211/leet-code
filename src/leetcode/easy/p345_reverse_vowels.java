package leetcode.easy;

public class p345_reverse_vowels {
    public static String reverse_vowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length;
        while (i < j) {
            while (i < j && !is_vowel(chars[i])) {
                i++;
            }
            while (i < j && !is_vowel(chars[j])) {
                j--;
            }
            swap(chars, i++, j--);
        }
        return new String(chars);
    }

    public static boolean is_vowel(char c) {
        char[] vowels = new char[] {'a', 'o', 'e', 'u', 'i', 'A', 'O', 'E', 'U', 'I'};
        for (char vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }

    public static void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public static void main(String[] args) {

    }
}
