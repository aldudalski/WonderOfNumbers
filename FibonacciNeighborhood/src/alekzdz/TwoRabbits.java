package alekzdz;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Created by mobi-alekzdziarski on 8/26/17.
 */
public class TwoRabbits {
    private Integer yearOfBirth;
    private LinkedList<TwoRabbits> offSpring;
    private TwoRabbits parents;
    //private HashMap<Integer,Integer> RabbitGenerations;

    TwoRabbits(Integer yOB, Integer maxYear, TwoRabbits parents, TreeMap<Integer,Integer> RabbitGenerations){
        yearOfBirth=yOB;
        Integer rabbits = RabbitGenerations.get(yearOfBirth);
        if (rabbits != null){
            rabbits+=1;
        }
        else {
            rabbits=1;
        }

        RabbitGenerations.put(yearOfBirth,rabbits);

        if (getYearOfBirth() <=maxYear) {
            offSpring = new LinkedList<TwoRabbits>();
            getOffSpring().add(new TwoRabbits(getYearOfBirth() + 1, maxYear, this, RabbitGenerations));
            getOffSpring().add(new TwoRabbits(getYearOfBirth() + 2, maxYear, this, RabbitGenerations));
            this.parents = parents;
        }
    }


    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public LinkedList<TwoRabbits> getOffSpring() {
        return offSpring;
    }

    public TwoRabbits getParents() {
        return parents;
    }
}
