package projecteuler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Joe
 */
public class ProjectEulerUtil {

    /**
     *
     * @param start
     * @return
     */
    public static int collatzIterative(int start) {
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

    /**
     * Finds the central binomial coefficient of a number (Middle number of
     * Pascal's triangle by row).
     *
     * @param num number to find the central binomial coefficient of.
     * @return central binomial coefficient of num
     */
    public static BigInteger centralBinomialCoefficient(int num) {
        BigInteger result = factorial(num * 2).divide(factorial(num).pow(2));
        return result;
    }

    /**
     *
     * @param num
     * @return
     */
    public static BigInteger factorial(int num) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static int factorialInt(int num) {
        return factorial(num).intValue();
    }

    /**
     *
     * @param string
     * @return
     */
    public static int[] stringToDigitArray(String string) {
        int[] digits = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            digits[i] = Integer.valueOf(string.substring(i, i + 1));
        }
        return digits;
    }

    /**
     *
     * @param array
     * @return
     */
    public static int intArraySum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    //From: http://math.stackexchange.com/questions/60742/finding-the-n-th-lexicographic-permutation-of-a-string
    //If a0 < ... < an, then in the k-th permutation of {a0, ..., an} in lexiographic order,
    //The leading entry is aq if k=q(n!)+r for some q≥0 and 0<r≤n!. 
    public static int[] nthLexicographicPermutation(List<Integer> entries, int n) {
        int numEntries = entries.size();
        int[] permutation = new int[numEntries];
        int remainder = n;
        int k = 0;

        for (int i = 0; i < numEntries; i++) {
            for (int j = 0; j < numEntries - i; j++) {
                if (remainder - (j * factorialInt(numEntries - 1 - i)) > 0) {
                    k = j;
                    //System.out.println(remainder - (j * factorialInt(numEntries-1-i)));
                }
            }
            //System.out.println("k = " + k);
            remainder = (remainder - (k * factorialInt(numEntries - 1 - i)));
            //k is the 
            permutation[i] = entries.get(k);
            entries.remove(k);
        }

        return permutation;
    }

    public static BigDecimal Phi() {
        return BigDecimal.valueOf(1).add(BigDecimal.valueOf(Math.sqrt(5))).divide(BigDecimal.valueOf(2));
    }

    public static BigDecimal negphi() {
        return BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(Math.sqrt(5))).divide(BigDecimal.valueOf(2));
    }

    //formula to find the nth fibonacci number:
    //http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html#formula
    public static BigInteger nthFibonacci(int n) {
        BigDecimal result;
        result = Phi().pow(n).subtract(negphi().pow(n)).divide(BigDecimal.valueOf(Math.sqrt(5)));
        return result.toBigInteger();
    }

    public static int numBigIntDigits(BigInteger bigInt) {
        return bigInt.toString().length();
    }

    public static int numDistinctPowers(int aMin, int aMax, int bMin, int bMax) {
        Set<Double> distinctPowers = new HashSet<Double>();
        for (int i = aMin; i <= aMax; i++) {
            for (int j = bMin; j <= bMax; j++) {
                distinctPowers.add(Math.pow(i, j));
            }
        }
        return distinctPowers.size();
    }

    public static List<Integer> primeFactors(BigInteger n) {
        List<Integer> factors = new ArrayList<Integer>();

        BigInteger i = BigInteger.valueOf(2);
        while (n.compareTo(BigInteger.ONE) > 0) {
            while (n.mod(i).compareTo(BigInteger.ZERO) == 0) {
                factors.add(i.intValue());
                n = n.divide(i);
            }
            i = i.add(BigInteger.ONE);
            if (i.multiply(i).compareTo(n) > 0) {
                if (n.compareTo(BigInteger.ONE) > 0) {
                    factors.add(n.intValue());
                }
                break;
            }
        }

        return factors;
    }

    /**
     * Returns the nth prime (under 10 million).
     * @param n n
     * @return nth prime.
     */
    public static int nthPrime(int n) {
        boolean[] primes = primesArray(10000000);
        int count = 0;
        for (int i = 2; i < primes.length; ++i) {
            if (primes[i]) {
                ++count;
                if (count == n) {
                    return i;
                }
            }
        }
        return 0;//shouldn't happen for primes under 10 million.
    }

    /**
     * Returns a boolean array. For each index, true=prime, false=composite
     * @param size size of array to get - retrieves all primes, 2 - size.
     * @return array of booleans stating whether i is prime for arr[i].
     */
    public static boolean[] primesArray(int size) {
        boolean[] primes = new boolean[size];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i < primes.length; ++i) {
            if (primes[i]) {
                for (int j = i + i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
    
    
    
    
    public static int[][] listToArray(List<int[]> list) {
        System.out.println(list);
        int[][] array = new int[list.size()][list.get(list.size() - 1).length];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
