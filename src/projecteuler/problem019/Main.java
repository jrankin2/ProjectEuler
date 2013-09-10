package projecteuler.problem019;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Joe
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("The answer to problem 19: " + countSundays());
    }
    
    private static int countSundays(){
        Calendar calendar = new GregorianCalendar();
        int sundays = 0;
        for(int y = 1901; y <= 2000; y++){
            calendar.set(Calendar.YEAR, y);
            for(int m = 0; m < 12; m++){
                calendar.set(Calendar.MONTH, m);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                    sundays++;
                }
            }
        }
        return sundays;
    }
    
}
