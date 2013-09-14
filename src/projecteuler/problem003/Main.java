package projecteuler.problem003;

import java.math.BigInteger;
import java.util.List;
import static projecteuler.ProjectEulerUtil.primeFactors;

/**
 * @author Joe
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> factors = primeFactors(new BigInteger("600851475143"));
        System.out.println(factors);
    }
}
