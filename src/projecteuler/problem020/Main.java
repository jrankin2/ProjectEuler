package projecteuler.problem020;

import static projecteuler.ProjectEulerUtil.factorial;
import static projecteuler.ProjectEulerUtil.stringToDigitArray;
import static projecteuler.ProjectEulerUtil.intArraySum;

/**
 * @author Joe
 * 
 * Problem Description:
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,and the sum of the 
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 */
public class Main {
    public static void main(String[] args) {
        int answer = intArraySum(stringToDigitArray(factorial(100).toString()));
        System.out.println("The answer to problem 20 is: " + answer);
    }
    
    
    
    
}
