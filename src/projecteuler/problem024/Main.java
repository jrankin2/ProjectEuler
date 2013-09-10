package projecteuler.problem024;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import static projecteuler.problem015.Main.factorial;

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
        int[] answer = lexicographicPermutation(entries, 1000000);
        System.out.print("The answer to problem 24 is: ");
        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i]);
        }
        System.out.println("");
    }

    private static int factorialInt(int num) {
        return factorial(num).intValue();
    }

    //From: http://math.stackexchange.com/questions/60742/finding-the-n-th-lexicographic-permutation-of-a-string
    //If a0 < ... < an, then in the k-th permutation of {a0, ..., an} in lexiographic order,
    //The leading entry is aq if k=q(n!)+r for some q≥0 and 0<r≤n!. 
    private static int[] lexicographicPermutation(List<Integer> entries, int nthPermutation) {
        int numEntries = entries.size();
        int[] permutation = new int[numEntries];
        int remainder = nthPermutation;
        int k = 0;
        
        for (int i = 0; i < numEntries; i++) {
            for (int j = 0; j < numEntries-i; j++) {
                if (remainder - (j * factorialInt(numEntries-1-i)) > 0) {
                    k = j;
                    //System.out.println(remainder - (j * factorialInt(numEntries-1-i)));
                }
            }
            //System.out.println("k = " + k);
            remainder = (remainder - (k * factorialInt(numEntries-1-i)));
            //k is the 
            permutation[i] = entries.get(k);
            entries.remove(k);
        }
        
        return permutation;
    }
}
