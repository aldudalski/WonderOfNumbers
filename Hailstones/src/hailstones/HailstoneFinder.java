package hailstones;

import java.lang.management.ManagementFactory;
import java.math.BigInteger;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * This code creates a sequence of hailstone numbers which represent the next known longest
 * hailstone sequence
 * @author alek.zdziarski
 *
 */
public class HailstoneFinder implements HailstoneFinderMBean{
	
	

	static final BigInteger hailStoneStart = new BigInteger ("1");//("12235060455");
	/* (non-Javadoc)
	 * @see hailstones.HailstoneFinderMBean#getMax()
	 */
	
	public BigInteger getMax() {
		return max;
	}

	/* (non-Javadoc)
	 * @see hailstones.HailstoneFinderMBean#getTermCount()
	 */
	
	public BigInteger getTermCount() {
		return termCount;
	}

	/* (non-Javadoc)
	 * @see hailstones.HailstoneFinderMBean#getHail()
	 */
	
	public BigInteger getHailstoneNumber() {
		return hailstoneNumber;
	}

	BigInteger max= BigInteger.ZERO;
	BigInteger termCount;
	BigInteger hailstoneNumber; 

	void registerJMX(){
		try {
	        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
	        mbs.registerMBean(this, new ObjectName("alek.numbers:type="+this.getClass().getName())); 
		} catch (Exception e){}
	}
	
	public HailstoneFinder (){
		
		registerJMX();
		
		BigInteger i = hailStoneStart;
		
		do {

			Hailstone hail = new Hailstone(i); 
			hailstoneNumber = i;
			termCount = hail.getTermCount();

			if (termCount.compareTo(max)>0){ // ? termCount > max
				max = termCount;
				System.out.print("Hailstone ("+i.toString()+")="+termCount.toString()+" terms (calcTime="+hail.getCalcTime()+" microseconds) \n");
			}
		
			i = i.add(BigInteger.ONE);
		
		} while (true); // this is an infinite loop
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println ("Hailstone Finder running");
		new HailstoneFinder();

	}

}
