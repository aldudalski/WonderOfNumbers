/*
 * Persistence.java
 *
 * Created on 12 February 2007, 08:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package wonderofnumbers;

import java.util.LinkedList;

/**
 *
 * @author Alek
 */
public class Persistence {
    
    /** Creates a new instance of Persistence */
    public Persistence() {
    }
    
    /**-1 in linked list indicates an error*/
    static public LinkedList<Integer> calcPersistence(Integer number){
        LinkedList<String> stringPersistence = calcPersistence(number.toString());
        LinkedList<Integer> persistence = new LinkedList<Integer>();
        for (String i : stringPersistence){
            try {
                persistence.add(Integer.parseInt(i));
            } catch (Exception e) {
                persistence.add(-1);
            }
        }
        return persistence;
    }
    
    static public LinkedList<String> calcPersistence(String number) {
        LinkedList<String> persistence = new LinkedList<String>();
        
        int digit=2;
        
        while (digit > 1){
            Integer currentValue = 1;
            for (digit = 0; digit < number.length(); digit++) {
                Character currentDigit = number.charAt(digit);
                currentValue *= Integer.parseInt(currentDigit.toString());
            }
            persistence.add(number);
            number = currentValue.toString();
        }
        return persistence;
    }
    
}
