import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville) {
            pq.add(i);
        }
        
        while(pq.peek() < K) {
            if(pq.size()<2) return -1;
            int cur = pq.poll()+pq.poll()*2;
            answer++;
            pq.add(cur);
        }
        
        return answer;
    }
}