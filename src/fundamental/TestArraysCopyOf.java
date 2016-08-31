package fundamental;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by ruanyg on 16/8/31.
 */
public class TestArraysCopyOf {
    public static void main(String[] args) {
        BigInteger[] factors = new BigInteger[] {new BigInteger("111111"),
                new BigInteger("222222"), new BigInteger("333333")};
        BigInteger[] result = Arrays.copyOf(factors, factors.length);
        result[2] = new BigInteger("444444");
        for(int i = 0; i < factors.length; i++) {
            System.out.println(factors[i]);
        }
    }
}
