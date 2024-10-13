import leetcode.IProblemDefinition;
import leetcode.ProblemSolver;

public class Main {

    public static int maxRepeating(String sequence, String word) {
        int maxRepeating = 0;
        System.out.println("sequence: " + sequence);
        System.out.println("word: " + word);
        int m = word.length();
        for (int i = word.length(); i <= sequence.length(); i++) {
            if (sequence.substring(i - m, i).equals(word)) {
                maxRepeating++;
            }
        }
        return maxRepeating;
    }


    public static void main(String[] args) {
        IProblemDefinition solver = new ProblemSolver();
//        System.out.println(solver.p387_first_unique_char("dddccdbba"));
//        System.out.println(solver.p414_the_third_maximum(new int{}{4, 4, 4, 5}));
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(solver.p962_max_width_ramp(new int{}{9,8,1,0,1,9,4,0,4,1}));

//        System.out.println(solver.p1137_tribonacci(25));
        String s = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String y = "aaaba";
        System.out.println(maxRepeating(s, y));
    }

}