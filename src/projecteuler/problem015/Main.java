package projecteuler.problem015;

import java.math.BigInteger;

/**
 * @author Joe
 * 
 * Problem Description:
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * http://projecteuler.net/project/images/p_015.gif
 * 
 * How many such routes are there through a 20×20 grid?

 */
public class Main {
    public static void main(String[] args) {
        System.out.println("factorial of 4: " + factorial(4));
        System.out.println("The answer to problem 15 is: " + centralBinomialCoefficient(20));
    }
    
    public static BigInteger factorial(int num){
        BigInteger result = BigInteger.valueOf(1);
        for(int i = 2; i <= num; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    
    /**
     * Finds the central binomial coefficient of a number (Middle number of 
     * Pascal's triangle by row).
     * @param num number to find the central binomial coefficient of.
     * @return central binomial coefficient of num
     */
    private static BigInteger centralBinomialCoefficient(int num){
        BigInteger result = factorial(num*2).divide(factorial(num).pow(2));
        return result;
    }
    
}
