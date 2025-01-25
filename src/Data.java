import java.math.BigInteger;

public class Data {
    String FibonacciNumber;
    long crntTime;

    Data(String FibonacciNumber,long crntTime) {
        this.FibonacciNumber = FibonacciNumber;
        this.crntTime = crntTime;
    }

    String getData(){
        return FibonacciNumber + "," + crntTime;
    }
}
