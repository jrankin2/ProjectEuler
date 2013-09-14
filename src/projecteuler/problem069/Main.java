package projecteuler.problem069;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Joe
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(eulersTotient(9));
        System.out.println(answer());
    }

    private static int answer() {
        int largest = 0;
        double largestResult = 0;
        double result;
        for (int i = 2; i <= 1000000; i++) {
            result = (double) i / eulersTotient(i);
            if (result > largestResult) {
                largestResult = result;
                largest = i;
                //System.out.println(i + "," + result);
            }
        }
        return largest;
    }

    /**
     * Gets the number of relative primes from 1...num This is really
     * inefficient. Like really really inefficient.
     *
     * @param num an integer
     * @return number of relative primes to num.
     */
    private static int eulersTotient(int num) {
        int result = num; //this will be the totient at the end of the sample
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                result /= i;
                result *= (i - 1);
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
        if (num > 1) { // now n is the largest prime divisor
            result /= num;
            result *= (num - 1);
        }
        return result;
    }
}
