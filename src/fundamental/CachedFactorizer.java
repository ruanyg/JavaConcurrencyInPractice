package fundamental;
import java.math.BigInteger;

import annotation.GuardedBy;
import annotation.ThreadSafe;

@ThreadSafe
public class CachedFactorizer {
	@GuardedBy("this")
	private BigInteger lastNumber;
	
	@GuardedBy("this")
	private BigInteger[] lastFactors;
	
	@GuardedBy("this")
	private long hits;
	
	@GuardedBy("this")
	private long cacheHits;
	
	public synchronized long getHits() {
		return hits;
	}
	
	public synchronized double getCacheHitRatio() {
		return (double) cacheHits / (double) hits;
	}
	
	public void service(BigInteger i) {
		BigInteger[] factors = null;
		synchronized (this) {
			++hits;
			if(i.equals(lastNumber)) {
				++cacheHits;
				factors = lastFactors.clone();
			}
		}
		if(factors == null) {
			factors = factor(i);
			synchronized (factors) {
				lastNumber = i;
				lastFactors = factors.clone();
			}
		}
	}

	private BigInteger[] factor(BigInteger i) {
		// TODO Auto-generated method stub
		return new BigInteger[] {i};
	}
	
	public static void main(String[] args) {
		
	}
}
