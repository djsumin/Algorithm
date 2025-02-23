import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        String operator = br.readLine();
        BigInteger b = new BigInteger(br.readLine());

        BigInteger ans = new BigInteger(String.valueOf(0));

        if(operator.equals("+")) {
            ans = a.add(b);
        } else if(operator.equals("*")) {
            ans = a.multiply(b);
        }
        System.out.println(ans);

    }
}
