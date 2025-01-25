import java.math.BigInteger;

public class Simple_Implementation implements Algorithm {
    @Override
    public BigInteger[] run(BigInteger a,BigInteger b) {
        BigInteger t = b;
        b = a.add(b);
        a = t;
        return new BigInteger[]{a,b};
    }
}
