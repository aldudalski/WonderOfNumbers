import java.lang.management.ManagementFactory;
import java.math.BigInteger;

import javax.management.MBeanServer;
import javax.management.ObjectName;


public class FindMorphics implements FindMorphicsMBean {
	/**
	 * @param args
	 */
	BigInteger n = new BigInteger("1");

	HexagonalNumber h;	

	/* (non-Javadoc)
	 * @see FindMorphicsMBean#getN()
	 */
	@Override
	public BigInteger getN() {
		return n;
	}

	/* (non-Javadoc)
	 * @see FindMorphicsMBean#setN(java.math.BigInteger)
	 */
	@Override
	public void setN(BigInteger n) {
		this.n = n;
	}

	/* (non-Javadoc)
	 * @see FindMorphicsMBean#getH()
	 */
	@Override
	public BigInteger getH() {
		return h.getH();
	}


	public void startSearch(){
		while (true){//n.compareTo(new BigInteger("6000000000000"))<0){
			h = new HexagonalNumber(n);
			if (h.isMorphic()){
				System.out.println(h);
			}
			n=n.add(new BigInteger("1"));
		}
		
	}
	
	public FindMorphics(){
		try {
		     
	        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
//	        ObjectName name = new ObjectName("wonderofnumbers.HexagonalNumbers:type=Morphics"); 
	        mbs.registerMBean(this, new ObjectName("alek.numbers:type="+this.getClass().getName())); 
		} catch (Exception e){}
	}
	
	public static void main(String[] args) {
		FindMorphics f = new FindMorphics();
		f.startSearch();
	}

}
