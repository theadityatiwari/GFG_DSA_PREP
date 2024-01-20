//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(int N, int[] fruits) {
        int windowStart = 0;
        int maxFruits = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int windowEnd = 0; windowEnd < N;windowEnd++){
            int rightNum = fruits[windowEnd];
            map.put(rightNum,map.getOrDefault(rightNum,0)+1);
            while(map.size()>2){
                int leftNum = fruits[windowStart];
                map.put(leftNum,map.get(leftNum)-1);
                if(map.get(leftNum)==0){
                    map.remove(leftNum);
                }
                windowStart++;
            }
            if(map.size()==2)
             maxFruits = Math.max(maxFruits,windowEnd-windowStart +1);
            
        }
        
        return maxFruits;
    }
}