package alekzdz;

import java.math.BigInteger;

/**
 * Created by azdziarski on 11/21/15.
 */
public class Smarandache {

    BigInteger s;
    StringBuffer st= new StringBuffer();

    public Smarandache (BigInteger n){
        // for i = 1 to n
        BigInteger i = BigInteger.ONE;
        do {
            st.append(i.toString());
            i = i.add(BigInteger.ONE);
        } while (i.compareTo(n)<=0);
        s = new BigInteger(st.toString());
    }

    public BigInteger Value (){
        return s;
    }

    public String toString (){
        return s.toString();
    }
}
