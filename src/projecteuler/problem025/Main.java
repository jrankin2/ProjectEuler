package projecteuler.problem025;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Joe
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("4782nd fibonacci number: " + nthFibonacci(4782));
        System.out.println("The answer to problem 25 is: " + 4782);
    }
    
    private static BigDecimal Phi(){
        return BigDecimal.valueOf(1).add(BigDecimal.valueOf(Math.sqrt(5))).divide(BigDecimal.valueOf(2));
    }
    
    private static BigDecimal negphi(){
        return BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(Math.sqrt(5))).divide(BigDecimal.valueOf(2));
    }
    
    //formula to find the nth fibonacci number:
    //http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html#formula
    private static BigInteger nthFibonacci(int n){
        BigDecimal result;
        result = Phi().pow(n).subtract(negphi().pow(n)).divide(BigDecimal.valueOf(Math.sqrt(5)));
        return result.toBigInteger();
    }
    
    private static int numBigIntDigits(BigInteger bigInt){
        return bigInt.toString().length();
    }
    
}
