package hailstones;

import java.lang.management.ManagementFactory;
import java.math.BigInteger;
import java.net.UnknownHostException;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;


public class HailstoneFinderMultiThreaded implements Runnable, HailstoneFinderMultiThreadedMBean {

	BigInteger max= BigInteger.ZERO;
	BigInteger termCount;
	BigInteger hailstoneNumber; 
	BigInteger step;
	BigInteger i;
	BigInteger start;
	DB db;
	DBCollection hsMax;
	
	void registerJMX(){
		try {
	        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
	        mbs.registerMBean(this, new ObjectName("alek.numbers:type="+this.getClass().getName())); 
		} catch (Exception e){}
	}
	
	public HailstoneFinderMultiThreaded (BigInteger start, BigInteger step) throws UnknownHostException{
		registerJMX();
		this.step = step;
		this.start = start;
		db = Mongo.connect(new DBAddress("127.0.0.1","local"));
		hsMax = db.getCollection("hsMax");
		new Thread(this,start.toString()).start();

	}

	public void run(){		
		i=start;
		do {
			Hailstone hail = new Hailstone(i); 
			termCount = hail.getTermCount();
			hailstoneNumber = i;

			if (termCount.compareTo(max)>0){ // ? termCount > max
				max = termCount;
				System.out.print("MULTI["+start.toString()+"/"+step.toString()+"] Hailstone ("+i.toString()+")="+termCount.toString()+" terms (calcTime="+hail.getCalcTime()+" microseconds) \n");

				//note for sortability converting to long - won't work for very big int.
				DBObject record = BasicDBObjectBuilder.start()
						.add("_id",hail.hailstoneId.longValue())
						.append("terms",hail.getTermCount().longValue())
						.append("maximum",hail.getMaximum().longValue())
						.append("timeMicro",hail.getCalcTime().longValue())
						.get();
				hsMax.save(record);
			}

			i = i.add(step);
//			System.out.println("i = "+i.toString());

		} while (true); // this is an infinite loop	
//		} while (i.compareTo(new BigInteger("20"))<0); // this is an infinite loop	
	}

	public static void cleanUpData() throws UnknownHostException{

		DB db;
		DBCollection hsMax;
		db = Mongo.connect(new DBAddress("127.0.0.1","local"));
		hsMax = db.getCollection("hsMax");
		Long currentMax;

		Long findFromId = 1L;

		do {
			DBObject sortQuery = 
					BasicDBObjectBuilder.start()
					.add("_id", 
							BasicDBObjectBuilder.start().add("$gt",findFromId).get()).get();
System.out.println("Running Curser From: "+findFromId);
			DBCursor cursor = hsMax.find().sort(sortQuery);
			try {
				if (cursor.hasNext()){
					DBObject firstMax = cursor.next();
					currentMax = Long.parseLong(firstMax.get("maximum").toString());
System.out.println("currentMax = "+currentMax);
					while(cursor.hasNext()) {
						DBObject record = cursor.next();
						System.out.println("CURSOR:  "+record);
						Long recordMax = Long.parseLong(record.get("maximum").toString());
						findFromId = Long.parseLong(record.get("_id").toString());
						System.out.println("findFromId: "+findFromId+", recordMax: "+recordMax);
						if (recordMax>currentMax){
							currentMax=recordMax;
						} else {
							System.out.println("Removing: "+record);
							hsMax.remove(record);
						}
					}
				}
			} catch (Exception e){
				System.out.println("Reached the end of records: "+e.toString());
			} finally {
				cursor.close();
			}
		} while (true);
	}

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
//		Long totalThreads = Long.parseLong(args[0]);
		Long totalThreads = Long.parseLong("20");
		Long offSet = 1L;//537099606L;
		System.out.println("Threads "+totalThreads.toString());
		for (Long i=1L; i<=totalThreads;i++){
			Long startPoint = offSet + i;
			new HailstoneFinderMultiThreaded (
					new BigInteger(startPoint.toString()), //starting point for this thread
					new BigInteger(totalThreads.toString())); //it needs to step over the other threads			
		}
//		cleanUpData();
	}

	@Override
	public BigInteger getMax() {
		return this.max;
	}

	@Override
	public BigInteger getTermCount() {
		return this.getTermCount();
	}

	@Override
	public BigInteger getHailstoneNumber() {
		return null;
	}

}
