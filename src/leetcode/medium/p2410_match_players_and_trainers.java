package leetcode.medium;

import java.util.Arrays;

public class p2410_match_players_and_trainers {
    /*
     * Runtime 24 ms Beats 100.00%
     * 
     */
    public int match_players_and_trainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = trainers.length;
        int n = players.length;
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            while (j < m && trainers[j] < players[i]) {
                j++;
            }
            if (j == m) {
                return count;
            }
            count++;
            i++;
            j++;
        }
        return count;
    }
}
