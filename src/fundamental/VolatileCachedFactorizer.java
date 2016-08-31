package fundamental;

import annotation.ThreadSafe;

import java.math.BigInteger;

/**
 * Created by ruanyg on 16/8/31.
 */
@ThreadSafe
public class VolatileCachedFactorizer {
    private volatile OneValueCache cache = new OneValueCache(null, null);

    public void service(BigInteger i) {
        BigInteger[] factors = cache.getFactors(i);
        if(factors == null) {
            factors = factor(i);
            cache = new OneValueCache(i, factors);
        }
    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[0];
    }
}
