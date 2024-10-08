public class Solution implements  IProblemDefinition{

    /**
     * runtime: 13 ms
     * beat: 65.92%
     * memory: 45.18 mb
     * beat: 51.11%
     */
    @Override
    public int p387_firstUniqueChar(String s) {
        char[] arr = s.toCharArray();
        int k = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == arr[k] && i != k) {
                k++;
                if(k == arr.length ) {
                    return -1;
                }
                i = -1;
            }
        }
        return k;
    }
    /**
     * runtime: 4 ms
     * beat: 99.08%
     * memory: 44.99 mb
     * beat: 82.21%
     */
    public int p387_firstUniqueChar_v2(String s) {
        int[] counters = new int[26];
        char[] arr = s.toCharArray();
        for(char c : arr) {
            /**
             * c = 'a' -> counters[0]
             * c = 'b' -> counters[1]
             * ...
             */
            counters[c - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(counters[arr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
