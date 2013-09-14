package projecteuler.problem007;

import static projecteuler.ProjectEulerUtil.nthPrime;

/**
 * @author Joe
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("The answer to problem 7 is: " + nthPrime(10001));
    }
    

/*
    private static int max(Set<Integer> set) {
        int maxNum = 0;
        for (int num : set) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
        return maxNum;
    }

    private static int min(Set<Integer> set) {
        int minNum = Integer.MAX_VALUE;
        for (int num : set) {
            if (num < minNum) {
                minNum = num;
            }
        }
        return minNum;
    }
    */
}
