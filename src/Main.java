import leetcode.IProblemDefinition;
import leetcode.ProblemSolver;

public class Main {


    public static void main(String[] args) {
        IProblemDefinition solver = new ProblemSolver();
//        System.out.println(solver.p387_first_unique_char("dddccdbba"));
//        System.out.println(solver.p414_the_third_maximum(new int{}{4, 4, 4, 5}));
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(solver.p962_max_width_ramp(new int{}{9,8,1,0,1,9,4,0,4,1}));

        int[][] arr = {{33889,98676},{80071,89737},{44118,52565},{52992,84310},{78492,88209},{21695,67063},{84622,95452},{98048,98856},{98411,99433},{55333,56548},{65375,88566},{55011,62821},{48548,48656},{87396,94825},{55273,81868},{75629,91467}};
        System.out.println(solver.p1942_smallest_chair(arr, 6));
    }

}