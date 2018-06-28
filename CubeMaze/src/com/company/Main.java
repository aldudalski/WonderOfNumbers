package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
    /*
    Trying new algorythm
    */
        NumberBubble startingBubble = new CubeMaze().getStartingBubbleInMaze();

        NextBubbleSolver nextBubbleSolver = new NextBubbleSolver(new LinkedList<NumberBubble>(),startingBubble,0,202);

    }
}
