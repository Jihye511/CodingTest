import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            long[][] d = new long[M+1][M+1];
            
            for(int i=0; i<=M; i++) {
                d[i][0] = 1;
                d[i][1] = i;
                d[i][i] = 1;
            }
            
            for(int i=1; i<=M; i++) {
                for(int j=1; j<=i; j++) {
                    d[i][j] = d[i-1][j-1] + d[i-1][j];
                }
            }
            sb.append(d[M][N]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}