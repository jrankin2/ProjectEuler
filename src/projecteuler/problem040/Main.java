package projecteuler.problem040;

/**
 * @author Joe
 */
public class Main {
    public static void main(String[] args) {
        //System.out.println(champernownesConstant(1000000));
        //System.out.println(nthDigitInString(12, champernownesConstant(12)));
        System.out.println("The answer to problem 40 is: " + answer());
    }
    
    private static int answer(){
        int ans = 1;
        String constant = champernownesConstant(1000000);
        for(int i = 0; i < 7; i++){
            ans *= nthDigitInString((int)Math.pow(10, i), constant);
        }
        return ans;
    }
    
    private static String champernownesConstant(int minLength){
        StringBuilder constant = new StringBuilder();
        for(int i = 0; constant.length() < minLength; i++){
            constant.append(i+1);
        }
        return constant.toString();
    }
    
    private static int nthDigitInString(int n, String str){
        return Integer.valueOf(str.substring(n-1, n));
    }
}
