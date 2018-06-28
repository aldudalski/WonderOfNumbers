package alekzdz;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Collections;

/**
 * Created by mobi-alekzdziarski on 8/26/17.
 */
public class OneOver89 {

   OneOver89(){
       Integer fib=1;
       Integer fibBeforeLast;
       Integer fibLast=0;
       Integer zeroesCount = 0;
       BigDecimal total = new BigDecimal(0.0);
       String zeroes="";
       Boolean reduce = false;

       //can't go much above 45 iterations before needing to convert this code to BigInteger for fib
       for (int i=0; i<45; i++){
           zeroesCount+=1;
           if (fibLast.toString().length()<fib.toString().length()) reduce = true;
           if (reduce){
               zeroesCount-=1;
               reduce = false;
           }
           zeroes = String.join("", Collections.nCopies(zeroesCount, "0"));
           String t = "0."+zeroes+fib.toString();
//           System.out.println("zeroescount:   "+zeroesCount.toString()+": "+t);
           total = total.add(BigDecimal.valueOf(Double.valueOf(t)));

           System.out.println(t+":  "+total.toString());
           fibBeforeLast = fibLast;
           fibLast=fib;
           fib=fib+fibBeforeLast;
       }
       BigDecimal oneOver89;
       oneOver89 = BigDecimal.ONE;
       //note going to truncate decimals to 35 places and compare (with 45 iterations above accuracy to 35 places due to 1134903170 fibonaci being 10 long
       oneOver89 = oneOver89.divide(new BigDecimal(89), 35, BigDecimal.ROUND_HALF_DOWN); //1/89d
       System.out.println("\n\n One Over 89    : "+oneOver89);
       System.out.println(" Fibonacci Total: "+total.divide(BigDecimal.ONE,35,BigDecimal.ROUND_HALF_DOWN)); //truncate to 35 places

   }
}
