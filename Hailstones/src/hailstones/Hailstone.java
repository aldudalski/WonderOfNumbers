package hailstones;
/*
 * This code can calculate BigInteger large hailstone sequences 
 * Hailstone sequences work as follows: 
 *   Pick a starting point hailstone number
 *   If odd multiply by 3 add one 
 *   Else even divide by 2
 *   Stop calculating the sequence when you reach 1
 * Alek Zdziarski
 */
import java.math.BigInteger;
import java.util.ArrayList;

public class Hailstone {
	BigInteger termCount;
	BigInteger maximum;
	BigInteger item;
	BigInteger hailstoneId;
	Long calcTime, startTime;
	ArrayList<BigInteger> terms = new ArrayList<BigInteger>();
		
	Hailstone(){
		
	}
	
	public Hailstone (BigInteger hailstoneId){
		this.hailstoneId = hailstoneId;
		getHailstoneSequence();
	}

	void getHailstoneSequence(){
		startTime = System.nanoTime();
		termCount = BigInteger.ONE;
		maximum = hailstoneId;
		item = hailstoneId;

		do {
			termCount = termCount.add(BigInteger.ONE);// ++count
			terms.add(item); 
			if (item.testBit(0)) { //check if odd, i.e. first bit set
				item = item.shiftLeft(1).add(item).add(BigInteger.ONE);//multiply by 3 and add one (so item x 2 + item + 1
			} else {
				item = item.shiftRight(1); //item / 2 
			}

			maximum = maximum.max(item); //check whether this item is not the new maximum.
			if (item.equals(BigInteger.ONE)) break;
		} while (true);
		calcTime = System.nanoTime() - startTime;		
	}

	public BigInteger getTermCount() {
		return termCount;
	}

	public BigInteger getMaximum() {
		return maximum;
	}

	public BigInteger getHailstoneId() {
		return hailstoneId;
	}

	/**
	 * 
	 * @return calulation time in nano seconds if available using System.nanoTime()
	 */
	public Long getCalcTime() {
		return calcTime;
	}

	public ArrayList<BigInteger> getTerms() {
		return terms;
	}
	
}
