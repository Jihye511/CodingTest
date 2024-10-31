import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] time = new int[prices.length];
        
        for(int i = 0; i<prices.length; i++) {
            int cur = prices[i];
            int count = 0;
            for(int j = i+1; j<prices.length; j++) {
                count++;
                if(cur>prices[j]) break;
            }
            time[i] = count;
        }
        return time;
    }
}