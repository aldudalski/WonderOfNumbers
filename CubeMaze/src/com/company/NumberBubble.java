package com.company;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by alek.zdziarski on 3/6/2015.
 */
public class NumberBubble implements Comparable <NumberBubble> {

    LinkedList<NumberBubble> connections = new LinkedList<NumberBubble>();
    Integer value;
    Integer id;

    static NumberBubble startBubble;
    static NumberBubble endBubble;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NumberBubble(Integer value){
        this.value = value;
    }

    public Integer getTotalConnections(){
        return connections.size();
    }

    public LinkedList<NumberBubble> getConnectedBubbles() {
        return connections;
    }

    public LinkedList<NumberBubble> getConnectedBubbles(Boolean aToZ) {
        LinkedList<NumberBubble> sortedVersion = new LinkedList<NumberBubble>(connections);

        if (aToZ) Collections.sort(sortedVersion);
        else Collections.sort(sortedVersion, Collections.reverseOrder());

        return sortedVersion;

    }

    public void addConnection(NumberBubble newConnection) {
        this.connections.add(newConnection);
    }

    public Integer getValue() {
        return value;
    }

    public NumberBubble getStartingBubble() {
        return startBubble;
    }

    public void setStartingBubble() {
        startBubble = this;
    }

    public Boolean isEndingBubble() {
        return (this==endBubble)?true:false;
    }

    public void setEndingBubble() {
        endBubble = this;
    }

    @Override
    public String toString() {
        return ""+value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumberBubble that = (NumberBubble) o;

        if (connections != null ? !connections.equals(that.connections) : that.connections != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = value != null ? value.hashCode() : 0;
        return result;
    }

    @Override
    public int compareTo(NumberBubble o) {
        if (this.getValue()>o.getValue()) return 1;
        else if (this.getValue()==o.getValue()) return 0;
        else return -1;
    }
}
