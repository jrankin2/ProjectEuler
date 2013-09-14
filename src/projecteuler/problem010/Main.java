package projecteuler.problem010;

import java.math.BigInteger;

/**
 * @author Joe
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(primesSum(2000000));
    }
    
    private static BigInteger primesSum(int maxPrime){
        boolean[] primes = projecteuler.ProjectEulerUtil.primesArray(10000000);
        BigInteger sum = BigInteger.ZERO;
        for(int i = 2; i <= maxPrime; i++){
            if(primes[i]){
                sum = sum.add(BigInteger.valueOf(i));
            }
        }
        return sum;
    }
}
