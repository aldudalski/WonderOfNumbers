package alekzdz;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        //trick question as non- known up to Smarandache 270,000 - it would be useful to develop a multithreaded version
        //rather easy as you're not building on the last result but rather solving for the current number. So could do x cores worth of work
        System.out.print("Progress: ");
        for (Integer i=1; i<=270000; i++) {
            BigInteger c = new Smarandache(new BigInteger(i.toString())).Value();
            if (new PrimeCheck(c).isPrime()){
            System.out.println("\n"+i.toString()+" : "+c.toString()+" : Prime \n");}
            if (i%10==0) System.out.print(i+", ");// show progress for every 10 you do
        }
        System.out.println("\nCOMPLETE");
    }
}
