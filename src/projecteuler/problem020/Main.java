package projecteuler.problem020;

import static projecteuler.problem015.Main.factorial;

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
        int answer = intArraySum(stringToDigits(factorial(100).toString()));
        System.out.println("The answer to problem 20 is: " + answer);
    }
    
    private static int intArraySum(int[] array){
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }
    
    private static int[] stringToDigits(String string){
        int[] digits = new int[string.length()];
        for(int i = 0; i < string.length(); i++){
            digits[i] = Integer.valueOf(string.substring(i, i+1));
        }
        return digits;
    }
}
