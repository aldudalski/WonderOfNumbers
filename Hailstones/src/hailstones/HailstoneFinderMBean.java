package hailstones;

import java.math.BigInteger;

public interface HailstoneFinderMBean {

	public abstract BigInteger getMax();

	public abstract BigInteger getTermCount();

	public abstract BigInteger getHailstoneNumber();

}