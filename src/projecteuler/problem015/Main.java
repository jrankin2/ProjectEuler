package projecteuler.problem015;

import java.math.BigInteger;
import static projecteuler.ProjectEulerUtil.factorial;
import static projecteuler.ProjectEulerUtil.centralBinomialCoefficient;

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
    
    
    
    
    
}
