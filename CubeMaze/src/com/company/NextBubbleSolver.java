package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by alek.zdziarski on 3/6/2015.
 */
public class NextBubbleSolver {

//    public NumberBubble getBubble() {
//        return Bubble;
//    }

    Integer totalAtThisBubble;
    static Integer maxSteps = 0;
    static LinkedList<NumberBubble> maxPath = new LinkedList<NumberBubble>();
    static Integer minSteps = 1000;//arbitrarily high number of steps. Ensures min is immediately set
    static LinkedList<NumberBubble> minPath = new LinkedList<NumberBubble>();

    /*
    Check that we have a unique path without repeating items
     */
    Boolean pathIsUnique(LinkedList<NumberBubble> bubblePath){
        Map<NumberBubble,Integer> histogram = new HashMap<NumberBubble, Integer>();
        Integer value;
        for (NumberBubble x : bubblePath) {
            value = histogram.get(x);
            if (value == null) histogram.put(x,1); //never seen before
            else return false;// histogram.put(x, value + 1); i.e. we've seen this before so PathIsUnique
        }
        return true;
    }
    /*
    This solver allows NumberBubbles to re-occur. i.e. you can return / loop back through a number
     */
    public NextBubbleSolver(LinkedList<NumberBubble> bubblesToHere, NumberBubble currentBubble,
                            Integer totalToThisBubble, Integer target) {

        totalAtThisBubble = totalToThisBubble + currentBubble.getValue();
        bubblesToHere.add(currentBubble);

        if (!currentBubble.isEndingBubble() && totalAtThisBubble < target && pathIsUnique(bubblesToHere)) {
            for (NumberBubble i : currentBubble.getConnectedBubbles(false)) {
                LinkedList<NumberBubble> bubblePath = new LinkedList<NumberBubble>();
                bubblePath.addAll(bubblesToHere);

                NextBubbleSolver t = new NextBubbleSolver(bubblePath, i, totalAtThisBubble, target);
            }

        } else {
            if (totalAtThisBubble.equals(target) && currentBubble.isEndingBubble()) {
                if (maxSteps < bubblesToHere.size()) {
                    maxPath.clear();
                    maxPath.addAll(bubblesToHere);
                    maxSteps = bubblesToHere.size();
                    System.out.println("NEW MAX: Total = " + this.totalAtThisBubble + ", steps = " + bubblesToHere.size() + ", Bubbles = " + bubblesToHere);
                } else
                if (minSteps > bubblesToHere.size()) {
                    minPath.clear();
                    minPath.addAll(bubblesToHere);
                    minSteps = bubblesToHere.size();
                    System.out.println("NEW MIN: Total = " + this.totalAtThisBubble + ", steps = " + bubblesToHere.size() + ", Bubbles = " + bubblesToHere);
                } else {
                    System.out.println("Total = " + this.totalAtThisBubble + ", steps = " + bubblesToHere.size() + ", Bubbles = " + bubblesToHere);
                }

            }
        }
    }

}
