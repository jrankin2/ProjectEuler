package projecteuler.problem024;

import java.util.ArrayList;
import java.util.List;
import static projecteuler.ProjectEulerUtil.nthLexicographicPermutation;
import static projecteuler.ProjectEulerUtil.factorialInt;

/**
 * @author Joe
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> entries = new ArrayList<Integer>(){{
            add(0);
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            add(9);
        }};
        
        System.out.println(factorialInt(10));
        int[] answer = nthLexicographicPermutation(entries, 1000000);
        System.out.print("The answer to problem 24 is: ");
        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i]);
        }
        System.out.println("");
    }
    
}
