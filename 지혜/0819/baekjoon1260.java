import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1260 {
    static StringBuilder sb = new StringBuilder();
    static int N,M,V;
    static int[][] arr;
    static boolean[] check;
    static int[][] dfsdata,bfsdata;
    static ArrayList<Integer> stack;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        check = new boolean[N+1];
        //배열에 연결 네트워크 넣기
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] =1;
        }
        dfs(V);
        sb.append("\n");
        check = new boolean[N+1];

        bfs(V);
        System.out.println(sb.toString());


    }
    public static void dfs(int start){
        check[start] =true;
        sb.append(start +" ");

        for(int i =0; i<=N; i++){
            if(arr[start][i] ==1 && !check[i]){
                dfs(i);
            }
        }
    }
    public static void bfs(int start){
        q.add(start);
        check[start] =true;

        while(!q.isEmpty()){
            start = q.poll();
            sb.append(start +" ");

            for(int i =1; i<=N; i++){
                if(arr[start][i] == 1&& !check[i]){
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
