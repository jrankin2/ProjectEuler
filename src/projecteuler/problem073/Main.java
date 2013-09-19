/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.problem073;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jrankin2
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("The answer to problem 73 is: " + getNumFractionsBetween(12000, (double)1/3, (double)1/2));
    }
    /*
    private static int getNumFractionsBetween(int num, double min, double max) {
        
        int result = 0;
        for (int d = 1; d <= num; d++) {
            for (int n = 1; n < d; n++) {
                //System.out.println("n:"+n+",d:"+d);
                if((double)n/d > min && (double)n/d < max){
                    result++;
                }
            }
        }
        return result;
    }
    */
    private static int getNumFractionsBetween(int num, double min, double max){
        Set<Double> fractions = new HashSet<Double>();
        for (int d = 1; d <= num; d++) {
            for (int n = 1; n < d; n++) {
                //System.out.println("n:"+n+",d:"+d);
                if((double)n/d > min && (double)n/d < max){
                    fractions.add((double)n/d);
                }
            }
        }
        
        
        return fractions.size();
    }
}
