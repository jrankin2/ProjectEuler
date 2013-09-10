package projecteuler.problem030;

import static projecteuler.ProjectEulerUtil.stringToDigitArray;

/**
 * @author Joe
 */
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 2; i < 1000000; i++){
            if(isDigitPowerSum(i, 5)){
                sum += i;
            }
        }
        System.out.println(sum);
    }
    
    /**
     * Returns whether num equals the sum of each of its digits raised to the power of pow
     * @param num number to check
     * @param pow power to raise each digit to
     * @return boolean: whether num equals the sum of each of its digits raised to the power of pow
     */
    private static boolean isDigitPowerSum(int num, int pow){
        int[] digits = stringToDigitArray(String.valueOf(num));
        int sum = 0;
        for(int i : digits){
            sum += Math.pow(i, pow);
        }
        return sum == num;
    }
    
}
