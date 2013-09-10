package projecteuler.problem014;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Joe
 *
 * Problem Description: The following iterative sequence is defined for the set
 * of positive integers:
 *
 * n → n/2 (n is even) n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following
 * sequence: 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1)
 * contains 10 terms. Although it has not been proved yet (Collatz Problem), it
 * is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 */
public class Main {
    
    
    public static void main(String[] args) {
        //System.out.println("Collatz Algorithm Example test: " + collatzIterative(13));

        int longestChain = 0;
        int chainNumber = 0;
        int result;
        for (int i = 3; i <= 1000000; i+= 2) {
            result = collatzIterative(i);
            if (result > longestChain) {
                longestChain = result;
                chainNumber = i;
                //System.out.println("New Record: " + longestChain + ", " + i);
            }
        }
        //System.out.printf("Longest Chain: %d, Starting number: %d\n", longestChain, chainNumber);
        System.out.printf("Problem 14 Answer: %d", chainNumber);
    }
    
    

    
    /* Probably didn't need to use BigIntegers... most likely
     could have gotten away with longs
     */
    private static int collatzIterative(int start) {
        BigInteger step = BigInteger.valueOf(start);
        int numSteps = 1;
        
        while (step.compareTo(BigInteger.valueOf(1)) > 0) {
            numSteps++;// = (step > 1 ? ++numSteps : numSteps);
            if (step.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0)) == 0) {
                step = step.divide(BigInteger.valueOf(2));
            } else {
                step = step.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(1));
                //step = (step * 3) + 1;
            }
            
        }

        return numSteps;
    }
}
