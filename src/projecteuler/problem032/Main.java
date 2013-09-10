package projecteuler.problem032;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Joe
 */
public class Main {
    public static void main(String[] args) {
        //System.out.println(isProductIdentityPandigital(39, 186, 9));
        
        System.out.println("The answer to problem 32 is: " + collectionSum(productsWithPandigitalIdentities(9)));
        
    }
    
    private static Set<Integer> productsWithPandigitalIdentities(int numDigits){
        Set<Integer> pandigitalProducts = new HashSet<Integer>();
        for(int i = 0; i < 10000; i++){
            for(int j = 0; j < 1000; j++){
                if(isProductIdentityPandigital(i, j, numDigits)){
                    pandigitalProducts.add(i*j);
                }
            }
        }
        return pandigitalProducts;
    }
    
    /**
     * Returns true if a*b produces a pandigital product identity.
     * @param a
     * @param b
     * @return 
     */
    private static boolean isProductIdentityPandigital(int a, int b, int numDigits){
        int product = a * b;
        String digits = "" + a + b + product;
        if(numDigits > 0 && numDigits != digits.length()){
            return false;
        }
        List<Integer> listDigits = new ArrayList<Integer>();
        for(int i = 0; i < digits.length(); i++){
            listDigits.add(Integer.valueOf(digits.substring(i, i+1)));
        }
        for(int i = 0; i < listDigits.size(); i++){
            if(!listDigits.contains(i+1)){
                return false;
            }
        }
        return true;
    }
    
    private static int collectionSum(Collection<Integer> list){
        int sum=0;
        for(int a : list){
            sum += a;
        }
        return sum;
    }
    
    
}
