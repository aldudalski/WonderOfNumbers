package alekzdz;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        Integer genMax = 10;
        Boolean printGen = false;

        if (args.length >= 2) {
            if (args.length >= 3) genMax = Integer.parseInt(args[2]);
            if (args.length >= 4) printGen = true;

            System.out.println("\nWalking the generations\n");

            Katydid k = new Katydid(genMax);
            k.kWalker(new BigInteger(args[0]), new BigInteger(args[1]), BigInteger.ONE, 1);

            if (printGen) {
                System.out.println(k.generationStore.toString());
            }

            System.out.println("\nFinding repeat numbers\n");
            k.findRepeatNumsGeneration();

            System.out.println("\ncomplete");
        } else {
            System.out.println("\nKatydid sequences v2\n");
            System.out.println("Arguments: c1, c2, [maxGenerations=10], [printSequence]");
            System.out.println("x-> c1x + c1 and x-> c2x +c2");
            System.out.println("maxGenerations defines how far down the tree to go, defaults to 10");
            System.out.println("printSequence any value here will print out the entire tree. defaults to false\n\n");

        }

    }
}
