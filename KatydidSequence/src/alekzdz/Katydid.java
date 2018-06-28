package alekzdz;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mobi-alekzdziarski on 11/25/16.
 */
public class Katydid {

    Integer genMax = 10;
    HashMap<Integer, ArrayList<BigInteger>> generationStore = new HashMap<Integer,ArrayList<BigInteger>>();

    Katydid(Integer gm){
        genMax = gm;
    }

    protected BigInteger katydid(BigInteger c, BigInteger X){
        return c.add(c.multiply(X));
    }

    public void kWalker(BigInteger c1, BigInteger c2, BigInteger X, Integer generation){
        if (generation > genMax) return;

        if (generationStore.containsKey(generation)) {
            generationStore.get(generation).add(X);
        } else {
            ArrayList<BigInteger> arrayList = new ArrayList<BigInteger>();
            arrayList.add(X);
            generationStore.put(generation, arrayList);
        }
        kWalker (c1, c2, katydid(c1, X),generation+1);
        kWalker (c1, c2, katydid(c2, X),generation+1);
    }

    public void findRepeatNumsGeneration(){
        HashMap<BigInteger, Integer> numbersList = new HashMap<BigInteger, Integer>();
        for (Integer gen:generationStore.keySet()) {
            System.out.println ("Finding repeat nums for generation "+gen);

            for (BigInteger x: generationStore.get(gen)){
                if (numbersList.containsKey(x)){
                    numbersList.put(x,numbersList.get(x)+1);
                    System.out.println("Number "+x.toString()+" repeats by generation "+gen);
                    return;
                }
                else numbersList.put(x, 1);
            }
        }
        System.out.println("No repeats found");
    }

}
