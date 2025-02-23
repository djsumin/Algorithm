import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i= 2;i*i<=n;i++){
            while(n%i==0){
                n/=i;
                sb.append(i).append("\n");
            }
        }
        if(n>1){
            sb.append(n).append("\n");
        }
        System.out.println(sb.toString());


    }
}
