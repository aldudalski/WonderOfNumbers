package alekzdz;

import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
	// First principles derivation of fibonacci numbers
        TreeMap<Integer,Integer> RabbitGenerations;

        RabbitGenerations = new TreeMap<Integer,Integer>(); //year, rabbit count

        Integer startYear = 1;
        Integer maxYear = 15;

        //create the rabbit pairs and count generations per year to MaxYear
        TwoRabbits Rabbits = new TwoRabbits(startYear, maxYear, null, RabbitGenerations);

        //show counts
        System.out.println("Rabbits first principles");
        for (Integer i:RabbitGenerations.keySet()){
            System.out.println("Rabbits Born in Year: "+i.toString()+" :  "+RabbitGenerations.get(i)+" Rabbit Pair"+(RabbitGenerations.get(i)));
        }
        startYear = (startYear==maxYear) ? startYear : maxYear;

        System.out.println();

        // this is incredible - Fibonacci numbers inside 1/89 - used BigDecimal to demonstrate
        System.out.println("One over 89 case study");
        System.out.println();
        new OneOver89();




    }
}
