package alekzdz;

import java.math.BigInteger;

/**
 * Created by azdziarski on 11/21/15.
 */
public class PrimeCheck {

    BigInteger n;
    public PrimeCheck(BigInteger n){
        this.n = n;
    }

    public Boolean isPrime() {
        //check for less than 1 and for first primes: 2 & 3
        if (n.toString().equals("2")||n.toString().equals("3")) return true;
        else if (n.compareTo(BigInteger.ONE)<=0) return false;

        //check last digit is not even
        String evens[] = {"0", "2", "4", "6", "8"};
        for (String i : evens) {
            if (n.toString().endsWith(i)) return false;
        }
        //find n / 2
        BigInteger halfN = n.shiftRight(1);
        //for i = 3 to halfN step 2 (ideally want to find sqrt
        BigInteger i = new BigInteger("3");
        BigInteger step2 = new BigInteger("2");
        do {
            if (n.mod(i).compareTo(BigInteger.ZERO)==0) return false;
            i=i.add(step2);
        } while (i.compareTo(halfN) <= 0);
        return true;
    }
}
