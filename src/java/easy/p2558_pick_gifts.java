
import java.util.Arrays;

public class p2558_pick_gifts {

    /*
     * Runtime 28 ms Beats 5.76%
     */
    public long pick_gifts(int[] gifts, int k) {
        for (int i = 0; i < k; i++) {
            Arrays.sort(gifts);
            gifts[gifts.length - 1] = (int) Math.sqrt(gifts[gifts.length - 1]);
        }
        long sum = 0;
        for (int i = gifts.length - 1; i >= 0; i--) {
            sum += gifts[i];
        }
        return sum;
    }
}
