package palindromenumbers;

import java.lang.management.ManagementFactory;
import java.math.BigInteger;
import java.util.LinkedList;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class PalindromeNumberFinder implements PalindromeNumberFinderMBean {

	LinkedList<PalindromeNumber> results = new LinkedList<PalindromeNumber>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * palindromenumbers.PalindromeNumberFinderMBean#getLastPalindromeNumber()
	 */

	/* (non-Javadoc)
	 * @see palindromenumbers.PalindromeNumberFinderMBean#getLastPalindromeNumber()
	 */
	@Override
	public BigInteger getLastPalindromeNumber() {
		try {
			return results.getLast().getPalindromeNumber();
		} catch (Exception e) {
			e.printStackTrace();
			return new BigInteger("0");
		}
	}
	
	BigInteger x,y;
	
	/* (non-Javadoc)
	 * @see palindromenumbers.PalindromeNumberFinderMBean#getX()
	 */
	@Override
	public BigInteger getX() {
		return x;
	}

	/* (non-Javadoc)
	 * @see palindromenumbers.PalindromeNumberFinderMBean#getY()
	 */
	@Override
	public BigInteger getY() {
		return y;
	}

	public PalindromeNumberFinder(BigInteger size) {

		// setup mbean
		try {

			MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
			mbs.registerMBean(this, new ObjectName("alek.numbers:type="
					+ this.getClass().getName()));
		} catch (Exception e) {
		}

		// find Palindromes
		System.out.println("x,y,Palindrome");
		PalindromeNumber palindromeNumber;
		x = new BigInteger("123456789");
		for (; x.compareTo(size) <= 0;) {
			y = new BigInteger("123456789");
			for (; y.compareTo(size) <= 0;) {
				try {
					palindromeNumber = new PalindromeNumber(x, y);
					results.add(palindromeNumber);
					System.out.println(x.toString() + "," + y.toString() + ","
							+ palindromeNumber.toString());
				} catch (Exception e) {
					// we're not dealing with a palindromeNumber
				}
				y = y.add(BigInteger.ONE);
			}
			x = x.add(BigInteger.ONE);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String... args) {
		final BigInteger GRIDSIZE = new BigInteger("12345678987");
		System.out.println("Beginning search for Palindrome Numbers\n Connect to mbean via jconsole to view progress \n");
		new PalindromeNumberFinder(GRIDSIZE);
	}

}
