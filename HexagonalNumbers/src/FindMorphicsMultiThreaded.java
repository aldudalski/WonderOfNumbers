import java.lang.management.ManagementFactory;
import java.math.BigInteger;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/*
 * This program will find Morphic Hexagonal numbers across as many threads as specified
 * Note they won't come out in any particular order and will benefit from a sort if you want to see 
 * them smallest to largest
 * 
 *
 */
public class FindMorphicsMultiThreaded implements Runnable, FindMorphicsMultiThreadedMBean {
	/**
	 * @param args
	 */
	BigInteger n;
	BigInteger threads;

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

	@Override
	public void run(){
		while (n.compareTo(new BigInteger("10000000"))<0){
			h = new HexagonalNumber(n);
			if (h.isMorphic()){
				System.err.println(h);
			}
			n=n.add(new BigInteger(threads.toString()));
		}		
		synchronized (this){
			threadsDoneCount++;
			notifyAll();
		}
	}
	
	void registerJMX(){
		try {
		     
	        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
	        mbs.registerMBean(this, new ObjectName("alek.numbers:type="+this.getClass().getName())); 
		} catch (Exception e){}		
	}
	
	public FindMorphicsMultiThreaded(Long thisThread, Long totalThreads){
		registerJMX();
		n=new BigInteger(thisThread.toString());
		threads = new BigInteger(totalThreads.toString());
		new Thread(this,thisThread.toString()).start();		
	}
	
	public static long threadsDoneCount = 0L;
	
	static final long TOTAL_THREADS = 20L; //probably broadly align this number to the number of cores
	

	
	public static void main(String[] args) {

		//performance test
		
		Long startTime, calcTime;
		FindMorphicsMultiThreaded k = null;			
		
		
		for (Long j=1L; j<=TOTAL_THREADS; j++){
			startTime = System.nanoTime();

			
			for (Long i=1L; i<=j;i++){
				k = new FindMorphicsMultiThreaded (i, j); //it needs to step over the other threads
				System.out.println("New thread"+i);
			}
			
			
			synchronized (k){
				if (threadsDoneCount!=j){
					try{
						k.wait();
					} catch (Exception i){}
				}
			}
			
			calcTime = System.nanoTime() - startTime; //nano seconds of calculation			
			System.out.println("Threads: "+j+", Calculation time: "+calcTime);
			FindMorphicsMultiThreaded.threadsDoneCount = 0L;
		}
		
	}

}
